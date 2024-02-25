/*
 Name: Aaditya Manami-Ratan
 Project: Rainbow: A Color Sort
 Description: Sort colors on the RGB spectrum
 Date: Jan 23, 2024
*/

//Sorts the RGB array given based on Google's color-picker order
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static int RGBToHue(int[] rgb) {

        double Red = (double) rgb[0] / 255;
        double Green = (double) rgb[1] / 255;
        double Blue = (double) rgb[2] / 255;

        double max = Math.max(Math.max(Red, Green), Blue);
        double min = Math.min(Math.min(Red, Green), Blue);

        int result = 0;
        if (max == Red) {
            result = (int) (60 * ((Green - Blue) % 6) / (max - min));
        } else if (max == Green) {
            result = (int) (60 * (2.0 + (Blue - Red) / (max - min)));
        } else {

            result = (int) (60 * (4.0 + (Red - Green) / (max - min)));
        }

        if (result < 0) {
            result += 360;
        }

        return result;

    }

    public static void main(String[] args) {
        // RGB values in array
        int[][] RGB = {{ 102, 0, 255}, {255, 0, 93}, {0, 255, 191}, {13, 0, 255}, {145, 255, 0}, {255, 0, 230}, {255, 0, 0}, {0, 136, 255}, {255, 234, 0}, {255, 132, 0}, {0, 255, 17} };

        // same RGB values in arraylist (if you want to use it like this)
        ArrayList<int[]> RGBlist = new ArrayList<>();

        RGBlist.add(new int[] {102, 0, 255});
        RGBlist.add(new int[] {255, 0, 93});
        RGBlist.add(new int[] {0, 255, 191});
        RGBlist.add(new int[] {13, 0, 255});
        RGBlist.add(new int[] {145, 255, 0});
        RGBlist.add(new int[] {255, 0, 230});
        RGBlist.add(new int[] {255, 0, 0});
        RGBlist.add(new int[] {255, 0, 0});
        RGBlist.add(new int[] {0, 136, 255});
        RGBlist.add(new int[] {255, 234, 0});
        RGBlist.add(new int[] {255, 132, 0});
        RGBlist.add(new int[] {0, 255, 17});

        // bubble sort
        for (int i = RGB.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (RGBToHue(RGB[j]) > RGBToHue(RGB[j + 1])) {
                    int[] temp = RGB[j];
                    RGB[j] = RGB[j + 1];
                    RGB[j + 1] = temp;
                }
            }
        }

        // print out the sorted array using loops through the array and the something
        // similar to the following code:
        for (int color[] : RGB) {
            final String RESET = "\033[0m";
            int Red = color[0];
            int Green = color[1];
            int Blue = color[2];
            String text = "♡";
            System.out.println("\u001b[38;2;" + Red + ";" + Green + ";" + Blue + "m" + text + RESET); // this line is the ANSI
            // escape sequence for color
        }

    }

}
