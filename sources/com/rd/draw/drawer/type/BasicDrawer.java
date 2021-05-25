package com.rd.draw.drawer.type;

import a2.n.a.a.a.a;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
public class BasicDrawer extends a {
    public Paint c;

    public BasicDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.c.setAntiAlias(true);
        this.c.setStrokeWidth((float) indicator.getStroke());
    }

    public void draw(@NonNull Canvas canvas, int i, boolean z, int i2, int i3) {
        Paint paint;
        float radius = (float) this.b.getRadius();
        int stroke = this.b.getStroke();
        float scaleFactor = this.b.getScaleFactor();
        int selectedColor = this.b.getSelectedColor();
        int unselectedColor = this.b.getUnselectedColor();
        int selectedPosition = this.b.getSelectedPosition();
        AnimationType animationType = this.b.getAnimationType();
        if ((animationType == AnimationType.SCALE && !z) || (animationType == AnimationType.SCALE_DOWN && z)) {
            radius *= scaleFactor;
        }
        if (i != selectedPosition) {
            selectedColor = unselectedColor;
        }
        if (animationType != AnimationType.FILL || i == selectedPosition) {
            paint = this.a;
        } else {
            paint = this.c;
            paint.setStrokeWidth((float) stroke);
        }
        paint.setColor(selectedColor);
        canvas.drawCircle((float) i2, (float) i3, radius, paint);
    }
}
