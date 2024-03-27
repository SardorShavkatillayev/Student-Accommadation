package com.example.student_accommodation.floor.entity;

import com.example.student_accommodation.room.entity.Room;
import com.example.student_accommodation.studentAccommodation.entity.StudentAccommodation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "floor")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String starsaFulname;

    private int floor_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_accommodation_id" /*nullable = false*/)
    private StudentAccommodation studentAccommodation;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<Room> rooms;






}
