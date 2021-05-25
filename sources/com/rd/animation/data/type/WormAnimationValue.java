package com.rd.animation.data.type;

import com.rd.animation.data.Value;
public class WormAnimationValue implements Value {
    public int a;
    public int b;

    public int getRectEnd() {
        return this.b;
    }

    public int getRectStart() {
        return this.a;
    }

    public void setRectEnd(int i) {
        this.b = i;
    }

    public void setRectStart(int i) {
        this.a = i;
    }
}
