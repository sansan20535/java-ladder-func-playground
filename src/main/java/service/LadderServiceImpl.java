package service;

import domain.Ladder;
import domain.LadderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderServiceImpl implements LadderService {

    @Override
    public Ladder makeLadder(final int width, final int height) {
        return new Ladder(makeLadderLines(height, width));
    }

    private List<LadderLine> makeLadderLines(final int height, final int width) {
        return IntStream.range(0, height)
                .mapToObj(i -> makeLadderLine(width))
                .toList();
    }

    private LadderLine makeLadderLine(final int width) {
        return new LadderLine(makeConnections(width));
    }

    private List<Boolean> makeConnections(final int width) {
        List<Boolean> connections = new ArrayList<Boolean>();
        Random random = new Random();

        while (connections.size() < width - 1) {
            addConnections(connections, random.nextBoolean());
        }

        return connections;
    }

    private void addConnections(final List<Boolean> connections, final boolean isConnected) {
        if (connections.isEmpty() || !isConnected || !connections.get(connections.size() - 1)) {
            connections.add(isConnected);
        }
    }
}
