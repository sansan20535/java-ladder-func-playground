package service.users;

import domain.ladder.Ladder;
import domain.users.User;
import domain.users.Users;

import java.util.List;

public interface UserService {
    void makeUsers(final List<String> userNames);

    void updatePosition(final Ladder ladder, final Users users);

    Users getUsers();

    User findByName(final String name);
}
