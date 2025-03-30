//25.03.30
//12:56 02:09 답지참조
//그리디 (or 완탐 백트래킹: 매 번 10가지의 선택지, 10^10 = 100억)
//아니고 뒤집을지 아닐지만 정하면 됨 -> 2^20 = 100만

class Solution {
    static int row, col, answer;
    static boolean[][] simulMap;
    
    public int solution(int[][] beginning, int[][] target) {
        answer = Integer.MAX_VALUE;
        row = beginning.length;
        col = beginning[0].length;
        simulMap = new boolean[row][col];
        
        select(0, new boolean[row+col], beginning, target, 0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    static void select(int depth, boolean[] isSelected, int[][] map, int[][] target, int count){
        if(depth == isSelected.length){
            copy(map);
            operation(isSelected);
            if(check(target)) answer = Math.min(answer, count);
            return;
        }
        
        isSelected[depth] = true;
        select(depth+1, isSelected, map, target, count+1);
        
        isSelected[depth] = false;
        select(depth+1, isSelected, map, target, count);
    }
    
    static void operation(boolean[] isSelected){
        for(int i = 0; i < row; i++){
            if(isSelected[i]){
                for(int j = 0; j < col; j++) simulMap[i][j] = !simulMap[i][j];
            }
        }
        
        for(int j = row; j < isSelected.length; j++){
            if(isSelected[j]){
                for(int i = 0; i < row; i++) simulMap[i][j-row] = !simulMap[i][j-row];
            }
        }
    }
    
    static boolean check(int[][] target){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if((simulMap[i][j] && target[i][j] == 0) 
                   || (!simulMap[i][j] && target[i][j] == 1)) return false;
            }
        }
        return true;
    }
    
    static void copy(int[][] origin){
        for(int i = 0; i < origin.length; i++){
            for(int j = 0; j < origin[0].length; j++) simulMap[i][j] = origin[i][j]==1;
        }
    }
}