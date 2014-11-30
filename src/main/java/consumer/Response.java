package consumer;

public class Response {

    public String REP_TYPE = "USER:PROFILE:GET:ALL";

    @Override
    public String toString() {
        return "Response{" +
                "REP_TYPE='" + REP_TYPE + '\'' +
                '}';
    }
}
