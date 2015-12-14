import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sleepbear on 2015. 12. 14..
 */
public class RestaurantProtocol implements Runnable {
    static public final int BUFSIZE = 32;   // Size (in bytes) of I/O buffer

    private Socket clntSock;  // Connection socket
    private Logger logger;    // Logging facility

    public RestaurantProtocol(Socket clntSock, Logger logger) {
        this.clntSock = clntSock;
        this.logger = logger;
    }

    public void run() {
        Db db = new Db();
        ArrayList entry = new ArrayList();
        entry.add("Client address and port = " +
                clntSock.getInetAddress().getHostAddress() + ":" +
                clntSock.getPort());
        entry.add("Thread = " + Thread.currentThread().getName());

        try {
            // Get the input and output I/O streams from socket
            InputStream in = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();
            UserPointDecoder userPointDecoder = new UserPointDecoder();
            UserPoint decode = userPointDecoder.decode(in);
            System.out.println(decode.getX());
            List<RestaurantInfo> restaurantInfo = db.getRestaurantInfo(decode);
            byte[] encode = new RestaurantInfoEncoder().encode(restaurantInfo);
            out.write(encode);

        } catch (IOException e) {
            entry.add("Exception = " +  e.getMessage());
        }

        try {  // Close socket
            clntSock.close();
        } catch (IOException e) {
            entry.add("Exception = " +  e.getMessage());
        }

        logger.writeEntry(entry);
    }

}
