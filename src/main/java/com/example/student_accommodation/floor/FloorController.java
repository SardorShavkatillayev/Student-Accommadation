package com.example.student_accommodation.floor;

import com.example.student_accommodation.floor.dto.FloorCreateDto;
import com.example.student_accommodation.floor.dto.FloorResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/floor")
@RequiredArgsConstructor
public class FloorController {

    private final FloorService floorService;

    @PostMapping("/create")
    public ResponseEntity<FloorResponseDto> save(@RequestBody @Valid FloorCreateDto createDto) {

        FloorResponseDto floorResponseDto = floorService.create(createDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(floorResponseDto);

    }

}
