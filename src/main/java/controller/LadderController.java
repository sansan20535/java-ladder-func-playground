package controller;

import domain.Ladder;
import domain.LadderLine;
import service.LadderService;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final LadderService ladderService;
    private final OutputView outputView;
    private final InputView inputView;

    public LadderController(final LadderService ladderService, final OutputView outputView, final InputView inputView) {
        this.ladderService = ladderService;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        final Ladder ladder = ladderService.makeLadder(inputView.inputWidth(), inputView.inputHeight());
        printLadder(ladder);
    }

    private void printLadder(final Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadderLines()) {
            outputView.printLadderLine(ladderLine.getLine());
        }
    }
}
