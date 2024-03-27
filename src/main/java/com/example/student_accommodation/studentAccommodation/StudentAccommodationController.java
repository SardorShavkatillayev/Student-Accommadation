package com.example.student_accommodation.studentAccommodation;

import com.example.student_accommodation.studentAccommodation.dto.StudentAccommodationCreateDto;
import com.example.student_accommodation.studentAccommodation.dto.StudentAccommodationResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-accommadation")
@RequiredArgsConstructor
public class StudentAccommodationController {

    private final StudentAccommodationService studentAccommodationService;

    @PostMapping("/create-accommodation")
    public ResponseEntity<StudentAccommodationResponseDto> save(@RequestBody @Valid StudentAccommodationCreateDto createDto){
        StudentAccommodationResponseDto studentAccommodationResponseDto = studentAccommodationService.create(createDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentAccommodationResponseDto);
   }




}
