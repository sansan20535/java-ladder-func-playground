package domain;

import java.util.List;

public class LadderLine {

    private final List<Boolean> connections;
    private final String line;

    public LadderLine(final List<Boolean> connections) {
        this.connections = connections;
        this.line = makeLine();
    }

    private String makeLine() {
        final List<String> line = connections.stream()
                .map(connections -> LadderLineConnection.of(connections).getLadderConnectionFormat())
                .toList();

        return String.join("", line) + "|";
    }

    public List<Boolean> getConnections() {
        return connections;
    }

    public String getLine() {
        return line;
    }
}
