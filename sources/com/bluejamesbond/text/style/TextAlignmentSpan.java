package com.bluejamesbond.text.style;

import android.text.Layout;
import android.text.style.AlignmentSpan;
public abstract class TextAlignmentSpan implements AlignmentSpan {
    @Override // android.text.style.AlignmentSpan
    public Layout.Alignment getAlignment() {
        return Layout.Alignment.ALIGN_NORMAL;
    }

    public abstract TextAlignment getTextAlignment();
}
