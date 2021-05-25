package com.rd.animation.data.type;

import com.rd.animation.data.Value;
public class ColorAnimationValue implements Value {
    public int a;
    public int b;

    public int getColor() {
        return this.a;
    }

    public int getColorReverse() {
        return this.b;
    }

    public void setColor(int i) {
        this.a = i;
    }

    public void setColorReverse(int i) {
        this.b = i;
    }
}
