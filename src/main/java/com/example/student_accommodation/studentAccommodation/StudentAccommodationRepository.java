package com.example.student_accommodation.studentAccommodation;

import com.example.student_accommodation.studentAccommodation.entity.StudentAccommodation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface
StudentAccommodationRepository  extends JpaRepository<StudentAccommodation, UUID> {

    Optional<StudentAccommodation> findById(UUID id);

}
