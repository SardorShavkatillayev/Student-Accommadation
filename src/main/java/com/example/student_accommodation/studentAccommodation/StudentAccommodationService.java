package com.example.student_accommodation.studentAccommodation;

import com.example.student_accommodation.studentAccommodation.dto.StudentAccommodationCreateDto;
import com.example.student_accommodation.studentAccommodation.dto.StudentAccommodationResponseDto;
import com.example.student_accommodation.studentAccommodation.entity.StudentAccommodation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentAccommodationService {

    private final StudentAccommodationRepository studentAccommodationRepository;

    ModelMapper modelMapper = new ModelMapper();

    public StudentAccommodationResponseDto create(StudentAccommodationCreateDto createDto) {
        StudentAccommodation studentAccommodation = modelMapper.map(createDto, StudentAccommodation.class);
        studentAccommodationRepository.save(studentAccommodation);
        return modelMapper.map(studentAccommodation, StudentAccommodationResponseDto.class);
    }


}
