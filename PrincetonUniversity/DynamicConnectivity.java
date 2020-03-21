import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DynamicConnectivity {
    // used for
    // Pixels in a digital photo
    // Computers in a network
    // Friends in a social network
    // Transistors in a computer chip
    // Elements in a mathematical set
    // Variable names in fortran program
    // Metallic sites in a composite system

    // "is connected to" is an equivalence relation
    // Reflexive: p is connected to p
    // p -> p
    // Symmetric: if p is connected to q. then q is connected to p.
    // p -> q then q -> p
    // Transitive: if p is connected to q and q is connected to r then p is
    // connected to r.
    // p -> q and q -> r then p -> r

    // Goal Design efficient data structure for union find
    // number of objects N can be huge
    // number of operations M can be huge
    // union find api
    // class that contains two methods
    // void union(int p, int q)
    // boolean connected(int p, int q)

    public static class UF {
        private int[] id;
        private int N;

        // O(N)
        public UF(int N) {
            this.N = N;
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        // O(N)
        // for N commands O(N*N)
        public void union(int p, int q) {
            int pid = id[p];
            int qid = id[q];
            for (int i = 0; i < N; i++) {
                if (id[i] == pid) {
                    id[i] = qid;
                }
            }
        }

        // O(1)
        public boolean connected(int p, int q) {
            return id[p] == id[q];
        }

        // O(N)
        public void print() {
            System.out.println(Arrays.toString(id));
        }
    }

    // client
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // int N = Integer.parseInt(br.readLine());
        // UF uf = new UF(N);
        // while (true) {
        // try {
        // int p = Integer.parseInt(br.readLine());
        // int q = Integer.parseInt(br.readLine());
        // if (!uf.connected(p, q)) {
        // uf.union(p, q);
        // bw.write(p + " " + q + "\n");
        // }
        // } catch (Exception ex) {
        // break;
        // }
        // }
        // bw.flush();
        // bw.close();
        // br.close();
        UF uf = new UF(10);
        if (!uf.connected(7, 8)) {
            uf.union(7, 8);
        }
        uf.print();
    }
}