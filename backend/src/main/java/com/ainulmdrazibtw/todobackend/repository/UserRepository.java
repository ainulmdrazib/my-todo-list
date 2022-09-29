package com.ainulmdrazibtw.todobackend.repository;

import com.ainulmdrazibtw.todobackend.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

    UserDetails findByUsernameAndPassword(String username, String password);

    UserDetails findTopByUsername(String username);

    UserDetails findTopByPassword(String password);

}
