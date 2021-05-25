package com.google.android.material.resources;
public class TextAppearanceConfig {
    public static boolean a;

    public static void setShouldLoadFontSynchronously(boolean z) {
        a = z;
    }

    public static boolean shouldLoadFontSynchronously() {
        return a;
    }
}
