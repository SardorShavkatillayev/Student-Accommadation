package com.example.student_accommodation.user.role;

import com.example.student_accommodation.user.role.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<UserRole,String> {
}
