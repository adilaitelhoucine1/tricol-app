package com.tricol.service;

import com.tricol.model.Fournisseur;
import com.tricol.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<Fournisseur> getAllFournisseus() {
        return fournisseurRepository.findAll();
    }

    public Optional<Fournisseur> getFournisseurById( long id){
        return fournisseurRepository.findById(id);
    }
}
