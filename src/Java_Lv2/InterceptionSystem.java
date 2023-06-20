package Java_Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class InterceptionSystem {
    public static void main(String[] args) {
        int[][] arr = {
                {4,5},
                {4,8},
                {10,14},
                {11,13},
                {5,12},
                {3,7},
                {1,4}
        };

        int ans = solution(arr);
        System.out.println(ans);
    }
    public static int solution(int[][] targets) {
        int answer = 0;

        ArrayList<int[]> arr = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        for (int[] tg : targets) {
            arr.add(tg);
        }

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        arr.sort(comparator);



        return answer;
    }
}
