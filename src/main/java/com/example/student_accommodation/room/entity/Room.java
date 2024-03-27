package com.example.student_accommodation.room.entity;

import com.example.student_accommodation.floor.entity.Floor;
import com.example.student_accommodation.user.entity.User;
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
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Integer room_number;

    @Column(nullable = false)
    private String fulname_1;

    @Column(nullable = false)
    private String fulname_2;

    @Column(nullable = false)
    private String fulname_3;

    @Column(nullable = false)
    private String fulname_4;

    @Column(nullable = false)
    private String fulname_5;

    @Column(nullable = false)
    private String fulname_6;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;

    @OneToMany(mappedBy = "room")
    private List<User> users;



}
