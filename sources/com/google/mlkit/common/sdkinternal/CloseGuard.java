package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzav;
import com.google.android.gms.internal.mlkit_common.zzbg;
import com.google.android.gms.internal.mlkit_common.zzds;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.CloseGuard;
import java.io.Closeable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
@KeepForSdk
public class CloseGuard implements Closeable {
    @KeepForSdk
    public static final int API_TRANSLATE = 1;
    public final AtomicBoolean a = new AtomicBoolean();
    public final String b;
    public final Runnable c;
    public final Cleaner.Cleanable d;
    public final zzds e;
    public final zzav.zzaj.zza f;

    @KeepForSdk
    public static class Factory {
        public final Cleaner a;
        public final zzds b;

        public Factory(Cleaner cleaner, zzds zzds) {
            this.a = cleaner;
            this.b = zzds;
        }

        @KeepForSdk
        public CloseGuard create(Object obj, int i, Runnable runnable) {
            return new CloseGuard(obj, zzav.zzaj.zza.zza(i), this.a, this.b, runnable);
        }
    }

    public CloseGuard(Object obj, zzav.zzaj.zza zza, Cleaner cleaner, zzds zzds, Runnable runnable) {
        this.f = zza;
        this.e = zzds;
        this.b = obj.toString();
        this.c = runnable;
        this.d = cleaner.register(obj, new Runnable(this) { // from class: a2.j.h.a.c.e
            public final CloseGuard a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CloseGuard closeGuard = this.a;
                if (!closeGuard.a.get()) {
                    String.format(Locale.ENGLISH, "%s has not been closed", closeGuard.b);
                    zzav.zzad.zza zzb = zzav.zzad.zzb();
                    zzb.zza(zzav.zzaj.zza().zza(closeGuard.f));
                    closeGuard.e.zza(zzb, zzbg.HANDLE_LEAKED);
                }
                closeGuard.c.run();
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.set(true);
        this.d.clean();
    }
}
