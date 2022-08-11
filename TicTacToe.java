import java.util.*;

public class TicTacToe{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Player 1 name : ");
        String n1 = sc.nextLine();
        System.out.println("Enter Player 1 move Sign : ");
        char c = sc.nextLine().charAt(0);

        System.out.println("Enter Player 2 name : ");
        String n2 = sc.nextLine();
        System.out.println("Enter Plyaer 2 move Sign : ");
        char c2 = sc.nextLine().charAt(0);

        User one = new User(n1,c);
        User two = new User(n2,c2);

        System.out.println("Enter the size of the board : ");
        int n = sc.nextInt();

        System.out.println("\nGame is started!!\n");

        Board board = new Board(n);

        boolean whosMove = true;

        while(true){
            if(whosMove){
                System.out.println("Enter x co-ordinate "+one.getName());
                int x = sc.nextInt();
                System.out.println("Enter y co-ordinate "+one.getName());
                int y = sc.nextInt();
                int move = board.move(x,y,one);
                if(move==3){
                    continue;
                }
                if(move==1 || move==2){
                    break;
                }
                whosMove = false;
            }
            else{
                System.out.println("Enter x co-ordinate "+two.getName());
                int x = sc.nextInt();
                System.out.println("Enter y co-ordinate "+two.getName());
                int y = sc.nextInt();
                int move = board.move(x,y,two);
                if(move==3){
                    continue;
                }
                if(move==1 || move==2){
                    break;
                }
                whosMove = true;
            }
        }

        sc.close();
    }
}