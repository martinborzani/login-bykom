package com.bykom.login.configuration;


import com.bykom.login.models.Client;
import com.bykom.login.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    ClientService clientService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws  Exception{
        auth.userDetailsService(email ->{

            Client client = clientService.getClientByEmail(email);
            if(client != null){
                if(client.getEmail().contains("@admin")){
                    return new User(client.getEmail(),client.getPassword(), AuthorityUtils.createAuthorityList("ADMIN"));
                }else{
                    return new User(client.getEmail(),client.getPassword(), AuthorityUtils.createAuthorityList("CLIENT"));
                }
            }else{
                throw new UsernameNotFoundException("Unknown user" + email);
            }

        });
    }


    @Bean
    public PasswordEncoder passwordEncoder(){

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
