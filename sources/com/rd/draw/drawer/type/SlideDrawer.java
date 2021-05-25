package com.rd.draw.drawer.type;

import a2.n.a.a.a.a;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.SlideAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
public class SlideDrawer extends a {
    public SlideDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Value value, int i, int i2) {
        if (value instanceof SlideAnimationValue) {
            int coordinate = ((SlideAnimationValue) value).getCoordinate();
            int unselectedColor = this.b.getUnselectedColor();
            int selectedColor = this.b.getSelectedColor();
            int radius = this.b.getRadius();
            this.a.setColor(unselectedColor);
            float f = (float) i;
            float f2 = (float) i2;
            float f3 = (float) radius;
            canvas.drawCircle(f, f2, f3, this.a);
            this.a.setColor(selectedColor);
            if (this.b.getOrientation() == Orientation.HORIZONTAL) {
                canvas.drawCircle((float) coordinate, f2, f3, this.a);
            } else {
                canvas.drawCircle(f, (float) coordinate, f3, this.a);
            }
        }
    }
}
