public class MatrixMult 
{
    public static int[][] mult(int[][] a, int[][] b)
    {
        int[][] matrix = new int[a.length][b[0].length];
        int sum = 0;
        for (int i = 0; i < b[0].length; i++)//Move to next collum in b array
        {
            for (int o = 0; o < a.length; o++)//Move to next row in a array
            {
                for (int p = 0; p < a[0].length; p++)//Multiply a against b 
                {
                    sum = (a[o][p] * b[p][i]) + sum;
                }
                matrix[o][i] = sum;
                sum = 0;
            }
        }
        return(matrix);
    }    
}
