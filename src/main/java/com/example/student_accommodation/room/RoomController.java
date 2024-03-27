package com.example.student_accommodation.room;

import com.example.student_accommodation.room.dto.RoomCreateDto;
import com.example.student_accommodation.room.dto.RoomResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('USER_CREATE')")
    public ResponseEntity<RoomResponseDto> save(@RequestBody @Valid RoomCreateDto createDto) {
        RoomResponseDto cerate = roomService.cerate(createDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cerate);

    }


}
