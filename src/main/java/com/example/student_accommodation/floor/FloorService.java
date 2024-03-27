package com.example.student_accommodation.floor;

import com.example.student_accommodation.floor.dto.FloorCreateDto;
import com.example.student_accommodation.floor.dto.FloorResponseDto;
import com.example.student_accommodation.floor.entity.Floor;
import com.example.student_accommodation.studentAccommodation.StudentAccommodationRepository;
import com.example.student_accommodation.studentAccommodation.entity.StudentAccommodation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FloorService {

    private final FloorRepository floorRepository;
    private final StudentAccommodationRepository studentAccommodationRepository;

    ModelMapper modelMapper = new ModelMapper();

    public FloorResponseDto create(FloorCreateDto createDto) {
        UUID studentAccommadationId = createDto.getStudentAccommadationId();

        StudentAccommodation ttj = studentAccommodationRepository.findById(studentAccommadationId)
                .orElseThrow(
                        () -> new BadCredentialsException("Talabalar turar joyi topilmadi")
                );

        Floor floor = modelMapper.map(createDto, Floor.class);
//        UUID id = floor.getId();
        StudentAccommodation studentAccommodation = new StudentAccommodation
                (studentAccommadationId,
                        ttj.getName(),
                        ttj.getFloorNumber(),
                        ttj.getAdres(),
                        ttj.getFloors());

        floor.setStudentAccommodation(studentAccommodation);
        Floor save = floorRepository.save(floor);
        return new FloorResponseDto(save.getId(),createDto.getStarsaFulname(), createDto.getFloor_number(), studentAccommadationId);

    }

}
