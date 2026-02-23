import java.util.*;

public class TicTacToe {

    static char[] b = {' ','1','2','3','4','5','6','7','8','9'};

    static int[][] wins = {
        {1,2,3},{4,5,6},{7,8,9},   // rows
        {1,4,7},{2,5,8},{3,6,9},   // cols
        {1,5,9},{3,5,7}            // diagonals
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char p = 'X';

        while(true){

            print();

            System.out.print("Player " + p + " choose (1-9): ");
            int c = sc.nextInt();

            if(c<1 || c>9 || b[c]=='X' || b[c]=='O'){
                System.out.println("Invalid.");
                continue;
            }

            b[c] = p;

            if(win()){
                print();
                System.out.println("Player " + p + " wins!");
                break;
            }

            if(draw()){
                print();
                System.out.println("Draw!");
                break;
            }

            p = (p=='X') ? 'O' : 'X';
        }
    }

    static void print(){
        System.out.printf("\n %c | %c | %c\n", b[1],b[2],b[3]);
        System.out.println("---|---|---");
        System.out.printf(" %c | %c | %c\n", b[4],b[5],b[6]);
        System.out.println("---|---|---");
        System.out.printf(" %c | %c | %c\n\n", b[7],b[8],b[9]);
    }

    static boolean win(){
        for(int[] w : wins)
            if(b[w[0]]==b[w[1]] && b[w[1]]==b[w[2]])
                return true;
        return false;
    }

    static boolean draw(){
        for(int i=1;i<=9;i++)
            if(b[i]!='X' && b[i]!='O')
                return false;
        return true;
    }
}
