package com.rd.draw.controller;

import android.graphics.Canvas;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.data.Value;
import com.rd.draw.data.Indicator;
import com.rd.draw.drawer.Drawer;
import com.rd.utils.CoordinatesUtils;
public class DrawController {
    public Value a;
    public Drawer b;
    public Indicator c;
    public ClickListener d;

    public interface ClickListener {
        void onIndicatorClicked(int i);
    }

    public DrawController(@NonNull Indicator indicator) {
        this.c = indicator;
        this.b = new Drawer(indicator);
    }

    public void draw(@NonNull Canvas canvas) {
        int count = this.c.getCount();
        int i = 0;
        while (i < count) {
            int xCoordinate = CoordinatesUtils.getXCoordinate(this.c, i);
            int yCoordinate = CoordinatesUtils.getYCoordinate(this.c, i);
            boolean isInteractiveAnimation = this.c.isInteractiveAnimation();
            int selectedPosition = this.c.getSelectedPosition();
            int selectingPosition = this.c.getSelectingPosition();
            boolean z = (isInteractiveAnimation && (i == selectedPosition || i == selectingPosition)) | (!isInteractiveAnimation && (i == selectedPosition || i == this.c.getLastSelectedPosition()));
            this.b.setup(i, xCoordinate, yCoordinate);
            if (this.a == null || !z) {
                this.b.drawBasic(canvas, z);
            } else {
                switch (this.c.getAnimationType().ordinal()) {
                    case 0:
                        this.b.drawBasic(canvas, true);
                        continue;
                    case 1:
                        this.b.drawColor(canvas, this.a);
                        continue;
                    case 2:
                        this.b.drawScale(canvas, this.a);
                        continue;
                    case 3:
                        this.b.drawWorm(canvas, this.a);
                        continue;
                    case 4:
                        this.b.drawSlide(canvas, this.a);
                        continue;
                    case 5:
                        this.b.drawFill(canvas, this.a);
                        continue;
                    case 6:
                        this.b.drawThinWorm(canvas, this.a);
                        continue;
                    case 7:
                        this.b.drawDrop(canvas, this.a);
                        continue;
                    case 8:
                        this.b.drawSwap(canvas, this.a);
                        continue;
                    case 9:
                        this.b.drawScaleDown(canvas, this.a);
                        continue;
                }
            }
            i++;
        }
    }

    public void setClickListener(@Nullable ClickListener clickListener) {
        this.d = clickListener;
    }

    public void touch(@Nullable MotionEvent motionEvent) {
        int position;
        if (motionEvent != null && motionEvent.getAction() == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.d != null && (position = CoordinatesUtils.getPosition(this.c, x, y)) >= 0) {
                this.d.onIndicatorClicked(position);
            }
        }
    }

    public void updateValue(@Nullable Value value) {
        this.a = value;
    }
}
