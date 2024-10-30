package service;

import domain.Ladder;
import domain.Users;

public interface UserService {
    Users makeUsers(final int width);

    void updatePosition(final Ladder ladder, final Users users);
}
