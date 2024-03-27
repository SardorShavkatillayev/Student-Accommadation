package com.example.student_accommodation.floor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FloorResponseDto {

    private UUID id;
    private String starsaFulname;
    private int floor_number;
    private UUID studentAccommadationId;
}
