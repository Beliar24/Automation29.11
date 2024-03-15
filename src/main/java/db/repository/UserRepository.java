package db.repository;

import db.dao.User;

import java.util.List;

public interface UserRepository {
    User getUserByName(String username);
    User getUserById(Long id);
    User getUserByNameAndAge(String username, Integer age);
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(String username);
    void deleteUserById(Long id);
    void updateUser(User user, String findUser);
    void updateUserName(String newUserName, String oldUserName);
}
