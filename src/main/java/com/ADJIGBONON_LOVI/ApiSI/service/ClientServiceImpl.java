package com.ADJIGBONON_LOVI.ApiSI.service;


import com.ADJIGBONON_LOVI.ApiSI.entity.Client;
import com.ADJIGBONON_LOVI.ApiSI.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl  implements ClientService{
    
   @Autowired
   private ClientRepository clientRepository;

@Override
public List<Client> showClients() {
    return clientRepository.findAll();
}

@Override
public Client saveClient(Client client) {
   return clientRepository.save(client);
}

@Override
public Client getOneClient(Integer id) {
    return clientRepository.findById(id).get();

}

@Override
public void deleteClient(Integer id) {
    clientRepository.deleteById(id); 
}
}




