package com.example.bankproject.controllers;

import com.example.bankproject.entities.Client;
import com.example.bankproject.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients()
    {
        return clientService.getClients();
    }   //todo везде в ответах и запросах контролеров и на фронт используй ДТО. в сервисе уже можешь смапить дто в сущность
   @GetMapping("{id}")
    public Client getClient(@PathVariable int id)
   {
       return clientService.getClient(id);
   }

   @PostMapping
    public void addClient(@RequestBody Client client)
   {
       clientService.addClient(client);
   }

   @PutMapping
    public void updateClient(@RequestBody Client client)
   {
       clientService.updateClient(client);
   }

   @DeleteMapping("{id}")
    public void deleteClient(@PathVariable int id)
   {
       clientService.deleteClient(id);
   }
}
