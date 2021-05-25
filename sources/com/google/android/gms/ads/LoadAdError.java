package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public final class LoadAdError extends AdError {
    @Nullable
    private final ResponseInfo zzadg;

    public LoadAdError(int i, @NonNull String str, @NonNull String str2, @Nullable AdError adError, @Nullable ResponseInfo responseInfo) {
        super(i, str, str2, adError);
        this.zzadg = responseInfo;
    }
}
