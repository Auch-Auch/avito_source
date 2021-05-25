package com.facebook.appevents.ml;
public class MTensor {
    public float[] a;
    public int[] b;
    public int c;

    public MTensor(int[] iArr) {
        this.b = iArr;
        int i = 1;
        for (int i2 : iArr) {
            i *= i2;
        }
        this.c = i;
        this.a = new float[i];
    }

    public float[] getData() {
        return this.a;
    }

    public int getShape(int i) {
        return this.b[i];
    }

    public int getShapeSize() {
        return this.b.length;
    }

    public void reshape(int[] iArr) {
        this.b = iArr;
        int i = 1;
        for (int i2 : iArr) {
            i *= i2;
        }
        float[] fArr = new float[i];
        System.arraycopy(this.a, 0, fArr, 0, Math.min(this.c, i));
        this.a = fArr;
        this.c = i;
    }
}
