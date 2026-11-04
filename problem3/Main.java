import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Fast input (Scanner is too slow for big inputs)
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int n = nextInt(in);
        int s = nextInt(in), r = nextInt(in), d = nextInt(in);

        // Build the tree as an adjacency list (arrays = fast)
        int[] head = new int[n + 1], next = new int[2 * (n - 1)], to = new int[2 * (n - 1)];
        Arrays.fill(head, -1);
        int e = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = nextInt(in), v = nextInt(in);
            to[e] = v; next[e] = head[u]; head[u] = e++;
            to[e] = u; next[e] = head[v]; head[v] = e++;
        }

        // Step 1: BFS from the Death Star d.
        // dist[v]   = number of tunnels from v to d
        // parent[v] = the next planet on the way from v towards d
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, -1);
        int[] queue = new int[n];
        int qh = 0, qt = 0;
        queue[qt++] = d;
        dist[d] = 0;
        parent[d] = 0;
        while (qh < qt) {
            int u = queue[qh++];
            for (int k = head[u]; k != -1; k = next[k]) {
                int v = to[k];
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                    queue[qt++] = v;
                }
            }
        }

        // Step 2: mark every planet on the path from the base r to d.
        boolean[] onPath = new boolean[n + 1];
        for (int v = r; v != 0; v = parent[v]) {
            onPath[v] = true;
        }

        // Step 3: walk from s towards d. The first planet on the r-d path is x,
        // the place where the Falcon "joins" the path.
        int x = s;
        while (!onPath[x]) {
            x = parent[x];
        }

        // Step 4: gambler's ruin on a line: P = dist(x, d) / dist(r, d)
        double answer = (double) dist[x] / dist[r];
        System.out.printf("%.15f%n", answer);
    }

    // Reads the next integer from the input
    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0, b = in.read();
        while (b < '0' || b > '9') {
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }
}
