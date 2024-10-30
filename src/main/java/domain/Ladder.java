package domain;

import java.util.List;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(final List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
