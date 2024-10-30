package controller;

import domain.Ladder;
import domain.LadderLine;
import domain.User;
import domain.Users;
import service.LadderService;
import service.UserService;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final LadderService ladderService;
    private final UserService userService;
    private final OutputView outputView;
    private final InputView inputView;

    public LadderController(final LadderService ladderService, final UserService userService, final OutputView outputView, final InputView inputView) {
        this.ladderService = ladderService;
        this.userService = userService;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        final int width = inputView.inputWidth();
        final int height = inputView.inputHeight();

        final Ladder ladder = ladderService.makeLadder(width, height);
        final Users users = userService.makeUsers(width);

        userService.updatePosition(ladder, users);

        printLadder(ladder);
        printLadderResult(users);
    }

    private void printLadder(final Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadderLines()) {
            outputView.printLadderLine(ladderLine.getLine());
        }
    }

    private void printLadderResult(final Users users) {
        for (User user : users.getUsers()) {
            outputView.printLadderResult(user.getName(), user.getPosition());
        }
    }
}
