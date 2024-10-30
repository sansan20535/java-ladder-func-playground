package domain;

import java.util.List;

public class Users {

    private final List<User> users;

    public Users(final List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public User findByName(final String userName) {
        return users.stream()
                .filter(user -> user.getName().equals(userName))
                .findFirst()
                .orElse(null); // 또는 예외를 던질 수 있습니다.
    }
}
