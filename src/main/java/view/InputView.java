package view;

import util.TextUtils;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return TextUtils.splitMessageWithComma(scanner.nextLine());
    }

    public List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return TextUtils.splitMessageWithComma(scanner.nextLine());
    }

    public int inputHeight() {
        System.out.println("최대 사다리의 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public String inputWantedUserName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
