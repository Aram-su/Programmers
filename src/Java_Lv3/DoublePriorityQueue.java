package Java_Lv3;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public static void main(String[] args) {

    }
    public static int[] solution(String[] operations) {

        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < operations.length; i++) {
            String[] tmp = operations[i].split(" ");

            if ( tmp[0].equals("I") ) {
                maxQue.add(Integer.parseInt(tmp[1]));
                minQue.add(Integer.parseInt(tmp[1]));
            } else{
                if(tmp[1].equals("1")){ //최댓값 삭제
                    minQue.remove( maxQue.poll() ); //max에서 최댓값 삭제하고 min에서도 해당 값 삭제
                }
                else { //최솟값 삭제
                    maxQue.remove( minQue.poll() ); //min에서 최솟값 삭제하고 max에서도 해당 값 삭제
                }
            }

        }
        if ( maxQue.isEmpty() )
            return new int[]{0, 0};
        return new int[]{maxQue.poll(), minQue.poll()};
    }

}
