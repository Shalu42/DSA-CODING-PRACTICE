import java.util.Scanner;

class Problem11 {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') xCount++;
                else if (c == 'O') oCount++;
            }
        }
        
        if (oCount > xCount || xCount > oCount + 1) return false;
        
        if (isWinner(board, 'X') && xCount != oCount + 1) return false;
        
        if (isWinner(board, 'O') && xCount != oCount) return false;
        
        return true;
    }
    
    private boolean isWinner(String[] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) return true;
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) return true;
        }
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) return true;
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) return true;
        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Problem11 problem = new Problem11();
        
        String[] board = new String[3];
        System.out.println("Enter the Tic-Tac-Toe board:");
        for (int i = 0; i < 3; i++) {
            board[i] = scanner.nextLine();
        }
        
        boolean result = problem.validTicTacToe(board);
        System.out.println(result);
        
        scanner.close();
    }
}
