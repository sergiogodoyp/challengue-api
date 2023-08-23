package bdd.com.api;

public class FactoryRequest {

    public static final String GET= "get";
    public static final String POST= "post";
    public static final String PUT= "put";

    public static IRequest make(String typeRequest) {
        IRequest request;

        switch (typeRequest.toLowerCase()) {
            case GET:
                request = new RequestGET();
                break;
            case POST:
                request = new RequestPOST();
                break;
            case PUT:
                request = new RequestPUT();
                break;
            default:
                request = new RequestGET();
                break;
        }
        return request;

    }
}
