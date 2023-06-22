package Java_Lv3;

public class IntegerTriangle {
    public static void main(String[] args) {
        int[][] arr = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        System.out.println(solution(arr));

    }
    public static int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 0; i < triangle.length-1 ; i++) {

            triangle[i + 1][0] += triangle[i][0];
            triangle[i + 1][  triangle[i+1].length-1 ] += triangle[i][ triangle[i].length-1 ];
            for (int j = 1; j < triangle[i+1].length - 1; j++) {
                triangle[i + 1][j] += Math.max(triangle[i][j-1], triangle[i][j]);
            }
        }
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, triangle[triangle.length - 1][i]);
        }
        return answer;
    }
}
