package com.example.service;

import com.example.model.Obra;
import com.example.repository.ObraRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObraServiceTest {

    @Mock
    private ObraRepository obraRepository;

    @InjectMocks
    private ObraService obraService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveObra() {
        Obra obra = new Obra();
        obra.setTotalGasto(1000.0);

        when(obraRepository.save(obra)).thenReturn(obra);

        Obra savedObra = obraService.save(obra);
        assertNotNull(savedObra);
        assertEquals(1000.0, savedObra.getTotalGasto());
    }

    @Test
    void testFindObraById() {
        Obra obra = new Obra();
        obra.setId(1L);
        obra.setTotalGasto(1000.0);

        when(obraRepository.findById(1L)).thenReturn(Optional.of(obra));

        Optional<Obra> foundObra = obraService.findById(1L);
        assertTrue(foundObra.isPresent());
        assertEquals(1000.0, foundObra.get().getTotalGasto());
    }

    // Additional tests for update and delete methods
}