import java.util.*;
import java.io.*;

public class TicTacToe {

    public static void printGame(char[][] ticTacToe){
        for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print((ticTacToe[i][j])+" ");
                }
                System.out.println();
            }
    }

    public static void main(String args[]){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String[] s = br.readLine().trim().split(" ");
            char xPiece = s[0].charAt(0);
            String player1 = s[1];
            s = br.readLine().trim().split(" ");
            char yPiece = s[0].charAt(0);
            String player2 = s[1];
            boolean p1 = true;
            String str="";
            char c = '-';
            char[][] ticTacToe = new char[3][3];
            int a=0,b=0;
             for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    ticTacToe[i][j]='-';
                }
             }
            boolean gameOver = false;
            printGame(ticTacToe);
            while(true && !gameOver){

                String input = br.readLine();

                if(input.contains("exit")){
                    break;
                }
                if(p1)
                    c = 'X';
                else
                    c = 'O';
                    
                while(true){
                    s = input.split(" ");
                    a = Integer.parseInt(s[0]);
                    b = Integer.parseInt(s[1]);
                    a = a-1;
                    b = b-1;
                    if(ticTacToe[a][b] != '-')
                        System.out.println("Invalid Move");
                    else{
                        ticTacToe[a][b] = c;
                        printGame(ticTacToe);
                        break;
                    }
                }
                

            c = '-';
            for(int i=0;i<3;i++){
                if(ticTacToe[i][0]!='-' && ticTacToe[i][0]==ticTacToe[i][1] && ticTacToe[i][1]==ticTacToe[i][2])
                    c = ticTacToe[i][0];
            }

            for(int i=0;i<3;i++){
                if(ticTacToe[0][i]!='-' && ticTacToe[0][i]==ticTacToe[1][i] && ticTacToe[1][i]==ticTacToe[2][i])
                    c = ticTacToe[0][i];
            }
            if(ticTacToe[0][0]!='-' && ticTacToe[0][0]==ticTacToe[1][1] && ticTacToe[1][1]==ticTacToe[2][2])
                c = ticTacToe[0][0];

            if(ticTacToe[0][2]!='-' && ticTacToe[0][2]==ticTacToe[1][1] && ticTacToe[1][1]==ticTacToe[2][0])
                c = ticTacToe[0][2];

            if(c == 'X'){
                System.out.println(player1+" won the game");
                gameOver = true;
            }
            else if(c == 'O'){
                System.out.println(player2+" won the game");
                gameOver = true;
            }
            else if(c == '-'){
                System.out.println("Game Over");
                gameOver = true;
            }
            else
                p1 = !p1;
          }
        }
        
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}