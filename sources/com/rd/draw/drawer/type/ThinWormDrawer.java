package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.ThinWormAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
public class ThinWormDrawer extends WormDrawer {
    public ThinWormDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    @Override // com.rd.draw.drawer.type.WormDrawer
    public void draw(@NonNull Canvas canvas, @NonNull Value value, int i, int i2) {
        if (value instanceof ThinWormAnimationValue) {
            ThinWormAnimationValue thinWormAnimationValue = (ThinWormAnimationValue) value;
            int rectStart = thinWormAnimationValue.getRectStart();
            int rectEnd = thinWormAnimationValue.getRectEnd();
            int height = thinWormAnimationValue.getHeight() / 2;
            int radius = this.b.getRadius();
            int unselectedColor = this.b.getUnselectedColor();
            int selectedColor = this.b.getSelectedColor();
            if (this.b.getOrientation() == Orientation.HORIZONTAL) {
                RectF rectF = this.rect;
                rectF.left = (float) rectStart;
                rectF.right = (float) rectEnd;
                rectF.top = (float) (i2 - height);
                rectF.bottom = (float) (height + i2);
            } else {
                RectF rectF2 = this.rect;
                rectF2.left = (float) (i - height);
                rectF2.right = (float) (height + i);
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
