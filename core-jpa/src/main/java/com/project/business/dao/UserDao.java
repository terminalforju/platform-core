package com.project.business.dao;

import com.project.business.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User findUserByCode(String code);

    User findUserById(Long id);

    boolean existsByCode(String code);

}
