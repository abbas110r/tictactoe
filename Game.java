import java.util.*;

public class Game {
    private Player p1, p2;
    private Board board;

    public void startGame() {

        Scanner sc = new Scanner(System.in);
        p1 = takeInput(1);
        p2 = takeInput(2);
        board = new Board(p1.getSymbol(), p2.getSymbol());
        boolean player1Turn = true;
        int status = Board.INCOMPLETE;
        while (status == Board.INCOMPLETE || status == Board.INVALID) {
            if (player1Turn) {
                System.out.println("Player 1 " + p1.getName() + "'s turn");
                System.out.println("Enter x : ");
                int x = sc.nextInt();
                System.out.println("Enter y : ");
                int y = sc.nextInt();
                status = board.move(p1.getSymbol(), x, y);
                if (status != Board.INVALID) {
                    player1Turn = false;
                    board.print();
                } else {
                    System.out.println("Invalid Move!Try Again");
                }
            } else {
                System.out.println("Player 1 " + p2.getName() + "'s turn");
                // System.out.println("Player 1 " + p2.getName() + "'s turn");
                System.out.println("Enter x : ");
                int x = sc.nextInt();
                System.out.println("Enter y : ");
                int y = sc.nextInt();
                status = board.move(p2.getSymbol(), x, y);
                if (status != Board.INVALID) {
                    player1Turn = true;
                    board.print();
                } else {
                    System.out.println("Invalid Move!Try Again");
                }

            }

        }
        if (status == Board.PLAYER_1_WINS) {
            System.out.println("Player 1 - " + p1.getName() + "wins !!");
        } else if (status == Board.PLAYER_2_WINS) {
            System.out.println("Player 2 - " + p2.getName() + "wins !!");
        } else {
            System.out.println("Draw !!");
        }

    }

    private Player takeInput(int num) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player" + num + " name ");
        String name = sc.nextLine();
        System.out.println("Enter player" + num + " symbol ");
        char symbol = sc.next().charAt(0);
        Player p = new Player(name, symbol);
        return p;

    }
}
B