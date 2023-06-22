package Java_Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargeNumberBehind {
    public static void main(String[] args) {


//        int[] nums = {2, 3, 3, 5};
        int[] nums = {9, 1, 5, 3, 6, 2};
        int[] ans = solution( nums );

        System.out.println(Arrays.toString(ans));

    }
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> notFound = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {

            while ( !notFound.isEmpty() && numbers[notFound.peek()] < numbers[i] ){
                answer[notFound.pop()] = numbers[i];
            }
            notFound.add(i);
        }

        for (int i = 0; i < answer.length; i++) {
            if( answer[i] == 0 ) answer[i] = -1;
        }

        return answer;
    }
}
