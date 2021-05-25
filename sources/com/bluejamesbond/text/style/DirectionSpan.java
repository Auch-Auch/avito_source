package com.bluejamesbond.text.style;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
public class DirectionSpan extends CharacterStyle {
    public final Direction a;

    public DirectionSpan(Direction direction) {
        this.a = direction;
    }

    public Direction getDirection() {
        return this.a;
    }

    public boolean isReverse() {
        return this.a.isReverse();
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
    }
}
