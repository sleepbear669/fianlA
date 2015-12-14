/**
 * Created by sleepbear on 2015. 10. 19..
 */
public class RestaurantInfo {
    private String name;
    private long x;
    private long y;
    private int star;
    private String desc;

    public RestaurantInfo(String name, long x, long y, int star, String desc) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.star = star;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
