package ge.itvet.homework.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourierDto {
    private Long id;
    private Double rating;
    private TransportDto transport;
    private String phone;
    private String email;
}

