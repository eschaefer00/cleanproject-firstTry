package de.dhbw.plugins.rest.scope;

import de.dhbw.cleanproject.adapter.mappers.scope.update.RawToUpdateScopeDataMapper;
import de.dhbw.cleanproject.application.scope.ScopeApplication;
import de.dhbw.cleanproject.application.user.UserApplication;
import de.dhbw.cleanproject.domain.models.Scope;
import de.dhbw.plugins.rest.scope.data.UpdateScopeData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user/{userId}/scope/{scopeId}")
@RequiredArgsConstructor
public class ScopeController {
    private final ScopeApplication scopeApplication;
    private final UserApplication userApplication;
    private RawToUpdateScopeDataMapper rawToUpdateScopeDataMapper;

    @GetMapping
    public ResponseEntity<Scope> findOne(@PathVariable("scopeId") UUID scopeId, @PathVariable("userId") UUID userId){
        if(!userApplication.existsById(userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        Optional<Scope> optionalScope = scopeApplication.findScopeById(scopeId);
        if (optionalScope.isEmpty()) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        return ResponseEntity.ok(optionalScope.get());
    }

    @PatchMapping
    public ResponseEntity<Scope> update(@PathVariable("scopeId") UUID scopeId, @PathVariable("userId") UUID userId, @Valid @RequestBody UpdateScopeData data) {
        if(!userApplication.existsById(userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        Optional<Scope> optionalScope = scopeApplication.findScopeById(scopeId);
        if (optionalScope.isEmpty()) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        optionalScope = scopeApplication.update(optionalScope.get(), rawToUpdateScopeDataMapper.apply(data));
        if (optionalScope.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(optionalScope.get());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("scopeId") UUID scopeId, @PathVariable("userId") UUID userId) {
        if (!scopeApplication.delete(userId, scopeId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
