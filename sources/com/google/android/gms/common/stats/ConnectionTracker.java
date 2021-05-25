package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
@KeepForSdk
public class ConnectionTracker {
    private static final Object zza = new Object();
    @Nullable
    private static volatile ConnectionTracker zzb = null;
    @VisibleForTesting
    private static boolean zzc = false;
    @VisibleForTesting
    private ConcurrentHashMap<ServiceConnection, ServiceConnection> zzd = new ConcurrentHashMap<>();

    private ConnectionTracker() {
    }

    @RecentlyNonNull
    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (zzb == null) {
            synchronized (zza) {
                if (zzb == null) {
                    zzb = new ConnectionTracker();
                }
            }
        }
        return (ConnectionTracker) Preconditions.checkNotNull(zzb);
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean bindService(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @KeepForSdk
    @SuppressLint({"UntrackedBindService"})
    public void unbindService(@RecentlyNonNull Context context, @RecentlyNonNull ServiceConnection serviceConnection) {
        if (!zza(serviceConnection) || !this.zzd.containsKey(serviceConnection)) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException unused) {
            }
        } else {
            try {
                try {
                    context.unbindService(this.zzd.get(serviceConnection));
                } catch (IllegalArgumentException | IllegalStateException unused2) {
                }
            } finally {
                this.zzd.remove(serviceConnection);
            }
        }
    }

    @KeepForSdk
    @SuppressLint({"UntrackedBindService"})
    public void unbindServiceSafe(@RecentlyNonNull Context context, @RecentlyNonNull ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException unused) {
        }
    }

    @RecentlyNonNull
    public final boolean zza(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull Intent intent, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull int i) {
        return zza(context, str, intent, serviceConnection, i, true);
    }

    @SuppressLint({"UntrackedBindService"})
    private final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z) {
        boolean z2;
        ComponentName component = intent.getComponent();
        if (component == null) {
            z2 = false;
        } else {
            z2 = ClientLibraryUtils.zza(context, component.getPackageName());
        }
        if (z2) {
            return false;
        }
        if (!zza(serviceConnection)) {
            return context.bindService(intent, serviceConnection, i);
        }
        ServiceConnection putIfAbsent = this.zzd.putIfAbsent(serviceConnection, serviceConnection);
        if (!(putIfAbsent == null || serviceConnection == putIfAbsent)) {
            String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction());
        }
        try {
            boolean bindService = context.bindService(intent, serviceConnection, i);
            return !bindService ? bindService : bindService;
        } finally {
            this.zzd.remove(serviceConnection, serviceConnection);
        }
    }

    private static boolean zza(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof zzk);
    }
}
