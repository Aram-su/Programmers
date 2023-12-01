package Java_Lv3;

import java.util.Arrays;

public class NumberGame {

    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();

        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};

        System.out.println(numberGame.solution(a, b));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int idx = 0;
        for (int num : A) {
            while ( idx < B.length && num >= B[idx]) {
                idx++;
            }
            if(idx == B.length){
                break;
            }
            answer++;
            idx++;
        }
        return answer;
    }
}
