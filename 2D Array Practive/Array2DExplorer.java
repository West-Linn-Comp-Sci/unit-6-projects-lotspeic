import java.util.Arrays;

public class Array2DExplorer {

    public boolean evenRow(int[][] mat, int row) {
        for(int i : mat[row]) {
            if(i % 2 != 0) return false;
        }
        return true;
    }

    public boolean oddColSum(int[][] nums, int col) {
        int sum = Arrays.(nums).parallel().mapToInt(row -> row[col]).sum();
        return sum % 2 != 0;
    }

    public int[] minRowPractice(int[][] nums) {
        int[] smallestArray = nums[0];
        int smallestVal = nums[0][0];
        for(int[] array : nums) {
            for(int i : array) {
                if(i >= smallestVal) continue;
                smallestArray = array;
                smallestVal = i;
            }
        }
        return smallestArray;
    }

    public int minRowAssignment(int[][] nums, int row) {
        int min = nums[row][0];
        for(int i : nums[row]) {
            if(i < min) min = i;
        }
        return min;
    }

    public int[] colMaxs(int[][] matrix) {
        int[] out = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for(int[] row : matrix) {
                if(row[i] > max) max = row[i];
            }
            out[i] = max;
        }
        return out;
    }

    public int[] allRowSums(int[][] data) {
        return Arrays.(data).mapToInt(x -> Arrays.(x).sum()).toArray();
    }

    public double[] averageCol(int[][] nums) {
        double[] out = new double[nums[0].length];
        for(int i = 0; i < nums[0].length; i++) {
            int sum = 0;
            for(int[] row : nums) {
                sum += row[i];
            }
            out[i] = (double) sum / nums.length;
        }
        return out;
    }

    public int smallEven(int[][] matrix) {
        return Arrays.(matrix).flatMapToInt(x -> Arrays.(x)).filter(x -> x % 2 == 0).min().orElse(-1);
    }

    public int biggestRow(int[][] nums) {
        int[] rowSums = allRowSums(nums);
        int largestRowIndex = 0;
        for(int i = 1; i < rowSums.length; i++) {
            if(rowSums[i] > rowSums[largestRowIndex]) largestRowIndex = i;
        }
        return largestRowIndex;
    }

}
