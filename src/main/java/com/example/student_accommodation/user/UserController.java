package com.example.student_accommodation.user;

import com.example.student_accommodation.common.jwt.JwtService;
import com.example.student_accommodation.user.dto.UserResponseDto;
import com.example.student_accommodation.user.dto.UserSignInDto;
import com.example.student_accommodation.user.dto.UserSignUpDto;
import com.example.student_accommodation.user.dto.UserUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/auth/sign-up")
    public ResponseEntity<UserResponseDto> signUp(@RequestBody @Valid UserSignUpDto userCreateDto) {
        UserResponseDto userResponseDto = userService.signUp(userCreateDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponseDto);
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<UserResponseDto> signIn(@RequestBody UserSignInDto userSignInDto) {

        UserResponseDto userResponseDto = userService.signIn(userSignInDto);
        String token = jwtService.generateToken(userSignInDto.getPhoneNumber());
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, "Bearer %s".formatted(token))
                .body(userResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {

        Page<UserResponseDto> all = userService.getAll(pageable, predicate);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(all);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getById(@RequestParam UUID id) {

        UserResponseDto byId = userService.getById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(byId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> update(@RequestBody @Valid UserUpdateDto updateDto, @RequestParam UUID id) {

        UserResponseDto update = userService.update(updateDto, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(update);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponseDto> delete(@RequestParam UUID id) {

        userService.deleteByID(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
