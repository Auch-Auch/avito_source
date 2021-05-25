package com.rd.draw.drawer.type;

import a2.n.a.a.a.a;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.DropAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
public class DropDrawer extends a {
    public DropDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Value value, int i, int i2) {
        if (value instanceof DropAnimationValue) {
            DropAnimationValue dropAnimationValue = (DropAnimationValue) value;
            int unselectedColor = this.b.getUnselectedColor();
            int selectedColor = this.b.getSelectedColor();
            this.a.setColor(unselectedColor);
            canvas.drawCircle((float) i, (float) i2, (float) this.b.getRadius(), this.a);
            this.a.setColor(selectedColor);
            if (this.b.getOrientation() == Orientation.HORIZONTAL) {
                canvas.drawCircle((float) dropAnimationValue.getWidth(), (float) dropAnimationValue.getHeight(), (float) dropAnimationValue.getRadius(), this.a);
            } else {
                canvas.drawCircle((float) dropAnimationValue.getHeight(), (float) dropAnimationValue.getWidth(), (float) dropAnimationValue.getRadius(), this.a);
            }
        }
    }
}
