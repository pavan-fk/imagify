package imagify.api.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * User: pavank
 * Date: 31/03/16
 * Time: 12:27 AM
 **/
@Path("/imagify")
public class APIResource {

    @POST
    @Produces("image/png")
    public Response dummy(String text) {

    }
}
