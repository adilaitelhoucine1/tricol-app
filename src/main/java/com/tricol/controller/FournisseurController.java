package com.tricol.controller;


import com.tricol.model.Fournisseur;
import com.tricol.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping

    public List<Fournisseur> getAllFournisseus(){
        return fournisseurService.getAllFournisseus();
    }
    @GetMapping("/{id}")
    public Fournisseur  getFournisseurById(@PathVariable("id") long id){
        Optional<Fournisseur> optionalFournisseur= fournisseurService.getFournisseurById(id);
        if (optionalFournisseur.isPresent()){
           return optionalFournisseur.get();
        }else {
            return null;
        }
    }

}
