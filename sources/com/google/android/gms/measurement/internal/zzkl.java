package com.google.android.gms.measurement.internal;
public abstract class zzkl extends zzki {
    private boolean zzb;

    public zzkl(zzkk zzkk) {
        super(zzkk);
        this.zza.zza(this);
    }

    public final boolean zzaj() {
        return this.zzb;
    }

    public final void zzak() {
        if (!zzaj()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (!this.zzb) {
            zze();
            this.zza.zzp();
            this.zzb = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zze();
}
