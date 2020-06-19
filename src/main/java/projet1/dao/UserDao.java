package projet1.dao;

import projet1.model.User;

public interface UserDao extends GenericDao<User, Long> {
    User findUserByEmail(String email);
}
