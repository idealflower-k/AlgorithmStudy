import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        int id;          // 사람 번호
        int time;        // 루머를 믿게 된 시간
        boolean visited; // 방문 여부
        List<Node> nb;   // 이웃 목록
        
        Node(int id) {
            this.id = id;
            time = -1;   // 초기값 -1 (루머를 믿지 않음)
            visited = false;
            nb = new ArrayList<>();
        }
    }
    
    public static List<Node> nodes = new ArrayList<>();
    public static int N;
    public static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        // 노드 초기화
        for (int i = 0; i <= N; i++) {
            nodes.add(new Node(i));
        }
        
        // 이웃 관계 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (true) {
                int nb = Integer.parseInt(st.nextToken());
                if (nb == 0) break;
                nodes.get(i).nb.add(nodes.get(nb));
            }
        }
        
        // BFS로 루머 전파
        Queue<Node> queue = new LinkedList<>();
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 초기 루머 전파자 설정
        for (int i = 0; i < M; i++) {
            int start = Integer.parseInt(st.nextToken());
            Node node = nodes.get(start);
            node.time = 0;
            queue.add(node);
        }
        
        // 루머 전파 진행
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            for (Node neighbor : current.nb) {
                if (neighbor.time != -1) continue;
                
                // 주변인 중 루머를 믿는 사람 수 계산
                int rumorCount = 0;
                for (Node nb : neighbor.nb) {
                    if (nb.time != -1 && nb.time <= current.time) {
                        rumorCount++;
                    }
                }
                
                // 과반수 조건 확인 및 전파
                if (rumorCount >= (neighbor.nb.size() + 1) / 2 && !neighbor.visited) {
                    neighbor.time = current.time + 1;
                    neighbor.visited = true;
                    queue.add(neighbor);
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(nodes.get(i).time).append(" ");
        }
        System.out.println(sb);
    }
}