package view;

public class OutputView {

    public void printLadderLine(final String ladderLine) {
        System.out.println(ladderLine);
    }

    public void printLadderResult(final int name, final int position) {
        System.out.println(name + " -> " + position);
    }
}
