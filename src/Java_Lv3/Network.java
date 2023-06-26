package Java_Lv3;

import java.util.ArrayList;
import java.util.HashSet;

public class Network {
    public static void main(String[] args) {
        int[][] coms = {
                {1,1,0}, {1,1,1}, {0,1,1} };
        System.out.println( "result : "+solution(coms.length , coms ));
    }

    private static int[][] coms; //computers와 n을 클래스 필드로 지정하여 netCheck 호출 시
    private static int num; //메소드 인자로 전달하지 않아도 사용할 수 있도록 함
    private static boolean[] visited; //이미 방문한 com인지 확인하기 위한 필드
    private static int ans = 0;
    public static int solution(int n, int[][] computers) {
        coms = computers;
        num = n;
        visited = new boolean[n];

        //com을 0번 부터 방문
        for (int i = 0; i < num; i++) {
            if( !visited[i] ){
                ans++;
                netCheck(i);
            }
        }
        return ans;
    }
    public static void netCheck(int comIdx){
        visited[comIdx] = true;

        for (int i = 0; i < num; i++) {
            // 방문한 적 없고, 자기 자신 아니고, 연결되어 있으면 방문한다.
            if (!visited[i] && i != comIdx && coms[comIdx][i] == 1) {
                netCheck(i);
            }
        }
    }
}
