package domain;

import java.util.List;

public class User {

    private int name;
    private int position;

    public User(final int name, final int position) {
        this.name = name;
        this.position = position;
    }

    public int getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void updatePosition(final List<LadderLine> ladderLines, final LadderInfo ladderInfo) {
        for (LadderLine ladderLine : ladderLines) {
            final boolean isConnectedRight = checkRightConnection(ladderLine.getConnections(), ladderInfo.getWidth());
            final boolean isConnectedLeft = checkLeftConnection(ladderLine.getConnections());
            decideMoving(isConnectedLeft, isConnectedRight);
        }
    }

    private boolean checkRightConnection(final List<Boolean> connections, final int width) {
        if (position == width - 1) {
            return false;
        }
        return connections.get(position);
    }

    private boolean checkLeftConnection(final List<Boolean> connections) {
        if (position - 1 < 0) {
            return false;
        }
        return connections.get(position - 1);
    }

    private void decideMoving(final boolean isConnectedLeft, final boolean isConnectedRight) {
        if (!isConnectedLeft && !isConnectedRight) {
            return;
        }
        decideMovingLeftOrRight(isConnectedLeft);
    }

    private void decideMovingLeftOrRight(final boolean isConnectedLeft) {
        if (isConnectedLeft) {
            position--;
            return;
        }
        position++;
    }
}
