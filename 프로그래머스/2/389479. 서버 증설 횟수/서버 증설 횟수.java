//25.11.28
//최대 서버 수 1*1000, 서버별 ttl 관리 배열
//1시간마다 서버 수 체크 후 증설결정 -> 1000*24

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[1001];
        
        for(int i = 0; i < 24; i++){
            int curServ = getServerCount(server);
            int reqServ = players[i] == 0 ? 0 : players[i]/m;
            
            if(curServ < reqServ){
                int need = reqServ-curServ;
                increseServ(server, need, k);
                answer += need;
            }
            decreseCount(server);
        }
        
        return answer;
    }
    
    static int getServerCount(int[] server){
        int answer = 0;
        
        for(int i = 1; i < 1001; i++){
            if(server[i] > 0) answer++;
        }
        
        return answer;
    }
    
    static void decreseCount(int[] server){
        for(int i = 1; i < 1001; i++) {
            if(server[i] > 0) server[i]--;
        }
    }
    
    static void increseServ(int[] server, int quantity, int k){
        int count = quantity;
        for(int i = 1; i < 1001; i++){
            if(server[i] == 0){
                server[i] = k;
                count--;
                if(count == 0) return;
            }
        }
    }
}