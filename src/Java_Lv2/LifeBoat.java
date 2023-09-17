package Java_Lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LifeBoat {
    public static void main(String[] args) {
        LifeBoat lb = new LifeBoat();

        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(lb.solution(people, limit));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Integer[] sortedPeople = new Integer[people.length];
        for (int i = 0; i < people.length; i++)
            sortedPeople[i] = people[i];
        Arrays.sort(sortedPeople, Collections.reverseOrder());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int person : sortedPeople) {

            if (pq.isEmpty()) {
                if ((limit - person) >= 40)
                    pq.add(limit - person);
                answer++;
            } else {

                if (pq.peek() >= person) {
                    pq.poll();
                } else {
                    if ((limit - person) >= 40)
                        pq.add(limit - person);
                    answer++;
                }
            }
        }


        return answer;
    }
}
