package com.example.student_accommodation.user;

import com.example.student_accommodation.common.rsql.SpecificationBuilder;
import com.example.student_accommodation.room.RoomRepository;
import com.example.student_accommodation.room.entity.Room;
import com.example.student_accommodation.user.dto.UserResponseDto;
import com.example.student_accommodation.user.dto.UserSignInDto;
import com.example.student_accommodation.user.dto.UserSignUpDto;
import com.example.student_accommodation.user.dto.UserUpdateDto;
import com.example.student_accommodation.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    ModelMapper modelMapper = new ModelMapper();


    @Override
    public UserDetails loadUserByUsername(String phoneNUmber) throws UsernameNotFoundException {
        return userRepository.findUserByPhoneNumber(phoneNUmber).orElseThrow(() ->
                new BadCredentialsException("Bad credentials"));
    }

    public UserResponseDto signUp(UserSignUpDto userSignUpDto) {

        UUID room_id = userSignUpDto.getRoom_id();
        Room room = roomRepository.findById(room_id)
                .orElseThrow(
                        () -> new BadCredentialsException("Room with id =" + room_id + "not found")
                );
        User user = modelMapper.map(userSignUpDto, User.class);
        user.setRoom(room);
        userRepository.save(user);

//        return new UserResponseDto(
//                save.getId(), save.getName(), save.getSurname(),
//                save.getPhoneNumber(), save.getPassword(), LocalDateTime.now(),
//                LocalDateTime.now()
//                , room_id,
//        );

        return modelMapper.map(user, UserResponseDto.class);


    }

    public UserResponseDto signIn(UserSignInDto userSignInDto) {

        String phoneNumber = userSignInDto.getPhoneNumber();
        User user = userRepository.findUserByPhoneNumber(phoneNumber)
                .orElseThrow(
                        () -> new BadCredentialsException("Elektron pochta yoki parol noto'g'ri")
                );
//        Room room = user.getRoom();
//        UUID roomId = room.getId();

        if (!user.getPassword().equals(userSignInDto.getPassword())) {
            throw new BadCredentialsException("Elektron pochta yoki parol mos emas");
        }
        return modelMapper.map(user, UserResponseDto.class);
    }


    public Page<UserResponseDto> getAll(Pageable pageable, String predicate) {
        Specification<User> specification = SpecificationBuilder.build(predicate);
        if (specification == null) {
            return userRepository.findAll(pageable).map(entity ->
                    modelMapper.map(entity, UserResponseDto.class));
        }
        return userRepository.findAll(specification, pageable)
                .map(entity -> modelMapper.map(entity, UserResponseDto.class));
    }

    public UserResponseDto update(UserUpdateDto updateDto, UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("User with id =" + id + " not found")
                );
        user.setName(updateDto.getName());
        user.setSurname(updateDto.getSurname());
        user.setPhoneNumber(updateDto.getPhoneNumber());
        user.setPassword(updateDto.getPassword());
        userRepository.save(user);
        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto getById(UUID id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("User with id =" + id + "not found")
                );
        return modelMapper.map(user, UserResponseDto.class);
    }

    public void deleteByID(UUID id) {

        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User with id =" + id + "not found");
        }
        userRepository.deleteById(id);
    }


}
