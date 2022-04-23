public class Board {
    private char[][] board;
    final private int size = 3;
    private int count;
    private char p1symbol, p2symbol;
    public final static int PLAYER_1_WINS = 1;
    public final static int PLAYER_2_WINS = 2;
    public final static int DRAW = 3;
    public final static int INCOMPLETE = 4;
    public final static int INVALID = 5;

    public Board(char p1symbol, char p2symbol) {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
        this.p1symbol = p1symbol;
        this.p2symbol = p2symbol;

    }
    public int move(char symbol,int x,int y){
        if(x<0 || y<0 ||x>=size || y>=size || board[x][y]!=' '){
            return INVALID;
        }
        board[x][y] = symbol;
        count++;
        if(board[x][0] == board[x][1] && board[x][0] == board[x][2]){
            if(symbol==p1symbol){
                return PLAYER_1_WINS;
            }
            return PLAYER_2_WINS;
        }
        if(board[0][y] == board[1][y] && board[0][y] == board[2][y]){
            if(symbol==p1symbol){
                return PLAYER_1_WINS;
            }
            return PLAYER_2_WINS;
        }
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            if(symbol==p1symbol){
                return PLAYER_1_WINS;
            }
            return PLAYER_2_WINS;
        }
        if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            if(symbol==p1symbol){
                return PLAYER_1_WINS;
            }
            return PLAYER_2_WINS;
        }
        if(count==size*size){
            return DRAW;
        }
        return INCOMPLETE;
    }
    public void print(){
        for(int i=0;i<size;i++){
            for(int j =0;j<size;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}
