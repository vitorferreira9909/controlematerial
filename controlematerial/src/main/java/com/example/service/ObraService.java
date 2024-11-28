package com.example.service;

import com.example.model.Obra;
import com.example.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;

    public Obra save(Obra obra) {
        return obraRepository.save(obra);
    }

    public List<Obra> findAll() {
        return obraRepository.findAll();
    }

    public Optional<Obra> findById(Long id) {
        return obraRepository.findById(id);
    }

    public Obra update(Obra obra) {
        return obraRepository.save(obra);
    }

    public void deleteById(Long id) {
        obraRepository.deleteById(id);
    }
}