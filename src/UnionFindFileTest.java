import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.In;

// Author: Kyle White
// Course: CS401 Algorithms
// Date: 5/3/2021

/*
Provided UnionFindFileTest Source File
 */

class UnionFindFileTest {

	@Test
	void testQuickFindCount() {
		In in = new In("input1.txt");
		
		int n = in.readInt();
		QuickUnion uf = new QuickUnion(n);
		
		while(in.hasNextLine()) {
			int p = in.readInt();
			int q = in.readInt();
			uf.union(p, q);
		}
		
		int actual = uf.getConnectedComponentCount();
		int expected = 2;
		
		assertEquals(expected, actual);
	}
}
