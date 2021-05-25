package com.my.target;

import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.my.target.common.models.ImageData;
public class bu {
    public int a = -16733198;
    public int b = -16746839;
    public int c = -1;
    public int d = ViewCompat.MEASURED_STATE_MASK;
    public int e = -1;
    public int f = -1;
    public int g = ViewCompat.MEASURED_STATE_MASK;
    public int h = -11176784;
    public int i = -1;
    public float j = 0.5f;
    @Nullable
    public ImageData k;

    public static bu bs() {
        return new bu();
    }

    public void a(@Nullable ImageData imageData) {
        this.k = imageData;
    }

    public int bA() {
        return this.i;
    }

    @Nullable
    public ImageData bt() {
        return this.k;
    }

    public int bu() {
        return this.a;
    }

    public int bv() {
        return this.b;
    }

    public int bw() {
        return this.c;
    }

    public int bx() {
        return this.g;
    }

    public int by() {
        return this.h;
    }

    public float bz() {
        return this.j;
    }

    public void e(float f2) {
        this.j = f2;
    }

    public int getBackgroundColor() {
        return this.d;
    }

    public int getTextColor() {
        return this.e;
    }

    public int getTitleColor() {
        return this.f;
    }

    public void i(int i2) {
        this.a = i2;
    }

    public void j(int i2) {
        this.b = i2;
    }

    public void k(int i2) {
        this.c = i2;
    }

    public void l(int i2) {
        this.g = i2;
    }

    public void m(int i2) {
        this.h = i2;
    }

    public void n(int i2) {
        this.i = i2;
    }

    public void setBackgroundColor(int i2) {
        this.d = i2;
    }

    public void setTextColor(int i2) {
        this.e = i2;
    }

    public void setTitleColor(int i2) {
        this.f = i2;
    }
}
