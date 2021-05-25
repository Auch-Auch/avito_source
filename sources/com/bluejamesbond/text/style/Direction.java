package com.bluejamesbond.text.style;
public enum Direction {
    LEFT_TO_RIGHT(false),
    RIGHT_TO_LEFT(true);
    
    public boolean a;

    /* access modifiers changed from: public */
    Direction(boolean z) {
        this.a = z;
    }

    public boolean isReverse() {
        return this.a;
    }
}
