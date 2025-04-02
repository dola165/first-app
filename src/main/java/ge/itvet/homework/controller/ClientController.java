package ge.itvet.homework.controller;

import ge.itvet.homework.domain.Client;
import ge.itvet.homework.dto.ClientDto;
import ge.itvet.homework.dto.CreateClientDto;
import ge.itvet.homework.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
@Log4j2
public class ClientController {


    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@Valid @RequestBody CreateClientDto createClientDto) {
        log.info("Received request to create client: {}", createClientDto);
        ClientDto clientDto = clientService.createClient(createClientDto);
        log.info("Client created successfully: {}", clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable long id) {
        log.info("Fetching client with ID: {}", id);
        ClientDto clientDto = clientService.getClient(id);
        return ResponseEntity.ok(clientDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable long id, @Valid @RequestBody CreateClientDto updatedClient) {
        log.info("Updating client with ID: {}", id);
        ClientDto clientDto = clientService.updateClient(id, updatedClient);
        return ResponseEntity.ok(clientDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable long id) {
        log.info("Deleting client with ID: {}", id);
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}

