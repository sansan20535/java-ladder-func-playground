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
}
