package com.bluejamesbond.text.style;
public enum TextAlignment {
    LEFT(0),
    RIGHT(1),
    JUSTIFIED(2),
    CENTER(3);
    
    public final int a;

    /* access modifiers changed from: public */
    TextAlignment(int i) {
        this.a = i;
    }

    public static TextAlignment getById(int i) {
        if (i == 1) {
            return RIGHT;
        }
        if (i == 2) {
            return JUSTIFIED;
        }
        if (i != 3) {
            return LEFT;
        }
        return CENTER;
    }

    public int getId() {
        return this.a;
    }
}
