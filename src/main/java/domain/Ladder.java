package domain;

import java.util.List;

public class Ladder {
    private final List<LadderLine> ladderLines;
    private final LadderInfo ladderInfo;

    public Ladder(final List<LadderLine> ladderLines, final LadderInfo ladderInfo) {
        this.ladderLines = ladderLines;
        this.ladderInfo = ladderInfo;
    }

    public LadderInfo getLadderInfo() {
        return ladderInfo;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
