public class QuickUnionImproved {
    private int[] id;
    private int[] sz;
    private int N;

    public QuickUnionImproveds(int N) {
        id = new int[N];
        sz = new int[N];
        this.N = N;
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // can escale to O(N)
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] = sz[j] + sz[i];
        } else {
            id[j] = i;
            sz[i] = sz[i] + sz[j];
        }
    }

}