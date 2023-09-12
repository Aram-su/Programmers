package Java_Lv2;

import java.util.Arrays;

public class SeesawPartner {

    public static void main(String[] args) {

        SeesawPartner s = new SeesawPartner();

        System.out.println(s.solution(new int[]{100, 180, 360, 100, 270}));
    }

    private int[] weights;

    public long solution(int[] weights) {
        long answer = 0;
        this.weights = weights;

        Arrays.sort(weights);
        int cnt = 0;
        for (int i = 0; i < weights.length - 1; i++) {
            if (i > 0 && weights[i - 1] == weights[i]) {
                cnt--;
                answer += cnt;
                continue;
            }

            int end = getMaxRange(i, weights.length - 1);

            int left = weights[i];
            cnt = 0;
            for (int j = i + 1; j <= end; j++) {

                int right = weights[j];

                if ((left == right) || (4 * left == 3 * right) ||
                        (3 * left == 2 * right) || (2 * left == right)) {
                    cnt++;
                }

            }
            answer += cnt;
        }
        return answer;
    }

    private int getMaxRange(int start, int end) {

        while (start < end) {
            int mid = (start + end) / 2;
            if (2 * weights[start] < weights[mid]) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}

