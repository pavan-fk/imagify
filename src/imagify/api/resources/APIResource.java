package imagify.api.resources;

import javax.imageio.ImageIO;
import javax.ws.rs.*;
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
    @Produces("image/png")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response dummy(@FormParam("tweet") String tweet) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedImage bufferedImage = new BufferedImage(320, 480,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = bufferedImage.createGraphics();

        g2.setColor(Color.WHITE);
        g2.setFont(new Font(Font.SERIF, Font.BOLD, 18));
        drawer(g2, tweet, 1, 15, 320);

        try {
            ImageIO.write(bufferedImage, "jpg", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.ok(baos.toByteArray()).build();
    }

    public void drawer(Graphics2D g, String s, int startingX, int startingY, int totalWidth) {
        // FontMetrics gives us information about the width,
        // height, etc. of the current Graphics object's Font.
        FontMetrics fm = g.getFontMetrics();

        int lineHeight = fm.getHeight();

        int curX = startingX;
        int curY = startingY;

        String[] words = s.split(" ");

        for (String word : words) {
            // Find out thw width of the word.
            int wordWidth = fm.stringWidth(word + " ");

            // If text exceeds the width, then move to next line.
            if (curX + wordWidth >= startingX + totalWidth) {
                curY += lineHeight;
                curX = startingX;
            }
            g.drawString(word, curX, curY);

            // Move over to the right for next word.
            curX += wordWidth;
        }
    }
}
