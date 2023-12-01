package Java_Lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SurveillanceCamera {
    public static void main(String[] args) {
        SurveillanceCamera cctv = new SurveillanceCamera();
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(cctv.solution(routes));
    }

    public int solution(int[][] routes) {
        ArrayList<Integer> camera = new ArrayList<>();
        Arrays.sort(routes, Comparator.comparingInt((int[] o) -> o[0]).reversed());

        for (int[] route : routes) {
            boolean skip = false;

            for (Integer cam : camera) {
                if (cam <= route[1]) {
                    skip = true;
                    break;
                }
            }

            if (!skip){
                camera.add(route[0]);
            }
        }
        return camera.size();
    }
}
