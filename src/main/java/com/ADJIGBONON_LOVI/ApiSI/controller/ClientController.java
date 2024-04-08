package com.ADJIGBONON_LOVI.ApiSI.controller;


import com.ADJIGBONON_LOVI.ApiSI.entity.Client;
import com.ADJIGBONON_LOVI.ApiSI.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClientController {
    
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @GetMapping("/clients")
    public List<Client> showClients() {
        return clientServiceImpl.showClients();
    }

    @GetMapping("/clients/{id}")
    public Client get(@PathVariable Integer id) {
        return clientServiceImpl.getOneClient(id);
    }

    @PostMapping("/clients")
    public Client save(@RequestBody Client client) {
        return clientServiceImpl.saveClient(client);
        
    }       

    @PutMapping("/clients/{id}")
    public Client update(@PathVariable Integer id, @RequestBody Client client) {
        client.setId(id);
        return clientServiceImpl.saveClient(client);
    }

    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable Integer id) {
        clientServiceImpl.deleteClient(id);
    }
}
