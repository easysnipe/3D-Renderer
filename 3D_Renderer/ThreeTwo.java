public class ThreeTwo
{
    //Takes the point camera position and camera angle an changes points 3D X,Y and Z values
    public static void CalcPerspective(Point point, Point camera, Point cameraAngle) // Calculates points Rotation and moves point based on camera location
    {
        double[][] mat1 = {{1,0,0},
                        {0,Math.cos(cameraAngle.getX3()), Math.sin(cameraAngle.getX3())},
                        {0,Math.sin(cameraAngle.getX3()) * -1, Math.cos(cameraAngle.getX3())}};
        double[][] mat2 = {{Math.cos(cameraAngle.getY3()), 0, Math.sin(cameraAngle.getY3()) * -1},
                        {0,1,0},
                        {Math.sin(cameraAngle.getY3()), 0, Math.cos(cameraAngle.getY3())}};
        double[][] mat3 = {{Math.cos(cameraAngle.getZ3()), Math.sin(cameraAngle.getZ3()), 0},
                        {Math.sin(cameraAngle.getZ3()) * -1, Math.cos(cameraAngle.getZ3()), 0},
                        {0,0,1}};
        double[][] PC = {{(int)(point.getX3() - camera.getX3())}, {(int)(point.getY3() - camera.getY3())}, {(int)(point.getZ3() - camera.getZ3())}};
        double[][] xyz = MatrixMult.mult(MatrixMult.mult(MatrixMult.mult(mat1,mat2), mat3), PC);

        point.setX3((int)xyz[0][0]);
        point.setY3((int)xyz[1][0]);
        point.setZ3((int)xyz[2][0]); 
        
    }
    //Takes point resolution, the point and the focal length and changes the points 2D X and Y values
    public static void To2DPoint(Point point, double focalLength, int[] res) //Projects 3D point onto Screen
    {
        point.setX2((int)(res[0] / 2 + (focalLength * point.getX3())/(focalLength + point.getZ3()))); //1280x800
        point.setY2((int)(res[1] / 2 + (focalLength * point.getY3())/(focalLength + point.getZ3())));
    }
}