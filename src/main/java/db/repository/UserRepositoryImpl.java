package db.repository;

import db.config.StatementInit;
import db.dao.User;
import db.exceptions.UserNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User getUserByName(String username) {
        try {
            String sql = "SELECT * FROM USERS WHERE name=?";
            PreparedStatement preparedStatement = StatementInit.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return new User(rs.getString("name"), rs.getInt("age"), rs.getString("email"));
            } else {
                throw new UserNotFoundException("User from data base is not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM USERS WHERE id=?";
        try {
            PreparedStatement preparedStatement = StatementInit.getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("name"), rs.getInt("age"), rs.getString("email"));
            } else {
                throw new UserNotFoundException("User from data base is not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserByNameAndAge(String username, Integer age) {
        try {
            String sql = "SELECT * FROM USERS WHERE name=? and age=?";
            PreparedStatement preparedStatement = StatementInit.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, age);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("name"), rs.getInt("age"), rs.getString("email"));
            } else {
                throw new UserNotFoundException("User from data base is not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            ResultSet rs = StatementInit.getConnection().createStatement().executeQuery("SELECT * FROM USERS");
            while (rs.next()) {
                users.add(new User(rs.getString("name"), rs.getInt("age"), rs.getString("email")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO USERS (name, age, email) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = StatementInit.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteUser(String username) {
        String sql = "DELETE FROM USERS WHERE name=?";
        try {
            PreparedStatement preparedStatement = StatementInit.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteUserById(Long id) {
        String sql = "DELETE FROM USERS WHERE id=?";

        try {
            PreparedStatement preparedStatement = StatementInit.getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user, String findUser) {
        String sql = "UPDATE USERS SET name=?, age=?, email=? WHERE name=?";

        try {
            PreparedStatement preparedStatement = StatementInit.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, findUser);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void updateUserName(String newUserName, String oldUserName) {
        String sql = "UPDATE USERS SET name=? WHERE name=?";

        try {
            PreparedStatement preparedStatement = StatementInit.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, newUserName);
            preparedStatement.setString(2, oldUserName);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
