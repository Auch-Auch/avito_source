package com.otaliastudios.cameraview.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.controls.Grid;
public class GridLinesLayout extends View {
    public static final int DEFAULT_COLOR = Color.argb(160, 255, 255, 255);
    public Grid a;
    public int b;
    public ColorDrawable c;
    public ColorDrawable d;
    public final float e;

    public GridLinesLayout(@NonNull Context context) {
        this(context, null);
    }

    private int getLineCount() {
        int ordinal = this.a.ordinal();
        if (ordinal == 1) {
            return 2;
        }
        if (ordinal != 2) {
            return ordinal != 3 ? 0 : 2;
        }
        return 3;
    }

    public int getGridColor() {
        return this.b;
    }

    @NonNull
    public Grid getGridMode() {
        return this.a;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        float f;
        super.onDraw(canvas);
        int lineCount = getLineCount();
        for (int i = 0; i < lineCount; i++) {
            int lineCount2 = getLineCount();
            if (this.a == Grid.DRAW_PHI) {
                f = 0.38196602f;
                if (i != 1) {
                    f = 0.618034f;
                }
            } else {
                f = (1.0f / ((float) (lineCount2 + 1))) * (((float) i) + 1.0f);
            }
            canvas.translate(0.0f, ((float) getHeight()) * f);
            this.c.draw(canvas);
            float f2 = -f;
            canvas.translate(0.0f, ((float) getHeight()) * f2);
            canvas.translate(f * ((float) getWidth()), 0.0f);
            this.d.draw(canvas);
            canvas.translate(f2 * ((float) getWidth()), 0.0f);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c.setBounds(i, 0, i3, (int) this.e);
        this.d.setBounds(0, i2, (int) this.e, i4);
    }

    public void setGridColor(@ColorInt int i) {
        this.b = i;
        this.c.setColor(i);
        this.d.setColor(i);
        postInvalidate();
    }

    public void setGridMode(@NonNull Grid grid) {
        this.a = grid;
        postInvalidate();
    }

    public GridLinesLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = DEFAULT_COLOR;
        this.c = new ColorDrawable(this.b);
        this.d = new ColorDrawable(this.b);
        this.e = TypedValue.applyDimension(1, 0.9f, context.getResources().getDisplayMetrics());
    }
}
