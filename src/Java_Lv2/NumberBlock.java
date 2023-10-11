package Java_Lv2;

import java.util.Arrays;

public class NumberBlock {

    public static void main(String[] args) {
        long begin = 100000014;
        long end = 100000016;
        NumberBlock numberBlock = new NumberBlock();
        int[] solution = numberBlock.solution(begin, end);

        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(long begin, long end) {

        int len = (int) (end - begin) + 1;

        int[] answer = new int[(int) (end - begin) + 1];

        for (int i = 0; i < len; i++) {
            long num = begin + i;

            for (long div = 2; div <= Math.sqrt(num); div++) {

                if (num % div == 0) {
                    if (num / div > 10000000) {
                        answer[i] = (int) div;
                        continue;
                    } else {
                        answer[i] = (int) (num / div);
                    }
                    break;
                }
            }
            if (answer[i] == 0)
                answer[i] = 1;
        }
        if (begin == 1)
            answer[0] = 0;

        return answer;
    }
}
