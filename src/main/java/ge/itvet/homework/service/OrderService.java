package ge.itvet.homework.service;

import ge.itvet.homework.domain.Client;
import ge.itvet.homework.domain.Courier;
import ge.itvet.homework.domain.Order;
import ge.itvet.homework.domain.OrderStatus;
import ge.itvet.homework.dto.*;
import ge.itvet.homework.repository.OrderRepository;
import ge.itvet.homework.repository.OrderStatusRepository;
import ge.itvet.homework.repository.ClientRepository;
import ge.itvet.homework.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final ModelMapper modelMapper;
    private final OrderStatusRepository orderStatusRepository;
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final CourierRepository courierRepository;

    public OrderDto convertToDto(Order order) {
        OrderDto dto = modelMapper.map(order, OrderDto.class);

        if (order.getCourier() != null) {
            dto.setCourier(modelMapper.map(order.getCourier(), CourierDto.class));
        }

        if (order.getClient() != null) {
            dto.setClient(modelMapper.map(order.getClient(), ClientDto.class));
        }

        return dto;
    }

    public Order convertToEntity(CreateOrderDto createOrderDto) {
        Order order = modelMapper.map(createOrderDto, Order.class);

        OrderStatus status = orderStatusRepository.findById(createOrderDto.getStatus())
                .orElseThrow(() -> new RuntimeException("Order status not found"));
        order.setStatus(status);

        Client client = clientRepository.findById(createOrderDto.getClient())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        order.setClient(client);

        if (createOrderDto.getCourier() != null) {
            Courier courier = courierRepository.findById(createOrderDto.getCourier())
                    .orElseThrow(() -> new RuntimeException("Courier not found"));
            order.setCourier(courier);
        }

        return order;
    }

    public OrderDto createOrder(CreateOrderDto createOrderDto) {
        Order order = convertToEntity(createOrderDto);
        Order savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, OrderDto.class);
    }

    @Transactional
    public OrderDto getOrder(long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id " + id));
        return modelMapper.map(order, OrderDto.class);
    }

    @Transactional
    public Order updateOrder(long id, CreateOrderDto updatedOrderDto) {
        return orderRepository.findById(id)
                .map(order -> {
                    modelMapper.map(updatedOrderDto, order);
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    @Transactional
    public boolean deleteOrder(long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


