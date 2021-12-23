import java.io.File;

// Author: Kyle White
// Course: CS401 Algorithms
// Date: 5/3/2021

/*
The DrainChecker class contains the main method of the project, as well as
the drain method which prints out to the console if the input soil array text
file allows water to drain, or if it does not.
 */

public class DrainChecker {
    public static void main(String[] args) {
        File file = new File("input1.txt");
        SoilSample sample = new SoilSample(file);
        int n = sample.getN();
        drain(n, sample);
    }

    /*
    The drain method accepts an integer n as the soil sample matrix column width/height
    as well as a SoilSample object. It iterates through the integer array stored in the
    SoilSample object and uses the SoilSample object's WQUPC object in order to establish
    the connectivity of the SoilSample matrix.
     */
    public static void drain(int n, SoilSample sample) {
        boolean drain = false;
        // Loop through array accessing each row in the SoilSample matrix.
        // i = row count
        for (int i = 0; i < n; i++) {
            // Loop through each row accessing each ID
            // j = column count
            for (int j = 0; j < n; j++) {
                // pos is the current position within the one dimensional array
                // that maps to the position in the two dimensional matrix that was input
                // in the SoilSample file.
                int pos = (i * n) + j;
                // For any column other than the rightmost, calculate the position just to the right of pos
                if ((pos + 1) % n != 0) {
                    int right = pos + 1;
                    // If the current position in the SoilSample matrix.
                    // is 1, and the right position is also 1, then union the two.
                    if (sample.array[pos] == 1 && sample.array[pos] == sample.array[right]) {
                        sample.u.union(right, pos);
                    }
                }

                // For any row other than the last, calculate down position
                if (pos <= (Math.pow(n, 2) - n - 1)) {
                    int down = pos + n;
                    // If the current position in the SoilSample array
                    // is 1, and the down position is also 1, then union the two.
                    if (sample.array[pos] == 1 && sample.array[pos] == sample.array[down]) {
                        sample.u.union(pos, down);
                    }
                }
                // Debug print statement
                // System.out.print(sample.u.id[pos] + " | ");
            }
        }
        // Iterate through the last row in the matrix and check if the root matches with any
        // of the values in the first row of the array. If true, then it will allow water to drain.
        for (int k = (int) (Math.pow(n, 2) -1); k > (int) (Math.pow(n, 2) -1) - n; k--) {
            if(sample.u.find(k) < n) {
                drain = true;
            }
        }
        // If drain is true, print statement to console.
        if (drain) {
            System.out.println("Allows water to drain.");
        } else {
            System.out.println("Does not allow water to drain.");
        }
    }
}

