public class MatrixMult 
{
    public static double[][] mult(double[][] a, double[][] b)
    {
        double[][] matrix = new double[a.length][b[0].length];
        double sum = 0;
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
