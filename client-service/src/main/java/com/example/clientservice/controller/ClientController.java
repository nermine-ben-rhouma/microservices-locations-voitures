package com.example.clientservice.controller;

import com.example.clientservice.entities.Client;
import com.example.clientservice.repositories.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Client> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Client add(@RequestBody Client client) {
        return repository.save(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        client.setId(id);
        return repository.save(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}