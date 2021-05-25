package com.google.android.gms.internal.gtm;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
public final class zzgp {

    public static class zza {
        private static volatile ExecutorService zzaqx;

        private zza() {
        }

        public static ExecutorService zzr(Context context) {
            if (zzaqx == null) {
                synchronized (zza.class) {
                    if (zzaqx == null) {
                        zzaqx = new zzef(context, 1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new zzgq());
                    }
                }
            }
            return zzaqx;
        }
    }
}
