package controller;

import domain.Ladder;
import domain.LadderLine;
import domain.User;
import domain.Users;
import service.LadderService;
import service.UserService;
import view.InputView;
import view.OutputView;

import java.util.List;

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
        final Users users = userService.makeUsers(inputView.inputUserNames());
        final List<String> results = inputView.inputResults();
        final int width = users.getUsers().size();
        final int height = inputView.inputHeight();
        final Ladder ladder = ladderService.makeLadder(width, height);

        userService.updatePosition(ladder, users);

        printLadder(users.getUsers(), ladder, results);
        printLadderResult(users, results);
    }

    private void printLadder(final List<User> users, final Ladder ladder, final List<String> results) {
        for (User user : users) {
            outputView.printUser(user.getName());
        }
        outputView.printEmpty();
        for (LadderLine ladderLine : ladder.ladderLines()) {
            outputView.printLadderLine(ladderLine.getLine());
        }
        for (String result : results) {
            outputView.printResult(result);
        }
        outputView.printEmpty();
    }

    private void printLadderResult(final Users users, final List<String> results) {
        while (true) {
            final String wantedUserName = inputView.inputWantedUserName();
            final boolean isAll = checkUserName(wantedUserName);
            printResult(wantedUserName, users, results, isAll);
        }
    }

    private boolean checkUserName(final String wantedUserName) {
        return wantedUserName.equals("all");
    }

    private void printResult(final String wantedUserName, final Users users, final List<String> results, final boolean isAll) {
        if (!isAll) {
            outputView.printExecutionResult();
            outputView.printUserResult(results.get(
                    users.findByName(wantedUserName).getPosition())
            );
            return;
        }

        outputView.printExecutionResult();
        for (User user : users.getUsers()) {
            outputView.printAllUserResults(user.getName(), results.get(user.getPosition()));
        }
    }
}
