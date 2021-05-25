package com.my.target;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public final class fv extends FrameLayout {
    @NonNull
    public final fo a;
    public int b;
    public int c;

    public fv(@NonNull Context context) {
        this(context, null);
    }

    public fv(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public fv(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        fo foVar = new fo(context);
        this.a = foVar;
        int c2 = io.c(2, context);
        foVar.setPadding(c2, c2, c2, c2);
        foVar.setFixedHeight(io.c(17, context));
        addView(foVar);
    }

    public void f(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    @NonNull
    public fo getAdChoicesView() {
        return this.a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.b;
        if (i3 > 0 && this.c > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
            i2 = View.MeasureSpec.makeMeasureSpec(this.c, 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
