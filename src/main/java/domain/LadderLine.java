package domain;

import java.util.List;

public class LadderLine {

    private final List<Boolean> connections;
    private final String line;

    public LadderLine(final List<Boolean> connections, final String line) {
        this.connections = connections;
        this.line = line;
    }

    public List<Boolean> getConnections() {
        return connections;
    }

    public String getLine() {
        return line;
    }
}
