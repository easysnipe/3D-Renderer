public class Line
{
    private Point a;
    private Point b;
    public Line(Point pointA, Point pointB)
    {
        a = pointA;
        b = pointB;
    }
    public Point getPointA()
    {
        return(a);
    }
    public void setPointA(Point pointA)
    {
        a = pointA;
    }
    public Point getPointB()
    {
        return(b);
    }
    public void setPointB(Point pointB)
    {
        b = pointB;
    }
}