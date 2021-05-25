package com.my.target;

import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
public abstract class ca extends by {
    @Nullable
    public ImageData e;
    public float f;
    public boolean g = true;
    public boolean h = true;

    public ca() {
        this.clickArea = bq.dJ;
    }

    public float getAllowCloseDelay() {
        return this.f;
    }

    @Nullable
    public ImageData getCloseIcon() {
        return this.e;
    }

    public boolean isAllowBackButton() {
        return this.h;
    }

    public boolean isAllowClose() {
        return this.g;
    }

    public void setAllowBackButton(boolean z) {
        this.h = z;
    }

    public void setAllowClose(boolean z) {
        this.g = z;
    }

    public void setAllowCloseDelay(float f2) {
        this.f = f2;
    }

    public void setCloseIcon(@Nullable ImageData imageData) {
        this.e = imageData;
    }
}
