package domain.users;

import java.util.List;

public record Users(
        List<User> users
) {

    public User findByName(final String userName) {
        return users.stream()
                .filter(user -> user.getName().equals(userName))
                .findFirst()
                .orElse(null); // 또는 예외를 던질 수 있습니다.
    }
}
