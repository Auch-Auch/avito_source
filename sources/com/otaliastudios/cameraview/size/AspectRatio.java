package com.otaliastudios.cameraview.size;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
public class AspectRatio implements Comparable<AspectRatio> {
    @VisibleForTesting
    public static final HashMap<String, AspectRatio> c = new HashMap<>(16);
    public final int a;
    public final int b;

    public AspectRatio(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @NonNull
    public static AspectRatio of(@NonNull Size size) {
        return of(size.getWidth(), size.getHeight());
    }

    @NonNull
    public static AspectRatio parse(@NonNull String str) {
        String[] split = str.split(":");
        if (split.length == 2) {
            return of(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        throw new NumberFormatException("Illegal AspectRatio string. Must be x:y");
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AspectRatio) || toFloat() != ((AspectRatio) obj).toFloat()) {
            return false;
        }
        return true;
    }

    @NonNull
    public AspectRatio flip() {
        return of(this.b, this.a);
    }

    public int getX() {
        return this.a;
    }

    public int getY() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Float.floatToIntBits(toFloat());
    }

    public boolean matches(@NonNull Size size) {
        return equals(of(size));
    }

    public float toFloat() {
        return ((float) this.a) / ((float) this.b);
    }

    @Override // java.lang.Object
    @NonNull
    public String toString() {
        return this.a + ":" + this.b;
    }

    @NonNull
    public static AspectRatio of(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (i4 != 0) {
            int i5 = i3 % i4;
            i3 = i4;
            i4 = i5;
        }
        if (i3 > 0) {
            i /= i3;
        }
        if (i3 > 0) {
            i2 /= i3;
        }
        String str = i + ":" + i2;
        HashMap<String, AspectRatio> hashMap = c;
        AspectRatio aspectRatio = hashMap.get(str);
        if (aspectRatio != null) {
            return aspectRatio;
        }
        AspectRatio aspectRatio2 = new AspectRatio(i, i2);
        hashMap.put(str, aspectRatio2);
        return aspectRatio2;
    }

    public int compareTo(@NonNull AspectRatio aspectRatio) {
        return Float.compare(toFloat(), aspectRatio.toFloat());
    }

    public boolean matches(@NonNull Size size, float f) {
        return Math.abs(toFloat() - of(size).toFloat()) <= f;
    }
}
