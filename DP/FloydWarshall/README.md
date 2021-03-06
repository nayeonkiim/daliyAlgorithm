## 플로이드 워셜 알고리즘
### 알고리즘 개요
- 모든 노드에서 다른 모든 노드까지의 최단 경로를 모두 계산한다.
- 다익스트라 알고리즘과 마찬가지로 **단계별로 거쳐 가는 노드**를 기준으로 알고리즘을 수행한다.
- 2차원 테이블에 최단 거리 정보를 저장한다.
- 각 단계마다 특정한 노드 k를 거쳐 가는 경우를 확인한다.
    - a에서 b로 가는 최단 거리보다 a에서 k를 거쳐 b로 가는 거리가 더 짧은지 검사한다.
    
- 점화식<br/>
  Dab = min(Dab, Dak + Dkb);
  
### 동작 과정
- 주어진 그래프 - 4개의 노드, 7개의 간선
  - (a노드 -> b노드, weight) : a노드에서 b노드로 가는데 비용이 weight 이다.
  - (1 -> 2, 3)
  - (1 -> 4, 6)
  - (2 -> 1, 3)
  - (2 -> 3, 7)
  - (3 -> 1, 5)
  - (3 -> 4, 4)
  - (4 -> 3, 2)
<br/><br/>
  
- 1번 노드를 거쳐 가는 경우를 고려하여 테이블을 갱신한다. -> Da1 + D1b
  - D23 = min(D23, D21+D13) -> table[2][3] = D23 = 7
  - D24 = min(D24, D21+D14) -> table[2][4] = D21+D14 = 9 
  - D32 = min(D32, D31+D12) -> table[3][2] = D31+D12 = 9
  - D34 = min(D34, D31+D14) -> table[3][4] = D34 = 4
  - D42 = min(D42, D41+D12) -> table[4][2] = 무한
  - D43 = min(D43, D41+D13) -> table[4][3] = D43 = 2
  
- 위의 방식으로 Da2 + D2b, Da3 + D3b, Da4 + D4b 로 4번 노드까지 최솟값을 테이블에 갱신해준다.
- [전체 코드](https://github.com/ndb796/python-for-coding-test/blob/master/9/3.java)

### 알고리즘 성능 분석
- 노드의 개수가 N개 일때 알고리즘상으로 N번의 단계를 수행한다.
  - 각 단계마다 O(N^2)의 연산을 통해 현재 노드를 거쳐 가는 모든 경로를 고려한다.
- 따라서, 총 시간 복잡도는 O(N^3)이다.
```java
 // 점화식에 따라 플로이드 워셜 알고리즘을 수행
 for (int k = 1; k <= n; k++) {
     for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
            graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        }
    }
 }
 ```


### 플로이드 워셜 알고리즘 이용 문제
- [순위](https://programmers.co.kr/learn/courses/30/lessons/49191?language=java)
  - [코드](https://github.com/nayeonkiim/daliyAlgorithm/blob/main/DP/FloydWarshall/pg_49191.java)
<br/><br/>

- 참고
  - [이것이 코딩테스트다 - 유튜브 강의](https://www.youtube.com/watch?v=hw-SvAR3Zqg&list=PLVsNizTWUw7H9_of5YCB0FmsSc-K44y81&index=31)
  
