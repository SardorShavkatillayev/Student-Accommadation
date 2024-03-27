package com.example.student_accommodation.user.dto;

import com.example.student_accommodation.user.permission.UserPermission;
import com.example.student_accommodation.user.role.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDto {

    private UUID id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
    private UUID room_id;
    private List<UserRole> permission;
    private List<UserPermission> userPermissions;
}

