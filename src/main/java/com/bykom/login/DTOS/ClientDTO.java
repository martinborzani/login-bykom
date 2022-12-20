package com.bykom.login.DTOS;


import com.bykom.login.models.Client;

public class ClientDTO {

    private long id;

    private String name;

    private String lastname;

    private String email;

    private String password;



    public ClientDTO() {
    }



    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastname = client.getLastname();
        this.email = client.getEmail();
        this.password = client.getPassword();
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
