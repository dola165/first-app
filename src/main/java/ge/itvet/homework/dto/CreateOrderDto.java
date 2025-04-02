package ge.itvet.homework.dto;

import lombok.*;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateOrderDto {
    @NotNull
    private Long client;

    @NotNull
    private Long courier;

    @NotNull
    @PastOrPresent
    private LocalDateTime orderDate;

    @FutureOrPresent
    private LocalDateTime deliveryDate;

    @NotBlank
    private String pickupAddress;

    @NotNull
    private Long status;

    @NotBlank
    private String deliveryAddress;

    @NotBlank
    private String waybill;

}


