package com.ainulmdrazibtw.todobackend.repository;

import com.ainulmdrazibtw.todobackend.TodobackendApplication;
import com.ainulmdrazibtw.todobackend.entity.UserDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TodobackendApplication.class)
public class UserRepositoryTests {
    @Autowired
    private UserRepository testUserRepository;

    @Test
    public void shouldReturnOkWhenSaveAndRetrieveValidEntity(){
        UserDetails testUser = new UserDetails();

        testUser.setName("User");
        testUser.setUsername("username");
        testUser.setPassword("password");

        UserDetails savedUser = testUserRepository.saveAndFlush(testUser);

        UserDetails foundUser = testUserRepository.findById(testUser.getId()).get();

        assertNotNull(foundUser);
        assertEquals(savedUser.getUsername(), foundUser.getUsername());
    }

}
