package com.google.android.gms.internal.gtm;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
public abstract class zzmn {
    private int zzasj;
    public final zzmw zzask;
    private final zzms zzasl;
    private final Clock zzasm;
    @Nullable
    public final zzdz zzasn;

    public zzmn(int i, zzmw zzmw, zzms zzms, @Nullable zzdz zzdz) {
        this(i, zzmw, zzms, zzdz, DefaultClock.getInstance());
    }

    private final zzmx zzd(byte[] bArr) {
        zzmx zzmx;
        try {
            zzmx = this.zzasl.zze(bArr);
            if (zzmx == null) {
                try {
                    zzev.zzaw("Parsed resource from is null");
                } catch (zzml unused) {
                }
            }
        } catch (zzml unused2) {
            zzmx = null;
            zzev.zzaw("Resource data is corrupted");
            return zzmx;
        }
        return zzmx;
    }

    public abstract void zza(zzmx zzmx);

    public final void zzb(int i, int i2) {
        zzdz zzdz = this.zzasn;
        if (zzdz != null && i2 == 0 && i == 3) {
            zzdz.zzhn();
        }
        String containerId = this.zzask.zzlk().getContainerId();
        String str = i != 0 ? i != 1 ? i != 2 ? "Unknown reason" : "Server error" : "IOError" : "Resource not available";
        StringBuilder sb = new StringBuilder(str.length() + String.valueOf(containerId).length() + 61);
        sb.append("Failed to fetch the container resource for the container \"");
        sb.append(containerId);
        sb.append("\": ");
        sb.append(str);
        zzev.zzab(sb.toString());
        zza(new zzmx(Status.RESULT_INTERNAL_ERROR, i2));
    }

    public final void zzc(byte[] bArr) {
        zzmx zzmx;
        Status status;
        zzmx zzd = zzd(bArr);
        zzdz zzdz = this.zzasn;
        if (zzdz != null && this.zzasj == 0) {
            zzdz.zzho();
        }
        if (zzd == null || zzd.getStatus() != (status = Status.RESULT_SUCCESS)) {
            zzmx = new zzmx(Status.RESULT_INTERNAL_ERROR, this.zzasj);
        } else {
            zzmx = new zzmx(status, this.zzasj, new zzmy(this.zzask.zzlk(), bArr, zzd.zzll().zzlq(), this.zzasm.currentTimeMillis()), zzd.zzlm());
        }
        zza(zzmx);
    }

    @VisibleForTesting
    private zzmn(int i, zzmw zzmw, zzms zzms, @Nullable zzdz zzdz, Clock clock) {
        this.zzask = (zzmw) Preconditions.checkNotNull(zzmw);
        Preconditions.checkNotNull(zzmw.zzlk());
        this.zzasj = i;
        this.zzasl = (zzms) Preconditions.checkNotNull(zzms);
        this.zzasm = (Clock) Preconditions.checkNotNull(clock);
        this.zzasn = zzdz;
    }
}
