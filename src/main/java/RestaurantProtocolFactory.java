import java.net.Socket;

/**
 * Created by sleepbear on 2015. 12. 14..
 */
public class RestaurantProtocolFactory implements ProtocolFactory{
    public Runnable createProtocol(Socket clntSock, Logger logger) {
        return new RestaurantProtocol(clntSock, logger);
    }

}
