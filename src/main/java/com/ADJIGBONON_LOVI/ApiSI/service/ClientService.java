package com.ADJIGBONON_LOVI.ApiSI.service;


import com.ADJIGBONON_LOVI.ApiSI.entity.Client;

import java.util.List;

public interface ClientService {
    public List<Client>showClients();
    public Client saveClient(Client client );
    public Client getOneClient(Integer id);
    public void deleteClient (Integer id );
   
}
