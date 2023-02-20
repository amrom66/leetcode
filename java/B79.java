import java.util.ArrayList;
import java.util.List;

public class B79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a'}};
        String word = "a";
        boolean out = new B79().exist(board, word);
        System.out.println(out);
    }
    
    private boolean flag = false;

    public boolean exist(char[][] board, String word) {
        if(board.length ==0 || board[0].length ==0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                backTrack(board, i, j, word, 0, new ArrayList<Character>(), visited);
                if(flag) return true;
            }
        }
        return flag;
    }
    
    public void backTrack(char[][] board, int rowIndex, int colIndex, String word, int index, List<Character> track, boolean[][] visited){
        if(track.size() == word.length()){
            flag = true;
            return ;
        }
        if(rowIndex <0 || colIndex <0 || rowIndex >= board.length || colIndex >=board[0].length){
            return ;
        }
        
        if(visited[rowIndex][colIndex]) return;

        char ch = word.charAt(index);
        if(ch == board[rowIndex][colIndex]){
            track.add(ch);
            visited[rowIndex][colIndex] = true;
            backTrack(board, rowIndex-1, colIndex, word, index+1, track, visited);
            backTrack(board, rowIndex, colIndex-1, word, index+1, track, visited);
            backTrack(board, rowIndex+1, colIndex, word, index+1, track, visited);
            backTrack(board, rowIndex, colIndex+1, word, index+1, track, visited);
            track.remove(track.size()-1);
            visited[rowIndex][colIndex] = false;
        }

        return ;
    }

}
