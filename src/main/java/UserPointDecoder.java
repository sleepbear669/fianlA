import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sleepbear on 2015. 10. 25..
 */
public class UserPointDecoder {
    public UserPoint decode(InputStream source) throws IOException {
        Gson gson = new Gson();
        DataInputStream src = new DataInputStream(source);
        int read = src.read();
        byte[] bytes = new byte[read];
        src.readFully(bytes);
        String s = new String(bytes);
        return gson.fromJson(s, UserPoint.class);
    }
}


