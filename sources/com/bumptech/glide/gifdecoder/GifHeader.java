package com.bumptech.glide.gifdecoder;

import a2.d.a.c.a;
import androidx.annotation.ColorInt;
import java.util.ArrayList;
import java.util.List;
public class GifHeader {
    public static final int NETSCAPE_LOOP_COUNT_DOES_NOT_EXIST = -1;
    public static final int NETSCAPE_LOOP_COUNT_FOREVER = 0;
    @ColorInt
    public int[] a = null;
    public int b = 0;
    public int c = 0;
    public a d;
    public final List<a> e = new ArrayList();
    public int f;
    public int g;
    public boolean h;
    public int i;
    public int j;
    @ColorInt
    public int k;
    public int l = -1;

    public int getHeight() {
        return this.g;
    }

    public int getNumFrames() {
        return this.c;
    }

    public int getStatus() {
        return this.b;
    }

    public int getWidth() {
        return this.f;
    }
}
