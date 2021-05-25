package com.facebook.imageformat;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
public class ImageFormat {
    public static final ImageFormat UNKNOWN = new ImageFormat("UNKNOWN", null);
    @Nullable
    public final String a;
    public final String b;

    public interface FormatChecker {
        @Nullable
        ImageFormat determineFormat(@Nonnull byte[] bArr, int i);

        int getHeaderSize();
    }

    public ImageFormat(String str, @Nullable String str2) {
        this.b = str;
        this.a = str2;
    }

    @Nullable
    public String getFileExtension() {
        return this.a;
    }

    public String getName() {
        return this.b;
    }

    public String toString() {
        return getName();
    }
}
