package service;

import domain.Ladder;
import domain.User;
import domain.Users;

import java.util.stream.IntStream;

public class UserServiceImpl implements UserService {

    @Override
    public Users makeUsers(final int width) {
        return new Users(IntStream.range(0, width)
                .mapToObj(this::makeUser)
                .toList());
    }

    private User makeUser(final int position) {
        return new User(position, position);
    }

    @Override
    public void updatePosition(final Ladder ladder, final Users users) {
        for (User user : users.getUsers()) {
            user.updatePosition(ladder.getLadderLines(), ladder.getLadderInfo());
        }
    }
}
