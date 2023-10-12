package Java_Lv2;

import java.util.Arrays;

public class NumberBlock {

    public static void main(String[] args) {
        long begin = 100000014;
        long end = 100000016;
        NumberBlock numberBlock = new NumberBlock();
        int[] solution = numberBlock.solution(begin, end);
        int[] solution2 = numberBlock.solution2(begin, end);

        for (int i = 0; i < solution.length; i++) {
            if (solution[i] != solution2[i])
                System.out.println(solution[i] + " " + solution2[i]);
        }

//        System.out.println(Arrays.toString(solution));
//        System.out.println(Arrays.toString(solution2));
        System.out.println("finish");
    }

    public int[] solution(long begin, long end) {

        int[] answer = new int[(int) (end - begin) + 1];

        for (int i = 0; i < answer.length; i++) {
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

    public int[] solution2(long begin, long end) {

        int[] answer = new int[(int) (end - begin) + 1];

        for (int i = 0; i < answer.length; i++) {
            long num = begin + i;

            //약수 구하기
            int max_divisor = 1;
            for (long div = 2; div <= Math.sqrt(num); div++) {
                if (num % div == 0) {
                    int divisor1 = (int) div;
                    int divisor2 = (int) (num / div);

                    max_divisor = Math.max(max_divisor, divisor1);
                    if ( divisor2 <= 10000000)
                        max_divisor = Math.max(max_divisor, divisor2);
                }
            }
            answer[i] = max_divisor;
        }
        if (begin == 1)
            answer[0] = 0;
        return answer;
    }
}
