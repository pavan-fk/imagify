package imagify.api;

import imagify.api.resources.APIResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * User: pavank
 * Date: 31/03/16
 * Time: 12:26 AM
 **/
public class APIApplication extends Application<APIConfiguration> {
    public static void main(String[] args) throws Exception {
        System.out.println("HERE!!!");
        new APIApplication().run(args);
    }

    @Override
    public void run(APIConfiguration configuration, Environment environment) throws Exception {
        APIResource apiResource = new APIResource();
        System.out.println("registering aPI");
        environment.jersey().register(apiResource);

    }
}
