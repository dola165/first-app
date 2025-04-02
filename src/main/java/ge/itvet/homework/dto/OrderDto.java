package ge.itvet.homework.dto;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private ClientDto client;
    private CourierDto courier;
    private String status;
    private String waybill;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private String pickupAddress;
    private String deliveryAddress;
}

