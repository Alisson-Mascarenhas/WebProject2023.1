package br.ucsal.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.web.dto.CreateUserRoleDTO;
import br.ucsal.web.model.Role;
import br.ucsal.web.model.User;
import br.ucsal.web.repository.RoleRepository;
import br.ucsal.web.repository.UserRepository;

@Service
public class CreateRoleUserService {

  @Autowired
  UserRepository userRepository;
  
  @Autowired
  RoleRepository roleRepository;

  public User execute(CreateUserRoleDTO createUserRoleDTO) {

	User user = userRepository.findById(createUserRoleDTO.getIdUser()).get();
    Role role = new Role();

    if (Optional.of(user).isEmpty()) {
      throw new Error("User does not exists!");
    }

    role = roleRepository.findById(createUserRoleDTO.getIdRole()).get();

    user.setRole(role);

    userRepository.save(user);

    return user;

  }
  
  public Role findIdbyNameRole(Role role) {
	  return roleRepository.findIdByname(role.getName());
  }
}
