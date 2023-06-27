package Java_Lv3;

import java.util.LinkedList;
import java.util.Queue;
public class WayToSchool {
    private static int[][] pud;
    private static final int MOD_NUM = 1000000007;
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(solution(m,n,puddles));

    }
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        pud = puddles;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});

        while (!que.isEmpty()) {
            int[] pos = que.poll();
            int x = pos[0];
            int y = pos[1];
            if (x == n - 1 && y == m - 1) {
                answer++;
                if ( answer > MOD_NUM ) answer %= MOD_NUM;
                continue;
            }

            // 아래, 오른쪽 탐색
            if ( x + 1 < n && !isPuddle(x+1, y) )
                que.add(new int[]{x + 1, y});

            if ( y + 1 < m && !isPuddle(x, y+1) )
                que.add(new int[]{x, y + 1});
        }
        return answer;
    }
    public static boolean isPuddle(int x, int y){
        for (int[] puddle : pud) {
            if ( puddle[1]-1 == x && puddle[0]-1 == y) return true;
        }
        return false;
    }
}
