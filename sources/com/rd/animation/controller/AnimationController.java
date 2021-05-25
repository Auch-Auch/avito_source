package com.rd.animation.controller;

import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.type.BaseAnimation;
import com.rd.animation.type.DropAnimation;
import com.rd.animation.type.WormAnimation;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.utils.CoordinatesUtils;
public class AnimationController {
    public ValueController a;
    public ValueController.UpdateListener b;
    public BaseAnimation c;
    public Indicator d;
    public float e;
    public boolean f;

    public AnimationController(@NonNull Indicator indicator, @NonNull ValueController.UpdateListener updateListener) {
        this.a = new ValueController(updateListener);
        this.b = updateListener;
        this.d = indicator;
    }

    public final void a() {
        boolean z = true;
        switch (this.d.getAnimationType().ordinal()) {
            case 0:
                this.b.onValueUpdated(null);
                return;
            case 1:
                BaseAnimation duration = this.a.color().with(this.d.getUnselectedColor(), this.d.getSelectedColor()).duration(this.d.getAnimationDuration());
                if (this.f) {
                    duration.progress(this.e);
                } else {
                    duration.start();
                }
                this.c = duration;
                return;
            case 2:
                BaseAnimation duration2 = this.a.scale().with(this.d.getUnselectedColor(), this.d.getSelectedColor(), this.d.getRadius(), this.d.getScaleFactor()).duration(this.d.getAnimationDuration());
                if (this.f) {
                    duration2.progress(this.e);
                } else {
                    duration2.start();
                }
                this.c = duration2;
                return;
            case 3:
                int selectedPosition = this.d.isInteractiveAnimation() ? this.d.getSelectedPosition() : this.d.getLastSelectedPosition();
                int selectingPosition = this.d.isInteractiveAnimation() ? this.d.getSelectingPosition() : this.d.getSelectedPosition();
                int coordinate = CoordinatesUtils.getCoordinate(this.d, selectedPosition);
                int coordinate2 = CoordinatesUtils.getCoordinate(this.d, selectingPosition);
                if (selectingPosition <= selectedPosition) {
                    z = false;
                }
                WormAnimation duration3 = this.a.worm().with(coordinate, coordinate2, this.d.getRadius(), z).duration(this.d.getAnimationDuration());
                if (this.f) {
                    duration3.progress(this.e);
                } else {
                    duration3.start();
                }
                this.c = duration3;
                return;
            case 4:
                BaseAnimation duration4 = this.a.slide().with(CoordinatesUtils.getCoordinate(this.d, this.d.isInteractiveAnimation() ? this.d.getSelectedPosition() : this.d.getLastSelectedPosition()), CoordinatesUtils.getCoordinate(this.d, this.d.isInteractiveAnimation() ? this.d.getSelectingPosition() : this.d.getSelectedPosition())).duration(this.d.getAnimationDuration());
                if (this.f) {
                    duration4.progress(this.e);
                } else {
                    duration4.start();
                }
                this.c = duration4;
                return;
            case 5:
                BaseAnimation duration5 = this.a.fill().with(this.d.getUnselectedColor(), this.d.getSelectedColor(), this.d.getRadius(), this.d.getStroke()).duration(this.d.getAnimationDuration());
                if (this.f) {
                    duration5.progress(this.e);
                } else {
                    duration5.start();
                }
                this.c = duration5;
                return;
            case 6:
                int selectedPosition2 = this.d.isInteractiveAnimation() ? this.d.getSelectedPosition() : this.d.getLastSelectedPosition();
                int selectingPosition2 = this.d.isInteractiveAnimation() ? this.d.getSelectingPosition() : this.d.getSelectedPosition();
                int coordinate3 = CoordinatesUtils.getCoordinate(this.d, selectedPosition2);
                int coordinate4 = CoordinatesUtils.getCoordinate(this.d, selectingPosition2);
                if (selectingPosition2 <= selectedPosition2) {
                    z = false;
                }
                WormAnimation duration6 = this.a.thinWorm().with(coordinate3, coordinate4, this.d.getRadius(), z).duration(this.d.getAnimationDuration());
                if (this.f) {
                    duration6.progress(this.e);
                } else {
                    duration6.start();
                }
                this.c = duration6;
                return;
            case 7:
                int selectedPosition3 = this.d.isInteractiveAnimation() ? this.d.getSelectedPosition() : this.d.getLastSelectedPosition();
                int selectingPosition3 = this.d.isInteractiveAnimation() ? this.d.getSelectingPosition() : this.d.getSelectedPosition();
                int coordinate5 = CoordinatesUtils.getCoordinate(this.d, selectedPosition3);
                int coordinate6 = CoordinatesUtils.getCoordinate(this.d, selectingPosition3);
                int paddingTop = this.d.getPaddingTop();
                int paddingLeft = this.d.getPaddingLeft();
                if (this.d.getOrientation() != Orientation.HORIZONTAL) {
                    paddingTop = paddingLeft;
                }
                int radius = this.d.getRadius();
                DropAnimation with = this.a.drop().duration(this.d.getAnimationDuration()).with(coordinate5, coordinate6, (radius * 3) + paddingTop, radius + paddingTop, radius);
                if (this.f) {
                    with.progress(this.e);
                } else {
                    with.start();
                }
                this.c = with;
                return;
            case 8:
                BaseAnimation duration7 = this.a.swap().with(CoordinatesUtils.getCoordinate(this.d, this.d.isInteractiveAnimation() ? this.d.getSelectedPosition() : this.d.getLastSelectedPosition()), CoordinatesUtils.getCoordinate(this.d, this.d.isInteractiveAnimation() ? this.d.getSelectingPosition() : this.d.getSelectedPosition())).duration(this.d.getAnimationDuration());
                if (this.f) {
                    duration7.progress(this.e);
                } else {
                    duration7.start();
                }
                this.c = duration7;
                return;
            case 9:
                BaseAnimation duration8 = this.a.scaleDown().with(this.d.getUnselectedColor(), this.d.getSelectedColor(), this.d.getRadius(), this.d.getScaleFactor()).duration(this.d.getAnimationDuration());
                if (this.f) {
                    duration8.progress(this.e);
                } else {
                    duration8.start();
                }
                this.c = duration8;
                return;
            default:
                return;
        }
    }

    public void basic() {
        this.f = false;
        this.e = 0.0f;
        a();
    }

    public void end() {
        BaseAnimation baseAnimation = this.c;
        if (baseAnimation != null) {
            baseAnimation.end();
        }
    }

    public void interactive(float f2) {
        this.f = true;
        this.e = f2;
        a();
    }
}
