package com.bykom.login.service;

import com.bykom.login.DTOS.ClientDTO;
import com.bykom.login.models.Client;

import java.util.List;

public interface ClientService {

     List<ClientDTO> getClientDTO();

     void saveClient(Client client);

     Client getClientByEmail(String email);

}
