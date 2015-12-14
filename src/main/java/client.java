import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by sleepbear on 2015. 10. 25..
 */
public class client {

    public static void main(String args[]) throws Exception {

        if (args.length != 5)  // Test for correct # of args
            throw new IllegalArgumentException("Parameter(s): <Destination> <Port> <X> <Y> <radius>");

        InetAddress destAddr = InetAddress.getByName(args[0]);  // Destination address
        int destPort = Integer.parseInt(args[1]);               // Destination port
        int xPoint = Integer.parseInt(args[2]);
        int yPoint = Integer.parseInt(args[3]);
        int radius = Integer.parseInt(args[4]);

        Socket sock = new Socket(destAddr, destPort);
        UserPoint userPoint = new UserPoint(xPoint, yPoint, radius);
        UserPointEncoder userPointEncoder = new UserPointEncoder();
        byte[] encode = userPointEncoder.encode(userPoint);

        sock.getOutputStream().write(encode);
        StringBuilder stringBuilder  = new StringBuilder();
        RestaurantInfo[] decode = new RestaurantInfoDecoder().decode(sock.getInputStream());
        for (RestaurantInfo restaurantInfo : decode) {
            System.out.println("==========================================");
            System.out.println("식당 이름 : " + restaurantInfo.getName());
            System.out.println("식당 정보 : " + restaurantInfo.getDesc());
            System.out.println("식당 위치 : " + restaurantInfo.getX() + ","+ restaurantInfo.getY());
            System.out.println("식당 평점 : " + restaurantInfo.getStar());
            System.out.println("==========================================");
        }
        System.out.println(decode[0]);

        sock.close();
    }
}
