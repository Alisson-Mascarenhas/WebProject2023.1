package br.ucsal.web.dto;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CreateUserRoleDTO {

	private UUID idUser;

	private UUID idRole;

	public UUID getIdUser() {
		return idUser;
	}

	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}

	public UUID getIdRole() {
		return idRole;
	}

	public void setIdRole(UUID idRole) {
		this.idRole = idRole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUser, idRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateUserRoleDTO other = (CreateUserRoleDTO) obj;
		return Objects.equals(idUser, other.idUser) && Objects.equals(idRole, other.idRole);
	}
	
	
}