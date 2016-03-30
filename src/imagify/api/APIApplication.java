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
    @Override
    public void run(APIConfiguration configuration, Environment environment) throws Exception {
        APIResource apiResource = new APIResource();
        environment.jersey().register(apiResource);

    }
}
