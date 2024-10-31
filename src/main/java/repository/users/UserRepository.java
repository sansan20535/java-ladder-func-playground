package repository.users;

import domain.ladder.LadderInfo;
import domain.ladder.LadderLine;
import domain.users.User;
import domain.users.Users;

import java.util.List;

public class UserRepository {

    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(final Users users) {
        this.users = users;
    }

    public User findByName(final String userName) {
        return users.users().stream()
                .filter(user -> user.getName().equals(userName))
                .findFirst()
                .orElse(null); // 또는 예외를 던질 수 있습니다.
    }

    public void updatePosition(final User user, final List<LadderLine> ladderLines, final LadderInfo ladderInfo) {
        for (LadderLine ladderLine : ladderLines) {
            final boolean isConnectedRight = checkRightConnection(ladderLine.connections(), user.getPosition(), ladderInfo.width());
            final boolean isConnectedLeft = checkLeftConnection(ladderLine.connections(), user.getPosition());
            decideMoving(isConnectedLeft, isConnectedRight, user);
        }
    }

    private boolean checkRightConnection(final List<Boolean> connections, final int position, final int width) {
        if (position == width - 1) {
            return false;
        }
        return connections.get(position);
    }

    private boolean checkLeftConnection(final List<Boolean> connections, final int position) {
        if (position - 1 < 0) {
            return false;
        }
        return connections.get(position - 1);
    }

    private void decideMoving(final boolean isConnectedLeft, final boolean isConnectedRight, final User user) {
        if (!isConnectedLeft && !isConnectedRight) {
            return;
        }
        decideMovingLeftOrRight(isConnectedLeft, user);
    }

    private void decideMovingLeftOrRight(final boolean isConnectedLeft, final User user) {
        if (isConnectedLeft) {
            user.setPosition(user.getPosition() - 1);
            return;
        }
        user.setPosition(user.getPosition() + 1);
    }
}
