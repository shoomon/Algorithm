//25.04.20
//15:14 15:43 16:38
//문제 이해 잘못함 모든 상자 다 열때까지 뽑는줄 -> 이 경우 백트래킹 + 유니온파인드

class Solution {
    static int answer;
    
    public int solution(int[] cards) {
        
        for(int i = 0; i < cards.length; i++){
            simulation(i, new boolean[cards.length], cards, 1, 1);
        }
        
        return answer;
    }
    
    static void simulation(int start, boolean[] visited, int[] cards, int score, int groupNum){
        if(groupNum == 3) {
            answer = Math.max(answer, score);
            return;
        }
        
        int cur = start;
        int count=0;
        
        while(!visited[cur]){
            visited[cur] = true;
            count++;
            cur = cards[cur]-1;
        }
        
        if(groupNum==1 && count==cards.length) return;
        
        if(groupNum == 2){
            while(visited[cur]){
                visited[cur] = false;
                cur = cards[cur]-1;
            }
        }
        
        for(int i = 0; i < cards.length; i++){
            if(visited[i]) continue;
            simulation(i, visited, cards, score*count, groupNum+1);
        }
        
    }
}