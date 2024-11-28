package com.example.service;

import com.example.model.ObraMaterial;
import com.example.repository.ObraMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraMaterialService {

    @Autowired
    private ObraMaterialRepository obraMaterialRepository;

    public ObraMaterial save(ObraMaterial obraMaterial) {
        return obraMaterialRepository.save(obraMaterial);
    }

    public List<ObraMaterial> findAll() {
        return obraMaterialRepository.findAll();
    }

    public Optional<ObraMaterial> findById(Long id) {
        return obraMaterialRepository.findById(id);
    }

    public ObraMaterial update(ObraMaterial obraMaterial) {
        return obraMaterialRepository.save(obraMaterial);
    }

    public void deleteById(Long id) {
        obraMaterialRepository.deleteById(id);
    }
}