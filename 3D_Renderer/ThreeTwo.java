public class ThreeTwo
{
    public static void CalcPerspective(Point point, Point camera, Point cameraAngle)
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
        double[][] PC = {{point.getX3() - camera.getX3()}, {point.getY3() - camera.getY3()}, {point.getZ3() - camera.getZ3()}};
        double[][] xyz = MatrixMult.mult(MatrixMult.mult(MatrixMult.mult(mat1,mat2), mat3), PC);
        point.setX3(xyz[0][0]);
        point.setY3(xyz[1][0]);
        point.setZ3(xyz[2][0]); 
        
    }
    public static void To2DPoint(Point point, Point screen)
    {
        point.setX2(((screen.getZ3()/point.getZ3()) * point.getX3()) + screen.getX3());
        point.setY2(((screen.getZ3()/point.getZ3()) * point.getY3()) + screen.getY3());
    }
    public static void To2DPointSimple(Point point, double focalLength)
    {
        point.setX2((focalLength * point.getX3())/(focalLength + point.getZ3()) + 1920/2);
        point.setY2((focalLength * point.getY3())/(focalLength + point.getZ3()) + 1080/2);
    }
}