package com.example.student_accommodation.room.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomCreateDto {

    @Column(nullable = false)
    private Integer room_number;

    @Column(nullable = false)
    private String fulname_1;

    @Column(nullable = false)
    private String fulname_2;

    @Column(nullable = false)
    private String fulname_3;

    @Column(nullable = false)
    private String fulname_4;

    @Column(nullable = false)
    private String fulname_5;

    @Column(nullable = false)
    private String fulname_6;

    @Column(nullable = false)
    private UUID floorId_id;
}
