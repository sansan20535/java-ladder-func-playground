package service;

import domain.Ladder;
import domain.Users;

import java.util.List;

public interface UserService {
    Users makeUsers(final List<String> userNames);

    void updatePosition(final Ladder ladder, final Users users);
}
