class Board{
    private int size;
    private int count;
    private char[][] board;

    Board(){}

    Board(int n){
        size = n;
        count = n*n;
        this.board = new char[n][n];
    }

    public void setSize(int n){
        size = n;
    }   
    
    // 0 means updated, 1 means won, 2 means draw, 3 means invalid move
    public int move(int x,int y,User user){
        
        if(!isValid(x,y)){
            printBoard();
            System.out.println("Invalid Move!! "+x+" "+y);
            return 3;
        }

        board[x][y] = user.getMove();
        this.count--;
        
        printBoard();

        if(userWon(user,x,y)){
            System.out.println(user.getName()+" won the game, Well Playerd!!");
            return 1;
        }
        
        if(count==0){
            System.out.println("Game Draw!!");
            return 2;
        }

        return 0;
    }

    private boolean userWon(User user,int x,int y){
        boolean rowWin = true;
        //row check
        for(int i=0;i<size;i++){
            if(board[x][i]!=user.getMove()){
                rowWin = false;
            }
        }

        boolean colWin = true;
        for(int i=0;i<size;i++){
            if(board[i][y]!=user.getMove()){
                colWin = false;
            }
        }

        boolean diagWin1 = true;
        for(int i=0;i<size;i++){
            if(board[i][i]!=user.getMove()){
                diagWin1 = false;
            }
        }

        boolean diagWin2 = true;
        for(int i=0;i<size;i++){
            if(board[i][size-i-1]!=user.getMove()){
                diagWin2 = false;
            }
        }

        if(colWin || rowWin || diagWin1 || diagWin2){
            return true;
        }

        return false;
    }

    private boolean isValid(int x,int y){
        if(x<0 || x>=size || y<0 || y>=size || (int)(board[x][y])!=0){
            return false;
        }
        System.out.println();
        return true;
    }

    private void printBoard(){
        System.out.println("-----------");

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(((int)board[i][j])!=0)
                    System.out.print(" "+board[i][j]+" ");
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }

        System.out.println("-----------");
    }

}