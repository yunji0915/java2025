package Report;

import java.util.Scanner;

abstract class Contestant {
    protected String[] options = {"묵", "찌", "빠"};
    protected String name;
    protected String lastMove = null;

    protected Contestant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getMove() {
        return lastMove;
    }

    abstract public String nextMove();
}

class HumanPlayer extends Contestant {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public String nextMove() {
        while (true) {
            System.out.print(name + ">>");
            String currentMove = scanner.next();
            for (String option : options) {
                if (currentMove.equals(option)) {
                    lastMove = currentMove;
                    return lastMove;
                }
            }
            System.out.println("묵, 찌, 빠 중에서 다시 입력하세요.");
        }
    }
}

class ComputerPlayer extends Contestant {
    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public String nextMove() {
        int index = (int) (Math.random() * options.length);
        System.out.println(name + ">> 결정하였습니다.");
        lastMove = options[index];
        return lastMove;
    }
}

class Game {
    private Contestant[] contestants = new Contestant[2];
    private Scanner scanner = new Scanner(System.in);

    public Game() {
    }

    private void createContestants() {
        System.out.print("사람 플레이어 이름 입력>>");
        String name = scanner.next();
        contestants[0] = new HumanPlayer(name);

        System.out.print("컴퓨터 이름 입력>>");
        name = scanner.next();
        contestants[1] = new ComputerPlayer(name);
        System.out.println("두 명의 플레이어 생성 완료...\n");
    }

    public void run() {
        System.out.println("***** 묵찌빠 게임을 시작합니다. *****");
        createContestants();
        int ownerIndex = 0;
        while (true) {
            String ownerMove = contestants[ownerIndex].nextMove();
            int opponentIndex = (ownerIndex + 1) % 2;
            String opponentMove = contestants[opponentIndex].nextMove();

            System.out.println(contestants[ownerIndex].getName() + " : " + contestants[ownerIndex].getMove() +
                    ", " + contestants[opponentIndex].getName() + " : " + contestants[opponentIndex].getMove());

            if (ownerMove.equals(opponentMove)) {
                System.out.println("\n" + contestants[ownerIndex].getName() + "이 이겼습니다.");
                break;
            }

            if ((ownerMove.equals("묵") && opponentMove.equals("빠")) ||
                    (ownerMove.equals("찌") && opponentMove.equals("묵")) ||
                    (ownerMove.equals("빠") && opponentMove.equals("찌"))) {
                ownerIndex = opponentIndex;
                System.out.println("오너가 " + contestants[ownerIndex].getName() + "로 변경되었습니다.");
            }
            System.out.println();
        }

        System.out.println("게임을 종료합니다...");
    }
}

public class OpenChallenge_5 {
    public static void main(String[] args) {
        new Game().run();
    }
}
