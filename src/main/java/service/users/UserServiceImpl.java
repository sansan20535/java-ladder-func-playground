package service.users;

import domain.ladder.Ladder;
import domain.users.User;
import domain.users.Users;
import repository.users.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void makeUsers(final List<String> userNames) {
        userRepository.setUsers(new Users(userNames.stream()
                .map(userName -> new User(userName, userNames.indexOf(userName)))
                .toList()));
    }

    @Override
    public void updatePosition(final Ladder ladder, final Users users) {
        for (User user : users.users()) {
            userRepository.updatePosition(user, ladder.ladderLines(), ladder.ladderInfo());
        }
    }

    public Users getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public User findByName(final String name) {
        return userRepository.findByName(name);
    }
}
