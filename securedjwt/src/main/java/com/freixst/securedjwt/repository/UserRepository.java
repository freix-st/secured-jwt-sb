package com.freixst.securedjwt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.freixst.securedjwt.entity.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
