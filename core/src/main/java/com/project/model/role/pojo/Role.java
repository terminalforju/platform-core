package com.project.model.role.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Setter
@Getter
public class Role implements Serializable, GrantedAuthority {
    private Long id;

    private String name;

    private static final long serialVersionUID = 1L;


    @Override
    public String getAuthority() {
        return name;
    }
}
