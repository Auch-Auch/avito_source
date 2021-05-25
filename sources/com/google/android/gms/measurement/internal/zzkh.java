package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import ru.avito.messenger.internal.ConstantsKt;
public final class zzkh {
    private final Clock zza;
    private long zzb;

    public zzkh(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zza = clock;
    }

    public final void zza() {
        this.zzb = this.zza.elapsedRealtime();
    }

    public final void zzb() {
        this.zzb = 0;
    }

    public final boolean zza(long j) {
        if (this.zzb != 0 && this.zza.elapsedRealtime() - this.zzb < ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS) {
            return false;
        }
        return true;
    }
}
