import com.google.common.collect.Lists;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by sleepbear on 2015. 10. 26..
 */
public class Db {
    static List<RestaurantInfo> restaurantInfoList = Lists.newArrayList();
    static {
        RestaurantInfo r1 = new RestaurantInfo("a", 1, 2, 3, "good");
        RestaurantInfo r2 = new RestaurantInfo("b", 5, 5, 3, "bad");
        RestaurantInfo r3 = new RestaurantInfo("c", 10, 10, 3, "good");
        RestaurantInfo r7 = new RestaurantInfo("d", 10, 10, 3, "bad");
        restaurantInfoList.add(r1);
        restaurantInfoList.add(r2);
        restaurantInfoList.add(r3);
        restaurantInfoList.add(r7);
    }

    public List<RestaurantInfo> getRestaurantInfo(UserPoint userPoint) {
        return restaurantInfoList.stream()
                .filter(r -> isNear(r, userPoint))
                .collect(toList());
    }

    private static boolean isNear(RestaurantInfo r, UserPoint userPoint) {
        double result = Math.sqrt(Math.pow(r.getX() - userPoint.getX(), 2) + Math.pow(r.getY() - userPoint.getY(), 2));
        return result < userPoint.getRadius();
    }
}
