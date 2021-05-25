package com.google.android.gms.internal.measurement;

import java.util.Objects;
public final class zzgg extends zzgc {
    private final zzgf zza = new zzgf();

    @Override // com.google.android.gms.internal.measurement.zzgc
    public final void zza(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.zza.zza(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
