package com.rd.draw.drawer.type;

import a2.n.a.a.a.a;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.WormAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
public class WormDrawer extends a {
    public RectF rect = new RectF();

    public WormDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Value value, int i, int i2) {
        if (value instanceof WormAnimationValue) {
            WormAnimationValue wormAnimationValue = (WormAnimationValue) value;
            int rectStart = wormAnimationValue.getRectStart();
            int rectEnd = wormAnimationValue.getRectEnd();
            int radius = this.b.getRadius();
            int unselectedColor = this.b.getUnselectedColor();
            int selectedColor = this.b.getSelectedColor();
            if (this.b.getOrientation() == Orientation.HORIZONTAL) {
                RectF rectF = this.rect;
                rectF.left = (float) rectStart;
                rectF.right = (float) rectEnd;
                rectF.top = (float) (i2 - radius);
                rectF.bottom = (float) (i2 + radius);
            } else {
                RectF rectF2 = this.rect;
                rectF2.left = (float) (i - radius);
                rectF2.right = (float) (i + radius);
                rectF2.top = (float) rectStart;
                rectF2.bottom = (float) rectEnd;
            }
            this.a.setColor(unselectedColor);
            float f = (float) i;
            float f2 = (float) i2;
            float f3 = (float) radius;
            canvas.drawCircle(f, f2, f3, this.a);
            this.a.setColor(selectedColor);
            canvas.drawRoundRect(this.rect, f3, f3, this.a);
        }
    }
}
