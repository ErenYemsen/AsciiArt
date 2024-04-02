import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ImageReader imageReader = new ImageReader("/Users/erenyemsen/IdeaProjects/AsciiArt/src/monalisa.jpg");

        int[][][] pixels = imageReader.getPixelArray();

        PixelConverter pixelConverter = new PixelConverter(pixels);
        double[][] brightnessMatrix = pixelConverter.brightnessMatrix();

        char[][] charMatrix = pixelConverter.charMatrix(brightnessMatrix);



        for (int i = 0; i < charMatrix.length; i++) {
            String satir = "";
            for (int j = 0; j < charMatrix[0].length; j++) {
                satir += String.valueOf(charMatrix[i][j]);
            }
            System.out.println(satir);
        }

        //System.out.println(pixels.length);
        //System.out.println(pixels[0].length);

    }
}
