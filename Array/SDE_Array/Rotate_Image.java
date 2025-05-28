package Array.SDE_Array;


/* LAYER-BY-LAYER SWAPPING      
 *  Basically  i am taken each of the opter sprip and rotated elements by making 4 swaps for each
 *  for example first swapping clockwise 4 corners then then so on
 *  lets say i have a matrix of 4*4 then the outer strip swap will look something like this:
 *  [0][0] -> [0][3] -> [3][3] -> [3][0] -> [0][0]
 *  [0][1] -> [1][3] -> [3][2] -> [2][0] -> [0][1]
 *  [0][2] -> [2][3] -> [3][1] -> [1][0] -> [0][2]
 * 
 *  and similarly doing for the inner strip as well 
 *  TC->O(N)
 *  SC->O(1)
 */
public class Rotate_Image 
{
    public void rotate(int[][] matrix) 
    {
        int size = matrix.length;
        int limit = size/2;

        for(int i=0; i<limit; i++)
        {
            for(int j=i; j<size-i-1; j++)
            {
                int temp = matrix[j][size-i-1];
                matrix[j][size-i-1] = matrix[i][j];

                temp = swap(temp,matrix,size-i-1,size-j-1);
                temp = swap(temp,matrix,size-j-1,i);
                temp = swap(temp,matrix,i,j);
            }
        }

    }
    private int swap(int a, int[][]matrix, int row, int col)
    {
        int temp = matrix[row][col];
        matrix[row][col] = a;
        return temp; 
    }
}

//TC->O(N)
//SC->O(1)
//Transpose + Reverse Rows (alternative):

class Solution
{
    public void rotate(int[][] matrix) 
    {
        int n = matrix.length;
        // Transpose matrix
        for (int i = 0; i < n; i++) 
        {
            for (int j = i; j < n; j++) 
            { 
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int[] row : matrix) 
        {
            int left = 0, right = row.length - 1;
            while (left < right) 
            {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }
}
