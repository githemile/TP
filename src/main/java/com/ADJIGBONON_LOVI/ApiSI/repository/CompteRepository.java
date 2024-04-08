package com.ADJIGBONON_LOVI.ApiSI.repository;


import com.ADJIGBONON_LOVI.ApiSI.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource
public interface CompteRepository  extends JpaRepository<Compte, Integer> {
    List<Compte> findByTransactionsDateBetween(LocalDate startDate, LocalDate endDate);
    Compte save(Compte compte);
    
}
