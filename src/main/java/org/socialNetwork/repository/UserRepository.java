package org.socialNetwork.repository;

import org.socialNetwork.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByFirstName(String firsName);
}
