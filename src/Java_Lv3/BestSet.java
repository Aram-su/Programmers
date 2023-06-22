package Java_Lv3;

import java.util.Arrays;

public class BestSet {
    public static void main(String[] args) {
        int n = 2;
        int s = 8;
        solution(n, s);
    }
    public static int[] solution(int n, int s) {
        int[] arr = new int[n];

        // 불가능한 경우는 바로 처리함
        if ( s/n == 0 )
            return new int[]{-1};

        // 각 값들의 크기가 비슷해야 가장 큰 값이 나옴
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s / n;
        }
        // 나누어 떨어지지 않은 수가 존재
        int remainNum = s % n;

        // 정렬하지 않기 위해 뒤에서 부터 증가시킨다
        for( int i = 0 ; i < remainNum ; i++ ){
            arr[arr.length - 1 - i ]++;
        }

        return arr;
    }
}
