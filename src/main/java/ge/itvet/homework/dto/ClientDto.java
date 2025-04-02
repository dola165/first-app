package ge.itvet.homework.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String location;
}
