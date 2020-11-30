package gg.sparkzy.casl.userservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gg.sparkzy.casl.userservice.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
