package com.example.student_accommodation.user.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDto {



    @Column(nullable = false)
    @NotBlank
    @Length(max = 50, min = 3)
    private String name;

    @Column(nullable = false)
    @NotBlank
    @Length(max = 50, min = 6)
    private String surname;

    @Column(unique = true)
    @Pattern(regexp = "^\\+998\\d{9}$", message = "Invalid phone number")
    private String phoneNumber;

    @Column(nullable = false)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$")
    private String password;




}
