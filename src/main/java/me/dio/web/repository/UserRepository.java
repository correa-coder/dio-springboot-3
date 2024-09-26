package me.dio.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.web.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
