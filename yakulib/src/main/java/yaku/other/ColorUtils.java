package yaku.other;

import java.awt.Color;


/**
 * @author Elijah Bare
 *<p>
 * Utility class for working with colors in Java.
 * Provides methods to modify individual color components (red, green, blue, alpha).
 */
public class ColorUtils {
    public static Color modifyRed(Color color, int newRed) {
        int green = color.getGreen();
        int blue = color.getBlue();
        int alpha = color.getAlpha();

        return new Color(newRed, green, blue, alpha);
    }

    public static Color modifyGreen(Color color, int newGreen) {
        int red = color.getRed();
        int blue = color.getBlue();
        int alpha = color.getAlpha();

        return new Color(red, newGreen, blue, alpha);
    }

    public static Color modifyBlue(Color color, int newBlue) {
        int red = color.getRed();
        int green = color.getGreen();
        int alpha = color.getAlpha();

        return new Color(red, green, newBlue, alpha);
    }

    public static Color modifyAlpha(Color color, int newAlpha) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        return new Color(red, green, blue, newAlpha);
    }

}
