package ge.itvet.homework.controller;

import ge.itvet.homework.dto.CourierDto;
import ge.itvet.homework.dto.CreateCourierDto;
import ge.itvet.homework.service.CourierService;
import ge.itvet.homework.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/couriers")
@Log4j2
public class CourierController {

    private final CourierService courierService;
    private final OrderService orderService;

    @PostMapping("/couriers")
    public ResponseEntity<CourierDto> createCourier(@Valid @RequestBody CreateCourierDto createCourierDto, BindingResult bindingResult) {
        log.info("Received request to create courier with data: {}", createCourierDto);

        if (bindingResult.hasErrors()) {
            log.error("Validation errors occurred while creating courier: {}", bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(null);
        }

        try {
            CourierDto courierDto = courierService.createCourier(createCourierDto);
            log.info("Courier created successfully with ID: {}", courierDto.getId());
            return new ResponseEntity<>(courierDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Error occurred while creating courier: {}", ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourierDto> getCourier(@PathVariable long id) {
        try {
            log.info("Received request to get courier with ID: {}", id);
            CourierDto courierDto = courierService.getCourier(id);
            log.info("Returning courier: {}", courierDto);
            return ResponseEntity.ok(courierDto);
        } catch (EntityNotFoundException ex) {
            log.error("Courier not found with ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourier(@PathVariable long id) {
        log.info("Received request to delete courier with ID: {}", id);
        boolean deleted = courierService.deleteCourier(id);
        if (deleted) {
            log.info("Courier with ID {} deleted successfully", id);
            return ResponseEntity.noContent().build();
        } else {
            log.warn("Courier with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}
