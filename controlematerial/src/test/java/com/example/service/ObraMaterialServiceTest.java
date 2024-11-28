package com.example.service;

import com.example.model.ObraMaterial;
import com.example.repository.ObraMaterialRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObraMaterialServiceTest {

    @Mock
    private ObraMaterialRepository obraMaterialRepository;

    @InjectMocks
    private ObraMaterialService obraMaterialService;

    public ObraMaterialServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveObraMaterial() {
        ObraMaterial obraMaterial = new ObraMaterial();
        obraMaterial.setQuantidade(10);
        obraMaterial.setPreco(100.0);

        when(obraMaterialRepository.save(obraMaterial)).thenReturn(obraMaterial);

        ObraMaterial savedObraMaterial = obraMaterialService.save(obraMaterial);
        assertNotNull(savedObraMaterial);
        assertEquals(10, savedObraMaterial.getQuantidade());
        assertEquals(100.0, savedObraMaterial.getPreco());
    }

    @Test
    void testFindObraMaterialById() {
        ObraMaterial obraMaterial = new ObraMaterial();
        obraMaterial.setId(1L);
        obraMaterial.setQuantidade(10);
        obraMaterial.setPreco(100.0);

        when(obraMaterialRepository.findById(1L)).thenReturn(Optional.of(obraMaterial));

        Optional<ObraMaterial> foundObraMaterial = obraMaterialService.findById(1L);
        assertTrue(foundObraMaterial.isPresent());
        assertEquals(10, foundObraMaterial.get().getQuantidade());
        assertEquals(100.0, foundObraMaterial.get().getPreco());
    }

    // Additional tests for update and delete methods
}