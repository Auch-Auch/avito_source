package com.otaliastudios.cameraview.size;

import androidx.annotation.NonNull;
public class Size implements Comparable<Size> {
    public final int a;
    public final int b;

    public Size(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (this.a == size.a && this.b == size.b) {
            return true;
        }
        return false;
    }

    public Size flip() {
        return new Size(this.b, this.a);
    }

    public int getHeight() {
        return this.b;
    }

    public int getWidth() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.b;
        int i2 = this.a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    @Override // java.lang.Object
    @NonNull
    public String toString() {
        return this.a + "x" + this.b;
    }

    public int compareTo(@NonNull Size size) {
        return (this.a * this.b) - (size.a * size.b);
    }
}
