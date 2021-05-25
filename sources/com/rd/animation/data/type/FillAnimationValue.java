package com.rd.animation.data.type;

import com.rd.animation.data.Value;
public class FillAnimationValue extends ColorAnimationValue implements Value {
    public int c;
    public int d;
    public int e;
    public int f;

    public int getRadius() {
        return this.c;
    }

    public int getRadiusReverse() {
        return this.d;
    }

    public int getStroke() {
        return this.e;
    }

    public int getStrokeReverse() {
        return this.f;
    }

    public void setRadius(int i) {
        this.c = i;
    }

    public void setRadiusReverse(int i) {
        this.d = i;
    }

    public void setStroke(int i) {
        this.e = i;
    }

    public void setStrokeReverse(int i) {
        this.f = i;
    }
}
