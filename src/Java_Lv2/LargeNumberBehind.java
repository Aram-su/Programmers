package Java_Lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class LargeNumberBehind {
    public static void main(String[] args) {


//        int[] nums = {2, 3, 3, 5};
        int[] nums = {9, 1, 5, 3, 6, 2};
        int[] ans = solution( nums );

        System.out.println(Arrays.toString(ans));

    }
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length-1; i++) {

            int num = -1;
            for( int j = i+1 ; j < numbers.length ; j++){
                if ( num == -1 && numbers[i] < numbers[j] ){
                    num = numbers[j];
                    break;
                }
            }
            answer[i] = num;
        }
        answer[answer.length-1] = -1;

        return answer;
    }
}
