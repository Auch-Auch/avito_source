package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
@SuppressLint({"AppCompatCustomView"})
public class ft extends TextView {
    @NonNull
    public final GradientDrawable a;
    public int b;

    public ft(@NonNull Context context) {
        this(context, null);
    }

    public ft(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ft(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.a = gradientDrawable;
        gradientDrawable.setStroke(0, -13421773);
        gradientDrawable.setColor(0);
        this.b = (int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics());
    }

    public void a(int i, int i2, int i3) {
        this.a.setStroke(i, i2);
        this.a.setCornerRadius((float) i3);
        invalidate();
    }

    public void e(int i, int i2) {
        a(i, i2, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        this.a.setBounds(getPaddingLeft() - this.b, getPaddingTop(), getWidth(), getHeight());
        this.a.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension((this.b * 2) + getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.a.setColor(i);
        invalidate();
    }
}
