package com.example.student_accommodation.floor.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FloorCreateDto {

    @Column(nullable = false)
    private UUID studentAccommadationId;

    @Column(nullable = false)
    @Length(min = 9, max = 50)
    private String starsaFulname;

    @Column(nullable = false)
    @Min(1)
    private int floor_number;


//    private StudentAccommodation studentAccommodation;


//    private List<Room> rooms;

}
