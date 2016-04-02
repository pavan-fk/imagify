package imagify.api.resources;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * User: pavank
 * Date: 31/03/16
 * Time: 12:27 AM
 **/
@Path("/imagify")
public class APIResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("image/png")
    public Response dummy(String tweet) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedImage bufferedImage = new BufferedImage(320, 200,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 200, 50);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(Font.SERIF, Font.BOLD, 18));
        graphics.drawString(tweet, 10, 25);
        try {
            ImageIO.write(bufferedImage, "jpg", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.ok(baos.toByteArray()).build();
    }
}
