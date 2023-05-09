public class Tester
{
    public static void main(String [] args)
    {
        //Cube test = new Cube(5);
        Point a = new Point(3,6,2);
        Point c = new Point(1,1,1);
        Point o = new Point(1,1,1);
        Point e = new Point(1,1,1);
        ThreeTwo.CalcPerspective(a , c, o);
        ThreeTwo.To2DPoint(a, e);
        System.out.println("3D X value: " + a.getX3());
        System.out.println("3D Y value: " + a.getY3());
        System.out.println("3D Z value: " + a.getZ3());
        System.out.println("2D X value: " + a.getX2());
        System.out.println("2D Y value: " + a.getY2());
    }
}