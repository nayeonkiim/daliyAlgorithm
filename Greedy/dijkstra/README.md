## 다익스트라 최단경로 알고리즘
- 특정한 노드에서 출발하여 다른 모든 노드로 가는 최단경로를 계산한다.
- 다익스트라 최단 경로 알고리즘은 그리디 알고리즘으로 분류된다.
    - 매 상황에서 가장 비용이 적은 노드를 선택

- 동작 과정
1. 출발 노드를 설정한다.
2. 최단 거리 테이블을 초기화 한다. 무한으로
3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.
    - **PriorityQueue 사용.**
4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
5. 위 과정에서 3번과 4번을 반복한다.

- Node 클래스에 간선으로 연결된 노드 idx, 거리를 distance 
```java
class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}
```

- 현재 정점의 갯수가 6, 간선의 정보 갯수가 9, 시작점이 1
- 연결된 간선의 정보
    - 1->2 - 가중치 : 2
    - 1->4 - 가중치 : 1
    - 1->3 - 가중치 : 5
    - 2->3 - 가중치 : 3
    - 2->4 - 가중치 : 2
    - 3->2 - 가중치 : 3
    - 4->5 - 가중치 : 1
    - 5->3 - 가중치 : 1
    - 5->6 - 가중치 : 1 <br/><br/>
    <img src="/img/dijkstra.png" width="700px" height="300px" title="table1" alt="insert쿼리"></img><br/>

- 최단 거리 테이블의 값이 모두 무한으로 초기화 되어 있고 시작점만 0으로 설정한다.
- 1->2 의 가중치 2가 무한보다 작으므로 최단 거리 테이블에서 2의 값을 무한에서 2로 변경한다.
- 위와 같은 상황 처럼 값이 더 작아 테이블이 변경되는 경우 그때의 idx 값을 기준으로 탐색을 진행하므로 PrimaryQueue에 offer 한다. 
- primary queue가 empty 가 아니면 계속 수행 탐색을 통해 최솟값을 변경한다.
- 최종 테이블의 값은 시작점으로 부터의 최솟값이다. 
    - 시작점이 1이므로 1에서 각 노드까지의 최솟값이 최단 거리 테이블에 저장된다.

- 다익스트라 코드
```java
public static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    pq.offer(new Node(start, 0));
    d[start] = 0;
    while(!pq.isEmpty()) { // 큐가 비어있지 않다면
        // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        Node node = pq.poll();
        int dist = node.getDistance(); // 현재 노드까지의 비용 
        int now = node.getIndex(); // 현재 노드
        // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if (d[now] < dist) continue;
        // 현재 노드와 연결된 다른 인접한 노드들을 확인
        for (int i = 0; i < graph.get(now).size(); i++) {
            int cost = d[now] + graph.get(now).get(i).getDistance();
            // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if (cost < d[graph.get(now).get(i).getIndex()]) {
                d[graph.get(now).get(i).getIndex()] = cost;
                pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
            }
        }
    }
}
```

- 참고
    - [이것이 코딩테스트다](https://www.youtube.com/watch?v=F-tkqjUiik0&list=PLVsNizTWUw7H9_of5YCB0FmsSc-K44y81&index=30)
