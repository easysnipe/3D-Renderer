public class Tester
{
    public static void main(String [] args)
    {
        //Cube test = new Cube(5);
        // Point a = new Point(3,6,2);
        Point c = new Point(1,1,0);
        Point o = new Point(0,0,0);
        // Point e = new Point(0,0,1);
        // ThreeTwo.CalcPerspective(a , c, o);
        // ThreeTwo.To2DPoint(a, e);
        // System.out.println("3D X value: " + a.getX3());
        // System.out.println("3D Y value: " + a.getY3());
        // System.out.println("3D Z value: " + a.getZ3());
        // System.out.println("2D X value: " + a.getX2());
        // System.out.println("2D Y value: " + a.getY2());
        double focalLength = 1;
        Point[] points = new Point[8];
        points[0] = new Point(0,0,0); //
        points[1] = new Point(0,0,2); 
        points[2] = new Point(2,0,2); //
        points[3] = new Point(2,0,2); 
        points[4] = new Point(2,2,0); //
        points[5] = new Point(2,2,2); 
        points[6] = new Point(0,2,2); 
        points[7] = new Point(0,2,0);
        for (Point point : points)
        {
            point.setX3(point.getX2() * 50);
            point.setY3(point.getY3() * 50);
            point.setZ3(point.getZ3() * 50);
            ThreeTwo.CalcPerspective(point, c, o);
            ThreeTwo.To2DPointSimple(point, focalLength);
            System.out.println("(" + point.getX2() + ", "  + point.getY2() + ")" );
        }
    }
}