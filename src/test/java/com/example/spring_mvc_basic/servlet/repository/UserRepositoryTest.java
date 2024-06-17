package com.example.spring_mvc_basic.servlet.repository;

import com.example.spring_mvc_basic.servlet.domain.UserAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository = UserRepository.getInstance();

    @AfterEach
    void afterEach() {
        userRepository.clearMap();
    }

    @DisplayName("사용자 정보를 저장하면, 사용자 정보를 반환한다.")
    @Test
    void givenUserAccount_whenSavingUser_thenReturnsUser() {
        // Given
        UserAccount user = new UserAccount("test user", 20);

        // When
        UserAccount expected = userRepository.save(user);

        // Then
        UserAccount actual = userRepository.findById(expected.getId());
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("저장된 사용자 정보 전체를 반환한다.")
    @Test
    void givenUserInfos_whenSearchingUserInfos_thenReturnsUserInfos() {
        // Given
        UserAccount user1 = new UserAccount("test user1", 20);
        UserAccount user2 = new UserAccount("test user2", 30);

        userRepository.save(user1);
        userRepository.save(user2);

        // When
        List<UserAccount> users = userRepository.findAll();

        // Then
        assertThat(users).isNotNull();
        assertThat(users.size()).isEqualTo(2);
    }

}