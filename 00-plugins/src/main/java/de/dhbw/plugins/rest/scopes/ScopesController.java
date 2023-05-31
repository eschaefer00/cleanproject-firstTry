package de.dhbw.plugins.rest.scopes;

import de.dhbw.cleanproject.adapter.mappers.scope.create.RawToCreateScopeDataMapper;
import de.dhbw.cleanproject.application.scope.ScopeApplication;
import de.dhbw.cleanproject.application.user.UserApplication;
import de.dhbw.cleanproject.domain.models.Scope;
import de.dhbw.plugins.rest.model.scope.ScopePreviewModel;
import de.dhbw.plugins.rest.model.scope.mapper.ScopeToPreviewModelMapper;
import de.dhbw.plugins.rest.scopes.data.CreateScopeData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user/{userId}/scopes")
@RequiredArgsConstructor
public class ScopesController {
    private final ScopeApplication scopeApplication;
    private final UserApplication userApplication;
    private final ScopeToPreviewModelMapper scopeToPreviewModelMapper;
    private final RawToCreateScopeDataMapper rawToCreateScopeDataMapper;

    @GetMapping
    public ResponseEntity<List<ScopePreviewModel>> listAll(@PathVariable("userId") UUID userId) {
        if (!userApplication.existsById(userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        List<ScopePreviewModel> result = scopeApplication.findAllScopesByUserId(userId).stream().map(scopeToPreviewModelMapper::apply).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ScopePreviewModel> create(@PathVariable("userId") UUID userId, @Valid @RequestBody CreateScopeData data) {
        if (!userApplication.existsById(userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        Optional<Scope> optionalScope = scopeApplication.create(userId, rawToCreateScopeDataMapper.apply(data));
        return optionalScope.map(scope -> ResponseEntity.ok(scopeToPreviewModelMapper.apply(scope))).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
