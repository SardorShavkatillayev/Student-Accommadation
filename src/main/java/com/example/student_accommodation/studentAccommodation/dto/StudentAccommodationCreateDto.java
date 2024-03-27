package com.example.student_accommodation.studentAccommodation.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentAccommodationCreateDto {


    @Column(nullable = false)
    @Length(min = 2,max = 100)
    private String name;

    @Column(nullable = false)
    @Min(value = 17, message = "Floor number must be greater than or equal to 17")
    @Max(value = 17, message = "Floor number must be less than or equal to 17")
    private Integer floorNumber;

    @Size(min = 5,max = 100)
    private String adres;
}
