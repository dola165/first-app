package ge.itvet.homework.service;

import ge.itvet.homework.domain.Courier;
import ge.itvet.homework.domain.Transport;
import ge.itvet.homework.dto.CourierDto;
import ge.itvet.homework.dto.CreateCourierDto;
import ge.itvet.homework.dto.TransportDto;
import ge.itvet.homework.repository.CourierRepository;
import ge.itvet.homework.repository.TransportRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final ModelMapper modelMapper;
    private final CourierRepository courierRepository;
    private final TransportRepository transportRepository;


    @Transactional
    public CourierDto getCourier(long id) {
        Courier courier = courierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Courier not found with id " + id));
        return modelMapper.map(courier, CourierDto.class);
    }

    public CourierDto createCourier(CreateCourierDto createCourierDto) {
        Transport transport = transportRepository.findById(createCourierDto.getTransportId())
                .orElseThrow(() -> new EntityNotFoundException("Transport not found with id: " + createCourierDto.getTransportId()));

        Courier courier = new Courier();
        courier.setEmail(createCourierDto.getEmail());
        courier.setTransport(transport);
        courier.setRating(createCourierDto.getRating());
        courier.setFullName(createCourierDto.getFullName());
        courier.setLocation(createCourierDto.getLocation());
        courier.setPhone(createCourierDto.getPhone());
        courier.setPersonalNo(createCourierDto.getPersonalNo());

        Courier savedCourier = courierRepository.save(courier);

        // Set all fields in CourierDto
        CourierDto courierDto = new CourierDto();
        courierDto.setId(savedCourier.getId());
        courierDto.setEmail(savedCourier.getEmail());
        courierDto.setPhone(savedCourier.getPhone());
        courierDto.setRating((double) savedCourier.getRating());
        courier.setTransport(transport);

        return courierDto;
    }

    @Transactional
    public boolean deleteCourier(long id) {
        if (courierRepository.existsById(id)) {
            courierRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
