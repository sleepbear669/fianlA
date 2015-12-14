import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by sleepbear on 2015. 10. 25..
 */
public class RestaurantInfoEncoder {

    public byte[] encode(List<RestaurantInfo> restaurantInfo) throws IOException {
        Gson gson = new Gson();
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(buf);
        String s = gson.toJson(restaurantInfo);
        byte[] bytes = s.getBytes();
        out.write(s.length());
        out.write(bytes);
        return buf.toByteArray();
    }
}
