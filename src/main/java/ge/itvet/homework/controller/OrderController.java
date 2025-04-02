package ge.itvet.homework.controller;

import ge.itvet.homework.dto.CreateOrderDto;
import ge.itvet.homework.dto.OrderDto;
import ge.itvet.homework.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@Log4j2
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody CreateOrderDto createOrderDto) {
        log.info("Received request to create order: {}", createOrderDto);

        OrderDto savedOrder = orderService.createOrder(createOrderDto);

        log.info("Successfully created order with ID: {}", savedOrder.getId());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable long id) {
        log.info("Received request to get order with ID: {}", id);

        OrderDto orderDto = orderService.getOrder(id);

        log.info("Returning order: {}", orderDto);
        return ResponseEntity.ok(orderDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable long id, @Valid @RequestBody CreateOrderDto updatedOrder) {
        log.info("Received request to update order with ID: {} | New Data: {}", id, updatedOrder);
        OrderDto updated = orderService.convertToDto(orderService.updateOrder(id, updatedOrder));
        log.info("Order updated successfully: {}", updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
        log.info("Received request to delete order with ID: {}", id);
        boolean deleted = orderService.deleteOrder(id);
        if (deleted) {
            log.info("Order with ID {} deleted successfully", id);
            return ResponseEntity.noContent().build();
        } else {
            log.warn("Order with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}
