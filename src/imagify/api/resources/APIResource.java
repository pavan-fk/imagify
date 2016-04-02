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
    public Response dummy() {
        String tweet = "a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z a b c d e f g h i j k l m n o p q r s t u v w x y z ";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedImage bufferedImage = new BufferedImage(320, 200,
                BufferedImage.TYPE_INT_RGB);
//        Graphics graphics = bufferedImage.getGraphics();
//        graphics.setColor(Color.WHITE);
//        graphics.fillRect(0, 0, 200, 50);
//        graphics.setColor(Color.BLACK);
//        graphics.setFont(new Font(Font.SERIF, Font.BOLD, 18));
//        graphics.drawString(tweet, 10, 25);


        Graphics2D g2 = bufferedImage.createGraphics();

        g2.setColor(Color.WHITE);
        g2.setFont(new Font(Font.SERIF, Font.BOLD, 18));
        drawer(g2, tweet, 1, 15, 320);
//        g2.drawString(tweet, 50, 50);
        try {
            ImageIO.write(bufferedImage, "jpg", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.ok(baos.toByteArray()).build();
    }

    public void drawer(Graphics g, String s, int x, int y, int width) {
        // FontMetrics gives us information about the width,
        // height, etc. of the current Graphics object's Font.
        FontMetrics fm = g.getFontMetrics();

        int lineHeight = fm.getHeight();

        int curX = x;
        int curY = y;

        String[] words = s.split(" ");

        for (String word : words) {
            // Find out thw width of the word.
            int wordWidth = fm.stringWidth(word + " ");

            // If text exceeds the width, then move to next line.
            if (curX + wordWidth >= x + width) {
                curY += lineHeight;
                curX = x;
            }

            g.drawString(word, curX, curY);

            // Move over to the right for next word.
            curX += wordWidth;
        }
    }
}
