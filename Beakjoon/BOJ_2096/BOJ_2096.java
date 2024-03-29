package BOJ_2096;

import java.io.*;
import java.util.*;

public class BOJ_2096 {

    static final int MAX = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dpMax = new int[n][3];
        int[][] dpMin = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dpMax[0][i] = arr[0][i];
            dpMin[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            Arrays.fill(dpMax[i], MAX);
        }
        for (int i = 1; i < n; i++) {
            Arrays.fill(dpMin[i], -1);
        }

        for (int i = 1; i < n; i++) {
            dpMax[i][0] = Math.max(dpMax[i - 1][0] + arr[i][0], dpMax[i - 1][1] + arr[i][0]);
            dpMax[i][1] = Math.max(Math.max(dpMax[i - 1][0] + arr[i][1], dpMax[i - 1][1] + arr[i][1]),
                    Math.max(dpMax[i - 1][1] + arr[i][1], dpMax[i - 1][2] + arr[i][1]));
            dpMax[i][2] = Math.max(dpMax[i - 1][1] + arr[i][2], dpMax[i - 1][2] + arr[i][2]);
        }

        for (int i = 1; i < n; i++) {
            dpMin[i][0] = Math.min(dpMin[i - 1][0] + arr[i][0], dpMin[i - 1][1] + arr[i][0]);
            dpMin[i][1] = Math.min(Math.min(dpMin[i - 1][0] + arr[i][1], dpMin[i - 1][1] + arr[i][1]),
                    Math.min(dpMin[i - 1][1] + arr[i][1], dpMin[i - 1][2] + arr[i][1]));
            dpMin[i][2] = Math.min(dpMin[i - 1][1] + arr[i][2], dpMin[i - 1][2] + arr[i][2]);
        }
        int max = Math.max(Math.max(dpMax[n - 1][0], dpMax[n - 1][1]), Math.max(dpMax[n - 1][1], dpMax[n - 1][2]));
        int min = Math.min(Math.min(dpMin[n - 1][0], dpMin[n - 1][1]), Math.min(dpMin[n - 1][1], dpMin[n - 1][2]));
        System.out.println(max + " " + min);
    }
}