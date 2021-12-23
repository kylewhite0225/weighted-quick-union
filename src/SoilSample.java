import edu.princeton.cs.algs4.In;

import java.io.File;

// Author: Kyle White
// Course: CS401 Algorithms
// Date: 5/3/2021

/*
The SoilSample class provides the public members array, which store
the contents of the input text file in a 1 dimensional array, n, which
is the row/column height/width, and u, which is a QuickUnion
object for the Weighted Quick Union with Path Compression algorithm that
is being applied to the input soil sample.
 */
public class SoilSample {
    public int[] array;
    public int n;
    public QuickUnion u;

    /*
    Default constructor.
     */
    public SoilSample() {
        n = 0;
        u = null;
        array = null;
    }

    /*
    Constructor accepting a File object for reading in the integer values in the
    soil sample text file and storing them in array.
    @Param file The file to load into array.
     */
    public SoilSample(File file) {
        array = new In(file.getAbsolutePath()).readAllInts();
        // System.out.println(Arrays.toString(test));
        int size = array.length; // Get array length for column and row count.
        n = (int) Math.sqrt(size);
        u = new WQUPC(size);
    }

    /*
    Accessor method for the array member of the SoilSample class.
     */
    public int[] getArray() {
        return array;
    }

    /*
    Accessor method for the n field of the SoilSample class.
     */
    public int getN() {
        return n;
    }
}

