package br.ucsal.web.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.web.model.Role;

public interface RoleRepository extends JpaRepository<Role, UUID>{
		Role findIdByname(String name);
}
