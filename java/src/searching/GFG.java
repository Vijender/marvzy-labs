import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

    boolean[] visited = new boolean[adj.size()];
    int src = 0;
    ArrayList<Integer> ans = new ArrayList<>();


    Queue<Integer>  q = new LinkedList<>();
    q.add(src);
    visited[src] = true;

    while (!q.isEmpty()) {
        int p = q.poll();
        ans.add(p);
        System.out.println("ans " + ans);
        for (int i : adj.get(p)) {
            if (!visited[i]) {
                visited[i] = true;
                q.add(i);
            }
            System.out.println( "q space" + q);
        }

    }
    return ans;
}

void main() {
    int V = 5;

    int[][] edges = {{1, 2}, {1, 0}, {2, 0}, {2, 3}, {2, 4}};
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    for (int i = 0; i < V; i++)
        arr.add(new ArrayList<>());

    for (int[] e : edges) {
        arr.get(e[0]).add(e[1]);
        arr.get(e[1]).add(e[0]);
    }
    System.out.println(bfs(arr));
}
