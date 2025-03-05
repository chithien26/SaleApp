package com.lct.SaleApp.repository;

import com.lct.SaleApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
    User getUserByUsername(String username);
    @Query("SELECT u FROM User u WHERE u.id LIKE :userId")
    User getUserById(String userId);

    List<User> findByActiveTrue();

}
