package Java_Lv2;

import java.util.ArrayList;
import java.util.Collections;

public class MiningForMinerals {
    public static void main(String[] args) {

        int[] picks = {1,3,2};  // 다이아, 철, 돌 곡괭이 갯수
       String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron",
                "diamond", "iron", "stone"};
//        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond",
//                "iron", "iron", "iron", "iron", "iron",
//                "diamond"};
//        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron",
//                "diamond", "iron", "stone","iron", "iron",
//                "diamond","diamond"};

        int ans = solution(picks, minerals);
        System.out.println(ans);
    }
    // 1. 사용 곡괭이 하나 선택
    // 2. 곡괭이는 한번 쓰면 5번 사용할 때 까지 사용
    // 3. 광물은 주어진 순서대로 캠
    // 4. 모든 광물 캐거나, 곡괭이가 없을 때 까지 캠
    // 5. 최소한의 피로도 리턴
    // 광물의 집합의 수가 곡괭이의 수보다 많을 때 마지막 광물이 우선순위가 높은 경우

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        ArrayList<Integer> vals = new ArrayList<>();

        // 광물을 5개 단위로 나눠서 각 구간의 값을 구해보자
        // 광물을 5개로 나누어 각각의 우선순위를 구했을 때 주의할 점이 존재
        // 곡괭이 1개는 1개의 집합에 대해 계산이 가능
        // 이 때, 집합의 수가 곡괭이의 수보다 많아 뒤의 집합은 캐지 못하는데
        // 뒤의 집합의 우선순위가 높아 정렬 시 앞으로 오는 경우 에러가 발생한다.
        // 그러므로 집합을 나누는 과정에서 곡괭이가 충분하다면 집합을 전부 계산하고
        // 집합이 더 많다면(곡괭이가 부족) 집합의 수 만큼만 계산한다.
        int val = 0;
        int picksSum = picks[0] + picks[1] + picks[2];
        for (int i = 0; i < Math.min(picksSum*5, minerals.length) ; i++) {
            if ( i % 5 == 0 && i != 0){
                vals.add(val);
                val = 0;
            }
            if ( minerals[i].equals("diamond") ) val += 100;
            else if ( minerals[i].equals("iron") ) val += 10;
            else if ( minerals[i].equals("stone") ) val += 1;
        }
        vals.add(val);

        vals.sort(Collections.reverseOrder());

        // 제일 높은 값에 제일 높은 곡괭이를 준다
        for (int i = 0; i < vals.size(); i++) {

            if ( (picks[0] + picks[1] + picks[2]) < 0 ) break;

            int value = vals.get(i);
            if ( picks[0] > 0 ){
                answer += value/100;
                answer += (value%100) /10;
                answer += value%10;
                picks[0]--;
            } else if ( picks[1] > 0 ){
                answer += value/100 * 5;
                answer += (value%100) /10;
                answer += value%10;
                picks[1]--;
            } else if ( picks[2] > 0 ){
                answer += value/100 * 25;
                answer += (value%100) /10 * 5;
                answer += value%10;
                picks[2]--;
            }
        }
        return answer;
    }
}
