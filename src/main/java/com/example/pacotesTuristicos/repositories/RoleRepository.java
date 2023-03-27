package com.example.pacotesTuristicos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pacotesTuristicos.enums.RoleName;
import com.example.pacotesTuristicos.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Optional<Role> findByRoleName(RoleName roleName);

}
