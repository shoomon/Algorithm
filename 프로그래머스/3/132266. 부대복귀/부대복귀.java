//25.03.23
//설계: 5분
//구현: 43+21분
//02:44 3:27 / 3:48
//최단거리 BFS
import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<Integer>[] adj = new List[n+1];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        Map<Integer, Integer> map = new HashMap<>();
        
        Arrays.fill(answer, -1);
        for(int i = 0; i < n+1; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < sources.length; i++){
            map.put(sources[i], i);
        }
        
        for(int[] i : roads){
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
        }
        
        q.offer(new int[] {destination, 0});
        visited[destination] = true;
        if(map.containsKey(destination)) answer[map.get(destination)]=0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i : adj[cur[0]]){
                if(!visited[i]){
                    visited[i] = true;
                    if(map.containsKey(i)){
                        answer[map.get(i)] = cur[1]+1;
                    }
                    q.offer(new int[] {i,cur[1]+1});
                }
            }
        }
        
        return answer;
    }
}