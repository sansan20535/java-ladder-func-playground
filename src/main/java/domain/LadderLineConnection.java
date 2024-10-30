package domain;

import java.util.Arrays;

public enum LadderLineConnection {

    CONNECT_LADDER("|-----", true),
    NOT_CONNECT_LADDER("|     ", false);

    LadderLineConnection(final String ladderConnectionFormat, final boolean isConnected) {
        this.ladderConnectionFormat = ladderConnectionFormat;
        this.isConnected = isConnected;
    }

    private final String ladderConnectionFormat;
    private final boolean isConnected;

    public String getLadderConnectionFormat() {
        return ladderConnectionFormat;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public static LadderLineConnection of(final boolean isConnected) {
        return Arrays.stream(values())
                .filter(ladderLineConnection -> ladderLineConnection.isConnected == isConnected)
                .findAny()
                .orElseThrow();
    }
}
