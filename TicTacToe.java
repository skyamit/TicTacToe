import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter player 1 name:");
        String n1 = sc.nextLine();

        System.out.println("Enter player 1 move sign:");
        char c = sc.nextLine().charAt(0);

        System.out.println("Enter player 2 name:");
        String n2 = sc.nextLine();

        System.out.println("Enter player 2 move sign:");
        char c2 = sc.nextLine().charAt(0);

        User one = new User(n1, c);
        User two = new User(n2, c2);

        System.out.println("Enter the size of the board:");
        int n = sc.nextInt();

        System.out.println("\nThe game has started!\n");

        Board board = new Board(n);

        boolean whosMove = true;

        while (true) {
            if (whosMove) {
                System.out.println("Enter x coordinate, " + one.getName() + ':');
                int x = sc.nextInt();

                System.out.println("Enter y coordinate, " + one.getName() + ':');
                int y = sc.nextInt();

                int move = board.move(x, y, one);

                if (move == 3) {
                    continue;
                }
                if (move == 1 || move == 2) {
                    break;
                }

                whosMove = false;
            }
            else {
                System.out.println("Enter x coordinate, " + two.getName() + ':');
                int x = sc.nextInt();

                System.out.println("Enter x coordinate, " + two.getName() + ':');
                int y = sc.nextInt();

                int move = board.move(x, y, two);

                if (move == 3) {
                    continue;
                }
                if (move == 1 || move == 2) {
                    break;
                }

                whosMove = true;
            }
        }

        sc.close();
    }
}