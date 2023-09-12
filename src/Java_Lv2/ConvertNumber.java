package Java_Lv2;

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

class ConvertNumber {
    public int solution(int x, int y, int n) {
        Queue<int[]> que = new LinkedList<>();
        HashSet<Integer> distinct = new HashSet<>();

        que.add(new int[]{x, 0});

        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int num = tmp[0];
            int cnt = tmp[1];

            if (num > y) continue;

            if (num == y) {
                return cnt;
            } else {
                cnt++;
                if (!distinct.contains(num + n)) {
                    distinct.add(num + n);
                    que.add(new int[]{num + n, cnt});
                }
                if (!distinct.contains(num * 2)) {
                    distinct.add(num * 2);
                    que.add(new int[]{num * 2, cnt});
                }
                if (!distinct.contains(num * 3)) {
                    distinct.add(num * 3);
                    que.add(new int[]{num * 3, cnt});
                }
            }
        }
        return -1;
    }
}
