package com.evernote.android.job.util;

import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class BatteryStatus {
    public static final BatteryStatus DEFAULT = new BatteryStatus(false, 1.0f);
    public final boolean a;
    public final float b;

    public BatteryStatus(boolean z, float f) {
        this.a = z;
        this.b = f;
    }

    public float getBatteryPercent() {
        return this.b;
    }

    public boolean isBatteryLow() {
        return this.b < 0.15f && !this.a;
    }

    public boolean isCharging() {
        return this.a;
    }
}
