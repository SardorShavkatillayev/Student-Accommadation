package com.example.student_accommodation.room;

import com.example.student_accommodation.floor.FloorRepository;
import com.example.student_accommodation.floor.entity.Floor;
import com.example.student_accommodation.room.dto.RoomCreateDto;
import com.example.student_accommodation.room.dto.RoomResponseDto;
import com.example.student_accommodation.room.entity.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final FloorRepository floorRepository;
    ModelMapper modelMapper = new ModelMapper();

    public RoomResponseDto cerate(RoomCreateDto createDto) {

        UUID floorId = createDto.getFloorId_id();

        Floor floor = floorRepository.findById(floorId).orElseThrow(
                () -> new BadCredentialsException("qavat topilmadi")
        );

        Room room = modelMapper.map(createDto, Room.class);
        room.setFloor(floor);
        Room save = roomRepository.save(room);

        return new RoomResponseDto(
                save.getId(), createDto.getRoom_number(), createDto.getFulname_1(),
                createDto.getFulname_2(), createDto.getFulname_3(), createDto.getFulname_4(),
                createDto.getFulname_5(), createDto.getFulname_6(), floorId
        );


    }
}
