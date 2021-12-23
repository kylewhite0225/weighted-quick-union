
// Author: Kyle White
// Course: CS401 Algorithms
// Date: 5/3/2021

public class WQUPC extends WeightedQuickUnion {

    /*
    Default constructor.
     */
    public WQUPC(int n) {
        super(n);
    }

    /*
    * The find method is overridden in this method in order to implement
    * path compression.
    * @param p  The ID for which the root is to be found.
    * @return root  The root of p.
    */
    @Override
    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (p != root) {
            int newID = id[p];
            id[p] = root;
            p = newID;
        }
        return root;
    }
}
