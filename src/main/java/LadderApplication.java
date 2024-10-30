import controller.LadderController;
import service.LadderServiceImpl;
import service.UserServiceImpl;
import view.InputView;
import view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(
                new LadderServiceImpl(),
                new UserServiceImpl(),
                new OutputView(),
                new InputView()
        );

        ladderController.start();
    }
}
