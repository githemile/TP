package com.ADJIGBONON_LOVI.ApiSI.service;


import com.ADJIGBONON_LOVI.ApiSI.entity.Compte;
import com.ADJIGBONON_LOVI.ApiSI.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> showCompte() {
        return compteRepository.findAll();
    }

    public Compte getOneCompte(Integer id) {
        return compteRepository.findById(id).get();
    }

    public Compte saveCompte(Compte Compte) {
        return compteRepository.save(Compte);
    }

    public void deleteCompte(Integer id) {
        compteRepository.deleteById(id);
    }


}
