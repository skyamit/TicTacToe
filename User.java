public class User{
    private String name;
    private char move;
    
    User(){}
    
    User(String n,char m){
        name = n;
        move = m;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    public void setMove(char c){
        this.move = c;
    }

    public char getMove(){
        return this.move;
    }
}