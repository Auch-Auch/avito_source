package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzabc {
    public static void zza(zzaba zzaba, @Nullable zzaax zzaax) {
        if (zzaax.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzaax.zzls())) {
            zzaba.zza(zzaax.getContext(), zzaax.zzls(), zzaax.zzrh(), zzaax.zzri());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
