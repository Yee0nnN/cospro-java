// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(int[][] garden) {
        int n = garden.length;
        int m = garden[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        // 초기 꽃(1) 위치를 모두 큐에 넣기 (멀티 소스 BFS)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (garden[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        return bfs(garden, q, dist);
    }

    int bfs(int[][] garden, Queue<int[]> q, int[][] dist) {
        int answer = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= garden.length || ny >= garden[0].length)
                    continue;

                if (garden[nx][ny] == 1) // 이미 꽃이 핀 곳이면 스킵
                    continue;

                // 꽃 퍼뜨리기 + 날짜 기록
                garden[nx][ny] = 1;
                dist[nx][ny] = dist[cx][cy] + 1;
                answer = Math.max(answer, dist[nx][ny]);

                q.add(new int[]{nx, ny});
            }
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(garden1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(garden2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
