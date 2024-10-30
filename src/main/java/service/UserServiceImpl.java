package service;

import domain.Ladder;
import domain.User;
import domain.Users;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public Users makeUsers(final List<String> userNames) {
        return new Users(userNames.stream()
                .map(userName -> new User(userName, userNames.indexOf(userName)))
                .toList());
    }

    @Override
    public void updatePosition(final Ladder ladder, final Users users) {
        for (User user : users.getUsers()) {
            user.updatePosition(ladder.ladderLines(), ladder.ladderInfo());
        }
    }
}
