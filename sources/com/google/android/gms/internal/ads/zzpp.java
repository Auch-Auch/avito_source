package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
public final class zzpp implements ThreadFactory {
    private final /* synthetic */ String zzbkh;

    public zzpp(String str) {
        this.zzbkh = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.zzbkh);
    }
}
