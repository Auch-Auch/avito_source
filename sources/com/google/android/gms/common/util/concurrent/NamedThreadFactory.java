package com.google.android.gms.common.util.concurrent;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
@KeepForSdk
public class NamedThreadFactory implements ThreadFactory {
    private final String zza;
    private final int zzb;
    private final ThreadFactory zzc;

    @KeepForSdk
    public NamedThreadFactory(@RecentlyNonNull String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    @RecentlyNonNull
    public Thread newThread(@RecentlyNonNull Runnable runnable) {
        Thread newThread = this.zzc.newThread(new zza(runnable, 0));
        newThread.setName(this.zza);
        return newThread;
    }

    private NamedThreadFactory(String str, int i) {
        this.zzc = Executors.defaultThreadFactory();
        this.zza = (String) Preconditions.checkNotNull(str, "Name must not be null");
        this.zzb = 0;
    }
}
