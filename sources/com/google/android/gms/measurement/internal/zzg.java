package com.google.android.gms.measurement.internal;
public abstract class zzg extends zzd {
    private boolean zza;

    public zzg(zzgd zzgd) {
        super(zzgd);
        this.zzy.zza(this);
    }

    public void zzaa() {
    }

    public final boolean zzv() {
        return this.zza;
    }

    public final void zzw() {
        if (!zzv()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzz()) {
            this.zzy.zzaf();
            this.zza = true;
        }
    }

    public final void zzy() {
        if (!this.zza) {
            zzaa();
            this.zzy.zzaf();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zzz();
}
