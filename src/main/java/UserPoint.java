/**
 * Created by sleepbear on 2015. 10. 19..
 */
public class UserPoint {

    private long x;
    private long y;
    private long radius;

    public UserPoint(long x, long y, long radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public long getRadius() {
        return radius;
    }

    public void setRadius(long radius) {
        this.radius = radius;
    }
}
