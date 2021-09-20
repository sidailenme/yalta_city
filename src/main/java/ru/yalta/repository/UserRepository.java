package ru.yalta.repository;

import org.springframework.data.repository.CrudRepository;
import ru.yalta.entity.User;

public interface UserRepository extends CrudRepository<User, String> {

}
