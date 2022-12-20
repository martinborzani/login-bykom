package com.bykom.login.service.implemets;

import com.bykom.login.DTOS.ClientDTO;
import com.bykom.login.models.Client;
import com.bykom.login.repositories.ClientRepository;
import com.bykom.login.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImplement implements ClientService {

    @Autowired
    ClientRepository clientRepository;


    @Override
    public List<ClientDTO> getClientDTO() {
        return clientRepository.findAll().stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }


}
