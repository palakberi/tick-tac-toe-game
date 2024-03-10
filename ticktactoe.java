import java.util.Scanner;

class ticktactoe{
    public static void main(String[] args){
        int n=3;
        char[][] brd= new char[n][n];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                brd[i][j]='-';
            }
        }

        Scanner sc= new Scanner(System.in);
        System.out.println("Play Tick Tack Toe\n");
        System.out.println("Player 1, Enter your name:");
        String player1=sc.nextLine();
        System.out.println("\n");
        System.out.println("Player 2, Enter your name:");
        String player2=sc.nextLine();
        System.out.println("\n");

        boolean p1=true;

        boolean gameEnd=false;
        while(!gameEnd){
            drawBoard(brd); //draw board

            if(p1){
                System.out.println(player1 + "'s Turn (X):");
            }
            else{
                System.out.println(player2 + "'s Turn (O):");
            }

            char c= '-';
            if(p1){
                c='X';
            }
            else{
                c='O';
            }

            int row=0;
            int col=0;

            while(true){
                System.out.println("Enter a row number:");
                row=sc.nextInt();
                System.out.println("Enter a column number:");
                col=sc.nextInt();

                if(row<0 || col<0 || row>=n || col>=n){
                    System.out.println("This position is not valid.");
                }
                else if(brd[row][col]!='-'){
                    System.out.println("Someone has already made a move at this position.");
                }
                else{
                    break;
                }
            }

            brd[row][col]=c;

            if(playerWon(brd)=='X'){
                System.out.println(player1 + " has won!");
                gameEnd=true;
            }
            else if(playerWon(brd)=='O'){
                System.out.println(player2 + " has won!");
                gameEnd= true;
            }
            else{
                if(boardIsFull(brd)){
                   System.out.println("Its a tie");
                   gameEnd=true;
                }
                else{
                    p1=!p1;
                }
            }
        }
        drawBoard(brd);
    }


    public static void drawBoard(char[][] brd){
        System.out.println("Board:");
        for(int i=0;i<brd.length;i++){
            for(int j=0;j<brd[i].length;j++){
                System.out.print(brd[i][j]);
            }
            System.out.println();
        }
    }

    public static char playerWon(char[][] brd){
        for(int i=0;i<brd.length;i++){
            boolean inRow=true;
            char val=brd[i][0];

            if(val=='-'){
                inRow=false;
            }
            else{
                for(int j=1;j<brd[i].length;j++){
                    if(brd[i][j]!=val){
                        inRow=false;
                        break;
                    }
                }
            }

            if(inRow){
                return val;
            }
        }

        for(int j=0;j<brd[0].length;j++){
            boolean inCol=true;
            char val=brd[0][j];

            if(val=='-'){
                inCol=false;
            }
            else{
                for(int i=1;i<brd.length;i++){
                    if(brd[i][j]!=val){
                        inCol=false;
                        break;
                    }
                }
            }
            if(inCol){
                return val;
            }
        }
        
        boolean inDiag1=true;
        char val1=brd[0][0];
        if(val1 == '-'){
            inDiag1=false;
        }
        else{
            for(int i =1;i<brd.length;i++){
                if(brd[i][i]!=val1){
                    inDiag1=false;
                    break;
                }
            }
        }
        
        if(inDiag1){
            return val1;
        }


        boolean inDiag2=true;
        char val2=brd[0][brd.length-1];

        if(val2=='-'){
            inDiag2=false;
        }
        else{
            for(int i=1;i<brd.length;i++){
                if(brd[i][brd.length-1-i]!=val2){
                    inDiag2=false;
                    break;
                }
            }
        }

        if(inDiag2){
            return val2;
        }

        return ' ';
    }


    public static boolean boardIsFull(char[][] brd){
        for(int i=0;i<brd.length;i++){
            for(int j=0;j<brd[i].length;j++){
                if(brd[i][j]=='-'){
                    return false;
                }
            }
        }
        return true;
    }

}