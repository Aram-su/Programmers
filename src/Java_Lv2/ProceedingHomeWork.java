package Java_Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class ProceedingHomeWork {
    public static void main(String[] args) {
//        String[][] str = {
//                 {"math", "12:30", "40"}, {"english", "12:10", "20"}, {"korean", "11:40", "30"}
//        };
//        String[][] str = {
//                {"aaa", "12:00", "20"},
//                {"bbb", "12:10", "30"},
//                {"ccc", "12:40", "10"}
//        };

        String[][] str = {
                {"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}
        };


        String[] tmp = solution(str);
        for ( String s : tmp )
            System.out.println(s);
    }

    public static String[] solution(String[][] plans) {
        String[] answer = {};

        ArrayList<String> output = new ArrayList<>();
        Stack<String[]> hwStack = new Stack<>();
        int curTime = timeParser(plans[0][1]);

        Comparator<String[]> comparator = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        };
        Arrays.sort(plans, comparator );


        for (int i = 0; i < plans.length -1; i++) {

            int time = isHwFinish(plans[i], plans[i+1]);

            if ( time == 0 ){ //앞선 과제가 끝나고 시간이 딱 맞음
                output.add( plans[i][0] );
                curTime = curTime + Integer.parseInt(plans[i][2]);
            } else if ( time < 0 ) { //앞선 과제가 안끝남
                plans[i][2] = Integer.toString(time * -1);
                hwStack.add(plans[i]);
                curTime = timeParser(plans[i + 1][1]);
            } else { //앞선 과제가 끝나고 시간이 남음
                output.add( plans[i][0] );
                curTime = curTime + Integer.parseInt(plans[i][2]);

                while (!hwStack.isEmpty()) {

                    String[] hwTmp = hwStack.pop();
                    time = isStackHwFinish( curTime, hwTmp[2] , plans[i+1]);
                    if ( time == 0){ //과제가 끝나고 시간이 딱 맞음, 다음 새 과제로 넘어간다.
                        output.add(hwTmp[0]);
                        curTime = curTime + Integer.parseInt(hwTmp[2]);
                        break;
                    } else if ( time > 0 ){ //과제가 끝나고 시간이 남음, 다음 스택 과제를 진행한다.
                        output.add(hwTmp[0]);
                        curTime = curTime + Integer.parseInt(hwTmp[2]);
                    } else{ //앞선 과제를 못 끝냄, 다음 과제 시작
                        hwTmp[2] = Integer.toString(time * -1);
                        hwStack.add(hwTmp);
                        curTime = timeParser(plans[i + 1][1]);
                        break;
                    }

                }
            }

        }

        output.add(plans[plans.length-1][0]);
        while( !hwStack.isEmpty() ){
            output.add(hwStack.pop()[0]);
        }
        return output.toArray(new String[0]);
    }
    public static int isHwFinish(String[] cur, String[] next){

        String[] tmp = cur[1].split(":");

        int hour = Integer.parseInt(tmp[0]);
        int minute = Integer.parseInt(tmp[1]);

        minute += Integer.parseInt(cur[2]);
        if ( minute >= 60 ){
            hour += (minute/60);
            minute %= 60;
        }
        tmp = next[1].split(":");
        int next_hour = Integer.parseInt(tmp[0]);
        int next_minute = Integer.parseInt(tmp[1]);

        return (next_hour - hour) * 60 + (next_minute - minute);
    }
    public static int isStackHwFinish(int time, String howMuch ,String[] next){
        String[] tmp = next[1].split(":");
        int next_hour = Integer.parseInt(tmp[0]);
        int next_minute = Integer.parseInt(tmp[1]);

        return next_hour * 60 + next_minute - time - Integer.parseInt(howMuch);
    }
    public static int timeParser(String time){
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
}
