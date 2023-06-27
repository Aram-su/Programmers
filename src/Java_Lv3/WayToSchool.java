package Java_Lv3;

import java.util.LinkedList;
import java.util.Queue;
public class WayToSchool {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(solution(m,n,puddles));

    }
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] way = new int[n][m];

        // 물 웅덩이는 지나가지 않도록 매우 큰 값을 입력
        for (int[] puddle : puddles) {
            way[ puddle[1]-1 ][ puddle[0]-1 ] = -1;
        }

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});

        while (!que.isEmpty()) {
            int[] pos = que.poll();
            int x = pos[0];
            int y = pos[1];
            if ( x == n-1 && y == m-1 ) answer++;
            if ( answer > 1000000007 ) answer %= 1000000007;

            // 아래, 오른쪽 탐색
            if ( x + 1 < n && way[x+1][y] != -1 ) {
                que.add(new int[]{x + 1, y});
                way[x + 1][y] = way[x][y] + 1;
            }
            if ( y + 1 < m && way[x][y+1] != -1 ) {
                que.add(new int[]{x, y + 1});
                way[x][y+1] = way[x][y] + 1;
            }
        }

        return answer;
    }

}
