package by.iba.onlineshop.entities.enums;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Role {

	ADMIN(Set.of(Permission.READ, Permission.MODIFY)),
	USER(Set.of(Permission.READ, Permission.ORDER));

	@Getter
	private final Set<Permission> permissions;

}
