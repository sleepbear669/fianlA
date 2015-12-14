import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/**
 * Created by sleepbear on 2015. 10. 25..
 */
public class UserPointEncoder {
    public byte[] encode(UserPoint item) throws Exception {
        Gson gson = new Gson();
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(buf);
        String s = gson.toJson(item);
        byte[] bytes = s.getBytes();
        out.write(s.length());
        out.write(bytes);
        return buf.toByteArray();
    }
}
