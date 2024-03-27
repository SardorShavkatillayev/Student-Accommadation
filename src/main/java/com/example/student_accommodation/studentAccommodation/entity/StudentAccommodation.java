package com.example.student_accommodation.studentAccommodation.entity;

import com.example.student_accommodation.floor.entity.Floor;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "studentaccommodation")
@Builder
public class StudentAccommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer floorNumber;
    @Column(nullable = false)
    private String adres;


    @OneToMany(mappedBy = "studentAccommodation", cascade = CascadeType.ALL)
    private List<Floor> floors;


}
