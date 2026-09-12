class Solution {
    int[][] dungeons;
    int[] V;
    int N, maxNum;
    
    void dfs(int now, int depth) //인자로 피로도를 넘김
    {
       maxNum = Math.max(maxNum , depth);
        
       for(int i=0; i<N; i++)
       {
           if(V[i] == 1) continue;
           if(now >= dungeons[i][0])
           {
               V[i] = 1;
               dfs(now - dungeons[i][1], depth+1);
               V[i] = 0;
           }
       }
    }
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        this.dungeons = dungeons;
        V = new int[N];
        maxNum = 0;
        
        dfs(k, 0);
        
        return maxNum;
    }
}