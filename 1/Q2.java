import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2 {

    public static int findMax(int n, int[] t, int[] p) {
        int[] dp = new int[n + 1]; // DP 배열, dp[i]는 i일에 얻을 수 있는 최대 수익

        // 역순으로 DP 계산 (마지막 날부터 계산)
        for (int i = n - 1; i >= 0; i--) {
            if (i + t[i] <= n) {
                // 현재 일을 수행할 수 있는 경우
                dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
            } else {
                // 현재 일을 수행할 수 없는 경우, 이전 상태를 그대로 유지
                dp[i] = dp[i + 1];
            }
        }

        return dp[0]; // 첫날부터 최대 수익을 얻을 수 있는 값 반환
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] t = new int[n]; // 작업 기한
        int [] p = new int[n]; // 수익

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int result = findMax(n, t, p);
        System.out.println(result);
    }
}