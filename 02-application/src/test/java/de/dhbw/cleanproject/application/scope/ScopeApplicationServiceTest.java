package de.dhbw.cleanproject.application.scope;

import de.dhbw.cleanproject.application.scope.data.CreateScopeData;
import de.dhbw.cleanproject.application.scope.data.UpdateScopeData;
import de.dhbw.cleanproject.domain.models.Scope;
import de.dhbw.cleanproject.domain.repositories.ScopeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ScopeApplicationServiceTest {

    private ScopeRepository scopeRepository;
    private ScopeApplicationService scopeApplicationService;
    private UUID scopeId;
    private UUID userId;
    private Scope scope;
    private CreateScopeData createScopeData;
    private UpdateScopeData updateScopeData;

    @BeforeEach
    void setUp() {
        scopeRepository = mock(ScopeRepository.class);
        scopeApplicationService = new ScopeApplicationService(scopeRepository);
        scopeId = UUID.randomUUID();
        userId = UUID.randomUUID();
        scope = mock(Scope.class);
        createScopeData = mock(CreateScopeData.class);
        updateScopeData = mock(UpdateScopeData.class);
    }

    @Test
    void findScopeById_ValidScopeId_ReturnsOptionalWithScope() {
        when(scopeRepository.findScopeById(scopeId)).thenReturn(Optional.of(scope));

        Optional<Scope> result = scopeApplicationService.findScopeById(scopeId);

        assertTrue(result.isPresent());
        assertEquals(scope, result.get());
        verify(scopeRepository, times(1)).findScopeById(scopeId);
    }

    @Test
    void findScopeById_InvalidScopeId_ReturnsEmptyOptional() {
        when(scopeRepository.findScopeById(scopeId)).thenReturn(Optional.empty());

        Optional<Scope> result = scopeApplicationService.findScopeById(scopeId);

        assertTrue(result.isEmpty());
        verify(scopeRepository, times(1)).findScopeById(scopeId);
    }

    @Test
    void delete_ExistingScope_ReturnsTrueAndDeletesScope() {
        when(scopeRepository.findScopeById(scopeId)).thenReturn(Optional.of(scope));

        boolean result = scopeApplicationService.delete(userId, scopeId);

        assertTrue(result);
        verify(scopeRepository, times(1)).findScopeById(scopeId);
        verify(scopeRepository, times(1)).deleteById(scopeId);
    }

    @Test
    void delete_NonExistingScope_ReturnsFalse() {
        when(scopeRepository.findScopeById(scopeId)).thenReturn(Optional.empty());

        boolean result = scopeApplicationService.delete(userId, scopeId);

        assertFalse(result);
        verify(scopeRepository, times(1)).findScopeById(scopeId);
        verify(scopeRepository, never()).deleteById(scopeId);
    }

    @Test
    void findAllScopesByUserId_ValidUserId_ReturnsScopesList() {
        List<Scope> expectedScopes = Collections.singletonList(scope);
        when(scopeRepository.findByUserId(userId)).thenReturn(expectedScopes);

        List<Scope> result = scopeApplicationService.findAllScopesByUserId(userId);

        assertEquals(expectedScopes, result);
        verify(scopeRepository, times(1)).findByUserId(userId);
    }
}
