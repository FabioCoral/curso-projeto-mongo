package com.fabiocoral.workshopmongo.services;

import com.fabiocoral.workshopmongo.domain.User;
import com.fabiocoral.workshopmongo.repository.UserRepository;
import com.fabiocoral.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id){
       Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }


    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void verificarBanco() {
        System.out.println("Database conectado: " + mongoTemplate.getDb().getName());
        System.out.println("Collection usada: " + mongoTemplate.getCollectionName(User.class));
        System.out.println("Qtd registros: " + repo.count());

    }
}
