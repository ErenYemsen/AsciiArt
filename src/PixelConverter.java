public class PixelConverter {
    private int[][][] pixels;

    private static final char[] charset =
            "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$".toCharArray();

    PixelConverter(int[][][] pixels){
        this.pixels = pixels;
    }

    //pixel to brightness
    public double pixelToBrightness(int[] pixel){
        double brightness = (pixel[0] + pixel[1] + pixel[2]) / 3.0;
        return brightness;
    }

    //pixel matrix to brightness matrix
    public double[][] brightnessMatrix(){
        int height = this.pixels.length;
        int width = this.pixels[0].length;

        double[][] brightnessMatrix = new double[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                brightnessMatrix[i][j] = this.pixelToBrightness(this.pixels[i][j]);
            }
        }
        return brightnessMatrix;
    }

    //brightness to char

    public char brightnessToChar(double brightness){
        return PixelConverter.charset[(int) (PixelConverter.charset.length / 255.0 * brightness)];
    }

    //brightness matrix to char matrix
    public char[][] charMatrix(double[][] brightnessMatrix){
        int height = this.pixels.length;
        int width = this.pixels[0].length;

        char[][] charMatrix = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                charMatrix[i][j] = brightnessToChar(brightnessMatrix[i][j]);
            }
        }

        return charMatrix;
    }

}
