public class Cube extends Prisim
{
    public Cube(double scale)
    {
        super(scale);
        points = new Point[8];
        edges = new Line[12];
    }
    public void create3dPoints(int xAdd)
    {
        System.out.println("Scale : " + scale);
        points[0] = new Point(scale,scale,scale + xAdd); 
        points[1] = new Point(scale,scale,scale * -1 + xAdd); 
        points[2] = new Point(scale * -1,scale,scale + xAdd); 
        points[3] = new Point(scale * -1,scale,scale * -1 + xAdd); 
        points[4] = new Point(scale * -1,scale * -1,scale + xAdd); 
        points[5] = new Point(scale * -1,scale * -1,scale * -1  + xAdd); 
        points[6] = new Point(scale,scale * -1,scale * -1 + xAdd); 
        points[7] = new Point(scale,scale * -1,scale + xAdd); 
    }
    public void createLines()
    {
        edges[0] = new Line(points[4], points[1]);//
        edges[1] = new Line(points[0], points[2]);
        edges[2] = new Line(points[0], points[7]);
        edges[3] = new Line(points[1], points[3]);
        edges[4] = new Line(points[1], points[6]);
        edges[5] = new Line(points[7], points[3]);//
        edges[6] = new Line(points[2], points[4]);
        edges[7] = new Line(points[3], points[5]);
        edges[8] = new Line(points[0], points[5]);//
        edges[9] = new Line(points[4], points[7]);
        edges[10] = new Line(points[5], points[6]);
        edges[11] = new Line(points[6], points[2]);//
    }

}