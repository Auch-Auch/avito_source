package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorDurationScaleProvider {
    public static float a = 1.0f;

    @VisibleForTesting
    public static void setDefaultSystemAnimatorDurationScale(float f) {
        a = f;
    }

    public float getSystemAnimatorDurationScale(@NonNull ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
