package com.google.android.gms.vision.clearcut;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.internal.vision.zze;
import com.google.android.gms.internal.vision.zzfl;
import com.google.android.gms.internal.vision.zzi;
import com.google.android.gms.vision.L;
import java.util.concurrent.ExecutorService;
@Keep
public class DynamiteClearcutLogger {
    private static final ExecutorService zzbv = zze.zzb().zza(2, zzi.zzu);
    private zzb zzbw = new zzb(0.03333333333333333d);
    private VisionClearcutLogger zzbx;

    public DynamiteClearcutLogger(Context context) {
        this.zzbx = new VisionClearcutLogger(context);
    }

    public final void zza(int i, zzfl.zzo zzo) {
        if (i != 3 || this.zzbw.tryAcquire()) {
            zzbv.execute(new zza(this, i, zzo));
        } else {
            L.v("Skipping image analysis log due to rate limiting", new Object[0]);
        }
    }
}
