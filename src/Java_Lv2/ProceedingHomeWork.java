package Java_Lv2;

import java.util.*;

public class ProceedingHomeWork {
    public static void main(String[] args) {
        String[][] str = {
                 {"math", "12:30", "40"}, {"english", "12:10", "20"}, {"korean", "11:40", "30"}
        };

        solution(str);
    }

    public static String[] solution(String[][] plans) {
        String[] answer = {};
        ArrayList<String> output = new ArrayList<>();
        Stack<String[]> hwStack = new Stack<>();
        Comparator<String[]> comparator = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        };
        Arrays.sort(plans, comparator);

        for (int i = 0; i < plans.length -1; i++) {

            if ( isHwFinish(plans[i], plans[i+1]) ){ //앞선 과제가 끝남
                output.add( plans[i][0] );
            } else{
                hwStack.add(plans[i]); //앞선 과제가 안끝남
            }
        }
        output.add(plans[plans.length-1][0]);


        return output.toArray(new String[0]);
    }
    public static boolean isHwFinish(String[] cur, String[] next){
        String[] tmp = cur[1].split(":");

        int hour = Integer.parseInt(tmp[0]);
        int minute = Integer.parseInt(tmp[1]);

        minute += Integer.parseInt(cur[2]);
        if ( minute >= 60 ){
            minute -= 60;
            hour += 1;
        }
        cur[1] = String.format("%2d", hour)+":"+String.format("%2d", minute);

        //다음 과제 전에 앞선 과제가 끝났으면 true 반환
        if ( cur[1].compareTo(next[1]) <= 0)
            return true;

        // 다음 과제 전에 앞선 과제가 끝나지 않았으면
        // 앞선 과제의 남은 시간을 계산하고 false를 리턴한다.
        tmp = cur[1].split(":");
        hour = Integer.parseInt(tmp[0]);
        minute = Integer.parseInt(tmp[1]);

        tmp = next[1].split(":");
        int next_hour = Integer.parseInt(tmp[0]);
        int next_minute = Integer.parseInt(tmp[1]);

        cur[2] = String.format("%d", (next_hour - hour) * 60 + (next_minute - minute));

        return false;
    }
}
