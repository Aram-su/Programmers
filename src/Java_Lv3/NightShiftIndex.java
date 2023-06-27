package Java_Lv3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class NightShiftIndex {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {4, 3, 3};

        System.out.println(solution(n, works));

    }

    public static long solution(int n, int[] works) {
        long answer = 0;

        int workSum = 0;
        for ( int work : works )
            workSum += work;
        if ( workSum < n ) return 0; // 퇴근까지 남은 시간보다 작업량이 적으면 야근을 하지 않으므로 바로 0을 리턴

        // 가장 많이 남은 작업을 하나씩 줄이면 된다.
        // (남은 작업량을 최대한 비슷하게 맞추어 주면 됨
        // 가장 많이 남은 작업을 1씩 줄인다.
        // 우선순위 큐를 이용해 가장 많이 남은 작업을 1씩 감소시킨다.

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for ( int work : works )
            pq.add( work );

        while( n > 0 ){
            pq.add( pq.poll() - 1 );
            n--;
        }
        while (!pq.isEmpty()) {
            answer += (Math.pow( pq.poll(), 2));
        }
        return answer;
    }
}
