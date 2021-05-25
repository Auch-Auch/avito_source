package com.rd.draw.controller;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.type.AnimationType;
import com.rd.animation.type.ColorAnimation;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.RtlMode;
import com.rd.pageindicatorview.R;
import com.rd.utils.DensityUtils;
public class AttributeController {
    public Indicator a;

    public AttributeController(@NonNull Indicator indicator) {
        this.a = indicator;
    }

    public void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i;
        int i2 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PageIndicatorView, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PageIndicatorView_piv_viewPager, -1);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.PageIndicatorView_piv_autoVisibility, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.PageIndicatorView_piv_dynamicCount, false);
        int i3 = obtainStyledAttributes.getInt(R.styleable.PageIndicatorView_piv_count, -1);
        if (i3 == -1) {
            i3 = 3;
        }
        int i4 = obtainStyledAttributes.getInt(R.styleable.PageIndicatorView_piv_select, 0);
        if (i4 < 0) {
            i4 = 0;
        } else if (i3 > 0 && i4 > i3 - 1) {
            i4 = i;
        }
        this.a.setViewPagerId(resourceId);
        this.a.setAutoVisibility(z);
        this.a.setDynamicCount(z2);
        this.a.setCount(i3);
        this.a.setSelectedPosition(i4);
        this.a.setSelectingPosition(i4);
        this.a.setLastSelectedPosition(i4);
        int color = obtainStyledAttributes.getColor(R.styleable.PageIndicatorView_piv_unselectedColor, Color.parseColor(ColorAnimation.DEFAULT_UNSELECTED_COLOR));
        int color2 = obtainStyledAttributes.getColor(R.styleable.PageIndicatorView_piv_selectedColor, Color.parseColor(ColorAnimation.DEFAULT_SELECTED_COLOR));
        this.a.setUnselectedColor(color);
        this.a.setSelectedColor(color2);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.PageIndicatorView_piv_interactiveAnimation, false);
        long j = (long) obtainStyledAttributes.getInt(R.styleable.PageIndicatorView_piv_animationDuration, 350);
        if (j < 0) {
            j = 0;
        }
        int i5 = R.styleable.PageIndicatorView_piv_animationType;
        AnimationType animationType = AnimationType.NONE;
        switch (obtainStyledAttributes.getInt(i5, 0)) {
            case 1:
                animationType = AnimationType.COLOR;
                break;
            case 2:
                animationType = AnimationType.SCALE;
                break;
            case 3:
                animationType = AnimationType.WORM;
                break;
            case 4:
                animationType = AnimationType.SLIDE;
                break;
            case 5:
                animationType = AnimationType.FILL;
                break;
            case 6:
                animationType = AnimationType.THIN_WORM;
                break;
            case 7:
                animationType = AnimationType.DROP;
                break;
            case 8:
                animationType = AnimationType.SWAP;
                break;
            case 9:
                animationType = AnimationType.SCALE_DOWN;
                break;
        }
        int i6 = R.styleable.PageIndicatorView_piv_rtl_mode;
        RtlMode rtlMode = RtlMode.Off;
        int i7 = obtainStyledAttributes.getInt(i6, 1);
        if (i7 == 0) {
            rtlMode = RtlMode.On;
        } else if (i7 != 1) {
            if (i7 != 2) {
                rtlMode = RtlMode.Auto;
            } else {
                rtlMode = RtlMode.Auto;
            }
        }
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.PageIndicatorView_piv_fadeOnIdle, false);
        this.a.setAnimationDuration(j);
        this.a.setInteractiveAnimation(z3);
        this.a.setAnimationType(animationType);
        this.a.setRtlMode(rtlMode);
        this.a.setFadeOnIdle(z4);
        this.a.setIdleDuration((long) obtainStyledAttributes.getInt(R.styleable.PageIndicatorView_piv_idleDuration, 3000));
        int i8 = R.styleable.PageIndicatorView_piv_orientation;
        Orientation orientation = Orientation.HORIZONTAL;
        if (obtainStyledAttributes.getInt(i8, 0) != 0) {
            orientation = Orientation.VERTICAL;
        }
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.PageIndicatorView_piv_radius, (float) DensityUtils.dpToPx(6));
        if (dimension < 0) {
            dimension = 0;
        }
        int dimension2 = (int) obtainStyledAttributes.getDimension(R.styleable.PageIndicatorView_piv_padding, (float) DensityUtils.dpToPx(8));
        if (dimension2 < 0) {
            dimension2 = 0;
        }
        float f = obtainStyledAttributes.getFloat(R.styleable.PageIndicatorView_piv_scaleFactor, 0.7f);
        if (f < 0.3f) {
            f = 0.3f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        int dimension3 = (int) obtainStyledAttributes.getDimension(R.styleable.PageIndicatorView_piv_strokeWidth, (float) DensityUtils.dpToPx(1));
        if (dimension3 > dimension) {
            dimension3 = dimension;
        }
        if (this.a.getAnimationType() == AnimationType.FILL) {
            i2 = dimension3;
        }
        this.a.setRadius(dimension);
        this.a.setOrientation(orientation);
        this.a.setPadding(dimension2);
        this.a.setScaleFactor(f);
        this.a.setStroke(i2);
        obtainStyledAttributes.recycle();
    }
}
