package ge.itvet.homework.service;

import ge.itvet.homework.domain.Client;
import ge.itvet.homework.dto.ClientDto;
import ge.itvet.homework.dto.CreateClientDto;
import ge.itvet.homework.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ModelMapper modelMapper;
    private final ClientRepository clientRepository;

    public ClientDto createClient(CreateClientDto createClientDto) {
        Client client = modelMapper.map(createClientDto, Client.class);
        Client savedClient = clientRepository.save(client);
        return modelMapper.map(savedClient, ClientDto.class);
    }

    public ClientDto getClient(long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));
        return modelMapper.map(client, ClientDto.class);
    }

    public ClientDto updateClient(long id, CreateClientDto updatedClientDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));
        modelMapper.map(updatedClientDto, client);
        Client updatedClient = clientRepository.save(client);
        return modelMapper.map(updatedClient, ClientDto.class);
    }

    public void deleteClient(long id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client not found with id " + id);
        }
        clientRepository.deleteById(id);
    }
}
