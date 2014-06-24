import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet {

    public static void main(String... str) {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println(localhost.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
