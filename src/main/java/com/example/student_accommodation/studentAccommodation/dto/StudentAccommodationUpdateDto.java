package com.example.student_accommodation.studentAccommodation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentAccommodationUpdateDto {

    private String name;

    private Integer floorNumber;
    private String adres;

}
