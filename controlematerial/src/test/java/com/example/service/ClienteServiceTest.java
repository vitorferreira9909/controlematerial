package com.example.service;

import com.example.model.Cliente;
import com.example.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    public ClienteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("João");

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente savedCliente = clienteService.save(cliente);
        assertNotNull(savedCliente);
        assertEquals("João", savedCliente.getNome());
    }

    @Test
    void testFindClienteById() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("João");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> foundCliente = clienteService.findById(1L);
        assertTrue(foundCliente.isPresent());
        assertEquals("João", foundCliente.get().getNome());
    }

    // Additional tests for update and delete methods
}