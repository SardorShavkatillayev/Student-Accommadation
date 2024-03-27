package com.example.student_accommodation.floor;

import com.example.student_accommodation.floor.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;

import java.util.Optional;
import java.util.UUID;

public interface FloorRepository extends JpaRepository<Floor, UUID> {
    Optional<Floor> findById(UUID id);
}
