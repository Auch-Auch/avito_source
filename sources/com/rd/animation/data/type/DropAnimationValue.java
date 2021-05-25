package com.rd.animation.data.type;

import com.rd.animation.data.Value;
public class DropAnimationValue implements Value {
    public int a;
    public int b;
    public int c;

    public int getHeight() {
        return this.b;
    }

    public int getRadius() {
        return this.c;
    }

    public int getWidth() {
        return this.a;
    }

    public void setHeight(int i) {
        this.b = i;
    }

    public void setRadius(int i) {
        this.c = i;
    }

    public void setWidth(int i) {
        this.a = i;
    }
}
