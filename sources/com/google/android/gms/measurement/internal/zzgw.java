package com.google.android.gms.measurement.internal;
public abstract class zzgw extends zzgx {
    private boolean zza;

    public zzgw(zzgd zzgd) {
        super(zzgd);
        this.zzy.zza(this);
    }

    public void f_() {
    }

    public final void zzaa() {
        if (!zzz()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzab() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zze()) {
            this.zzy.zzaf();
            this.zza = true;
        }
    }

    public final void zzac() {
        if (!this.zza) {
            f_();
            this.zzy.zzaf();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zze();

    public final boolean zzz() {
        return this.zza;
    }
}
