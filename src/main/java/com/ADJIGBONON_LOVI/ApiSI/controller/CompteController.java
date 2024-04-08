package com.ADJIGBONON_LOVI.ApiSI.controller;


import com.ADJIGBONON_LOVI.ApiSI.entity.Compte;
import com.ADJIGBONON_LOVI.ApiSI.entity.Transaction;
import com.ADJIGBONON_LOVI.ApiSI.repository.CompteRepository;
import com.ADJIGBONON_LOVI.ApiSI.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CompteController {
    @Autowired
    private CompteService compteService;

    @Autowired
    private CompteRepository compteRepository;







    @GetMapping("/comptes")
    public List<Compte> getAll() {
        return compteService.showCompte();
    }

    @GetMapping("/comptes/{id}")
    public Compte get(@PathVariable Integer id) {
        return compteService.getOneCompte(id);
    }

    @PostMapping("/comptes")
    public Compte save(@RequestBody Compte compte) {
        return compteService.saveCompte(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte update(@PathVariable Integer id, @RequestBody Compte compte) {
        compte.setId(id);
        return compteService.saveCompte(compte);
    }

    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable Integer id) {
        compteService.deleteCompte(id);
    }


    @GetMapping("/comptes/{id}/transactions")
    public List<Transaction> getTransactions(@PathVariable Integer id,
                                             @RequestParam(required = false) LocalDate startDate,
                                             @RequestParam(required = false) LocalDate endDate) {

        if (startDate != null && endDate != null) {
            return compteRepository.findByTransactionsDateBetween(startDate, endDate).get(0).getTransactions();
        } else {
            return compteRepository.findById(id).get().getTransactions();
        }
    }


    @PostMapping("comptes/{compteId}/versement")
    public Compte faireVersement(@PathVariable int compteId, @RequestParam double montant) {
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new IllegalArgumentException("Compte non trouvé avec l'ID : " + compteId));
        compte.setSolde(compte.getSolde() + montant);
        return compteRepository.save(compte);
    }

    @PostMapping("comptes/{compteId}/retrait")
    public Compte faireRetrait(@PathVariable int compteId, @RequestParam double montant) {
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new IllegalArgumentException("Compte non trouvé avec l'ID : " + compteId));
        if (compte.getSolde() < montant) {
            throw new IllegalArgumentException("Solde insuffisant pour le retrait");
        }
        compte.setSolde(compte.getSolde() - montant);
        return compteRepository.save(compte);
    }

}
