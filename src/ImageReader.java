import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {
    private int[][][] pixels;
    private final BufferedImage image;
    private final int width;
    private final int height;

    public ImageReader(String path) throws IOException {
        this.image = ImageIO.read(new File(path));
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.pixels = this.getPixelArray();
    }
    
    public int[][][] getPixelArray(){
        int[][][] pixels = new int[this.height][this.width][3];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                int pixel = this.image.getRGB(j, i);
                Color color = new Color(pixel, true);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                pixels[i][j][0] = red;
                pixels[i][j][1] = green;
                pixels[i][j][2] = blue;
            }
        }
        return pixels;
    }

}
