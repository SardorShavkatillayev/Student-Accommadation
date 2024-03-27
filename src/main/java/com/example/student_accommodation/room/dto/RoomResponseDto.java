package com.example.student_accommodation.room.dto;

import com.example.student_accommodation.floor.entity.Floor;
import com.example.student_accommodation.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomResponseDto {



    private UUID id;

    private Integer room_number;

    private String fulname_1;

    private String fulname_2;

    private String fulname_3;

    private String fulname_4;

    private String fulname_5;

    private String fulname_6;

    private UUID floorId_id;


   // private List<User> users;



}
