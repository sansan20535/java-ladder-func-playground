import controller.LadderController;
import service.LadderServiceImpl;
import view.InputView;
import view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(
                new LadderServiceImpl(),
                new OutputView(),
                new InputView()
        );

        ladderController.start();
    }
}
