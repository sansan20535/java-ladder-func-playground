package repository.ladder;

import domain.ladder.Ladder;

public class LadderRepository {

    private Ladder ladder;

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
}
