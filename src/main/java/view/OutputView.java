package view;

public class OutputView {

    public void printEmpty() {
        System.out.println(" ");
    }

    public void printUser(final String userName) {
        System.out.print(userName + " ");
    }

    public void printResult(final String result) {
        System.out.print(result + " ");
    }

    public void printLadderLine(final String ladderLine) {
        System.out.println(ladderLine);
    }

    public void printUserResult(final String result) {
        System.out.println(result);
        System.out.println(" ");
    }

    public void printAllUserResults(final String name, final String result) {
        System.out.println(name + " : " + result);
    }

    public void printExecutionResult() {
        System.out.println("실행 결과");
    }
}
