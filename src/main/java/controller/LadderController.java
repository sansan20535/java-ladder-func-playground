package controller;

import domain.Ladder;
import domain.LadderLine;
import service.LadderService;
import view.OutputView;

public class LadderController {

    private final LadderService ladderService;
    private final OutputView outputView;

    public LadderController(LadderService ladderService, OutputView outputView) {
        this.ladderService = ladderService;
        this.outputView = outputView;
    }

    public void start() {
        final Ladder ladder = ladderService.makeLadder(4, 4);
        printLadder(ladder);
    }

    private void printLadder(final Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadderLines()) {
            outputView.printLadderLine(ladderLine.getLine());
        }
    }
}
