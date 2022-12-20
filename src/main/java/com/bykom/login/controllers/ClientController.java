package com.bykom.login.controllers;

import com.bykom.login.DTOS.ClientDTO;
import com.bykom.login.models.Client;
import com.bykom.login.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping("/clientcurrent")
    public ClientDTO getClientCurrent(Authentication authentication){
        Client client = clientService.getClientByEmail(authentication.getName());
        return new ClientDTO(client);
    }

    @GetMapping("/clients")
    public List<ClientDTO> getClientDto(){

        return clientService.getClientDTO();

    }


}
