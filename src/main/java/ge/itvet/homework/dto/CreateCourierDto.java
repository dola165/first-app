package ge.itvet.homework.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateCourierDto {
    @NotNull
    private String fullName;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String personalNo;
    @NotNull
    private String location;
    @NotNull
    private Long transportId;
    @NotNull
    private Integer rating;
}


