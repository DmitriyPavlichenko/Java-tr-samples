package com.company;

import java.io.Serializable;

public class UserPreferences implements Serializable {
    private final static String[] COLOR_TYPES = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple"};
    private final static String[] FONT_TYPES = {"Architectural", "Arial", "Arial-bold", "Copperplate"};
    private final static String[] SIZE_TYPES = {"2", "4", "8", "16", "32", "64"};

    private String color;
    private String font;
    private String size;



    public static String[] getColorTypes() {
        return COLOR_TYPES;
    }

    public static String[] getFontTypes() {
        return FONT_TYPES;
    }

    public static String[] getSizeTypes() {
        return SIZE_TYPES;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
