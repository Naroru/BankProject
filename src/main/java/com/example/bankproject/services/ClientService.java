package com.example.bankproject.services;

import com.example.bankproject.entities.Client;
import com.example.bankproject.exceptions.ObjectNotFound;
import com.example.bankproject.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

 private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClient(int id) {

          return clientRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFound(String.format("Client with id = %d was not found",id))
                );

    }

    public void addClient(Client client) {
        //todo а если клиент уже существует в БД? Аналогично для остальных сущностей. Этот момент нужно продумать
        clientRepository.save(client);
    }

    public void updateClient(Client client) {

        Client clientDB = clientRepository.findById(client.getId())
                .orElseThrow(
                        () -> new ObjectNotFound(String.format("Client with id = %d was not found", client.getId()))
                );

        clientRepository.save(client);
    }

    public void deleteClient(int id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFound(String.format("Client with id = %d was not found", id))
                );
        clientRepository.delete(client);
    }
}
