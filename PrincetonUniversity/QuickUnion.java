public class QuickUnion {
    private int[] id;
    private int N;

    public QuickUnion(int N) {
        id = new int[N];
        this.N = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // can escale to O(N)
    private int root(int i) {
        while (i != id[i]) {
            // id[i] = id[id[i]]
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        id[root(p)] = root(q);
    }

}