package BOJ_10974;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10974 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] arr;
    static int[] result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n];
        visit = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        fun(0);
        bw.flush();
    }

    private static void fun(int cnt) throws IOException {
        if (n == cnt) {
            for (int i = 0; i < result.length; i++) {
                bw.write(Integer.toString(result[i]));
                bw.write(" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[cnt] = i + 1;
                fun(cnt + 1);
                visit[i] = false;
            }
        }

    }
}