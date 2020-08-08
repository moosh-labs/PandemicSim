 
 
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
public class CreateImageFileFromGraphicsObject {
 
    public static void main(String[] args) throws IOException {
 
        int width = 50;
        int height = 50;
 
        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
 
        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();
 
        // fill all the image with white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
 
        // create a circle with blackhttps://www.youtube.com/watch?v=6NppIiqGv8g
        g2d.setColor(Color.black);
        g2d.fillOval(0, 0, width, height);
 
        // create a string with yellow
       
 
        // Disposes of this graphics context and releases any system resources that it is using. 
        g2d.dispose();
 
        // Save as PNG
        File file = new File("myimage.png");
        ImageIO.write(bufferedImage, "png", file);
 
        // Save as JPEG
        file = new File("myimage.jpg");
        ImageIO.write(bufferedImage, "jpg", file);
 
    }
 
}