package com.project.model.user.pojo;

import com.project.model.role.pojo.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserTab implements UserDetails, Serializable {
    private String id;

    private String code;

    private String password;

    private String name;

    private Date birthDay;

    private String gender;

    private Date createTime;


    //    @DataDict(source = "statusId",target = "statusName",dicId = "listid",checkType = "1")

    private String status;

    private BigDecimal isSysUser;

    private BigDecimal isTemp;

    private List<Role> authorities;


    private static final long serialVersionUID = 1L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return code;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
