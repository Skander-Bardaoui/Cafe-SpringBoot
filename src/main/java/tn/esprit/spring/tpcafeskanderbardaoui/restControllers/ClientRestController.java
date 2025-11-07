package tn.esprit.spring.tpcafeskanderbardaoui.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.services.Client.IClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientRestController {

    private final IClientService clientService;

    // ✅ Get all clients
    @GetMapping
    public List<ClientResponce> selectAllClients() {
        return clientService.selectAllClients();
    }

    // ✅ Get client by ID
    @GetMapping("/{id}")
    public ClientResponce selectClientById(@PathVariable long id) {
        return clientService.selectClientById(id);
    }

    // ✅ Add one client
    @PostMapping
    public ClientResponce addClient(@RequestBody ClientRequest request) {
        return clientService.addClient(request);
    }

    // ✅ Add multiple clients
    @PostMapping("/batch")
    public List<ClientResponce> saveClients(@RequestBody List<ClientRequest> requests) {
        return clientService.saveClients(requests);
    }

    // ✅ Delete client by ID
    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable long id) {
        clientService.deleteClientById(id);
    }

    // ✅ Delete all clients
    @DeleteMapping
    public void deleteAllClients() {
        clientService.deleteAllClients();
    }

    // ✅ Count all clients
    @GetMapping("/count")
    public long countClients() {
        return clientService.countingClients();
    }

    // ✅ Check if client exists by ID
    @GetMapping("/exists/{id}")
    public boolean verifClientById(@PathVariable long id) {
        return clientService.verifClientById(id);
    }
}
