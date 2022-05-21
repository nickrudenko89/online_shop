package by.iba.onlineshop.entities.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Permission implements GrantedAuthority {

	READ,
	MODIFY,
	ORDER;

	@Override
	public String getAuthority() {
		return name();
	}

}
