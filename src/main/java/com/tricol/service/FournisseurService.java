package com.tricol.service;

import com.tricol.model.Fournisseur;
import com.tricol.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public  Fournisseur  updateFournisseur( Fournisseur fournisseur,  Long id){
       Optional<Fournisseur> fournisseur1=fournisseurRepository.findById(id);
        Fournisseur fournisseur_find=null;
       if (fournisseur1.isPresent()){
           fournisseur_find=fournisseur1.get();
       }
       fournisseur_find.setAdresse(fournisseur.getAdresse());
       fournisseur_find.setContact(fournisseur.getContact());
       fournisseur_find.setEmail(fournisseur.getEmail());
       fournisseur_find.setIce(fournisseur.getIce());
       fournisseur_find.setSociete(fournisseur.getSociete());
       fournisseur_find.setTelephone(fournisseur.getTelephone());
       fournisseur_find.setVille(fournisseur.getVille());
       return fournisseurRepository.save(fournisseur_find);

    }

    public  String  deleteFournisseur( Long id){
        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findById(id);
        if(fournisseurOptional.isPresent()){
            fournisseurRepository.delete(fournisseurOptional.get());
            return "delete avec succes";
        }else {
            return "Fournisseur makaynsh";
        }

    }

    public  Fournisseur addFournisseur(Fournisseur fournisseur){
        return fournisseurRepository.save(fournisseur);
    }
}
