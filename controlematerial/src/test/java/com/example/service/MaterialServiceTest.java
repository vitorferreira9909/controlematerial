package com.example.service;

import com.example.model.Material;
import com.example.repository.MaterialRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MaterialServiceTest {

    @Mock
    private MaterialRepository materialRepository;

    @InjectMocks
    private MaterialService materialService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveMaterial() {
        Material material = new Material();
        material.setDescricao("Cimento");

        when(materialRepository.save(material)).thenReturn(material);

        Material savedMaterial = materialService.save(material);
        assertNotNull(savedMaterial);
        assertEquals("Cimento", savedMaterial.getDescricao());
    }

    @Test
    void testFindMaterialById() {
        Material material = new Material();
        material.setId(1L);
        material.setDescricao("Cimento");

        when(materialRepository.findById(1L)).thenReturn(Optional.of(material));

        Optional<Material> foundMaterial = materialService.findById(1L);
        assertTrue(foundMaterial.isPresent());
        assertEquals("Cimento", foundMaterial.get().getDescricao());
    }

    // Additional tests for update and delete methods
}