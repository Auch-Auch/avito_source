package com.google.android.gms.internal.vision;

import java.util.List;
import java.util.Objects;
public final class zzfh extends zzfg {
    private final zzff zzob = new zzff();

    @Override // com.google.android.gms.internal.vision.zzfg
    public final void zza(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.zzob.zza(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }

    @Override // com.google.android.gms.internal.vision.zzfg
    public final void zza(Throwable th) {
        th.printStackTrace();
        List<Throwable> zza = this.zzob.zza(th, false);
        if (zza != null) {
            synchronized (zza) {
                for (Throwable th2 : zza) {
                    System.err.print("Suppressed: ");
                    th2.printStackTrace();
                }
            }
        }
    }
}
