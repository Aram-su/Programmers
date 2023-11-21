package Java_Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class JoyStick {
    public static void main(String[] args) {

        String[] names = {"JEROEN", "JAN", "JAZ"};
        for (String name : names) {
            System.out.println(solution(name));
        }
    }

    public static int solution(String name) {
        int leftRight = calLeftRight(name);
        int upDown = calUpDownCount(name);

        return leftRight + upDown;
    }

    private static int calLeftRight(String name) {
        int len = name.length();
        int leftRight = len - 1;

        Queue<int[]> idxAndCnt = new LinkedList<>();
        Queue<boolean[]> sameIdx = new LinkedList<>();
        boolean[] booleanTmp = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (name.charAt(i) == 'A') {
                booleanTmp[i] = true;
            }
        }
        sameIdx.add(booleanTmp);
        idxAndCnt.add(new int[]{0, 0});


        while (!idxAndCnt.isEmpty()) {
            int[] tmp = idxAndCnt.poll();
            int idx = tmp[0];
            int cnt = tmp[1];
            boolean[] same = sameIdx.poll();

            if ( cnt >= leftRight ){
                continue;
            }

            if (allSame(same)) {
                leftRight = Math.min(cnt, leftRight);
                continue;
            }

            for (int i = 0; i < (len/2)+1; i++) {
                int left = (idx - i + len) % len;
                int right = (idx + i) % len;

                if (!same[left]) {
                    idxAndCnt.add(new int[]{left, cnt + i});
                    sameIdx.add(newSameIdx(same, left));
                }
                if (!same[right]) {
                    idxAndCnt.add(new int[]{right, cnt + i});
                    sameIdx.add(newSameIdx(same, right));
                }
            }
        }

        return leftRight;
    }

    private static int calUpDownCount(String name) {
        int upDown = 0;
        for (int i = 0; i < name.length(); i++) {
            int upCount = name.charAt(i) - 'A';
            upDown += Math.min(upCount, 26 - upCount);
        }
        return upDown;
    }

    private static boolean allSame(boolean[] sameIdx) {
        for (boolean same : sameIdx) {
            if (!same) {
                return false;
            }
        }
        return true;
    }

    private static boolean[] newSameIdx(boolean[] sameIdx, int idx) {
        boolean[] newSameIdx = new boolean[sameIdx.length];
        for (int i = 0; i < sameIdx.length; i++) {
            newSameIdx[i] = sameIdx[i];
        }
        newSameIdx[idx] = true;
        return newSameIdx;
    }
}
