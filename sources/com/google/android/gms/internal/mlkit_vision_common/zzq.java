package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Objects;
public final class zzq extends zzm {
    private final zzp zza = new zzp();

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzm
    public final void zza(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.zza.zza(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
