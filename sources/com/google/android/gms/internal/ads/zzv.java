package com.google.android.gms.internal.ads;

import com.avito.android.remote.model.payment.status.PaymentStateKt;
public final class zzv implements Runnable {
    private final zzaa zzah;
    private final zzaj zzai;
    private final Runnable zzaj;

    public zzv(zzaa zzaa, zzaj zzaj2, Runnable runnable) {
        this.zzah = zzaa;
        this.zzai = zzaj2;
        this.zzaj = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzah.isCanceled();
        if (this.zzai.isSuccess()) {
            this.zzah.zza((zzaa) this.zzai.result);
        } else {
            this.zzah.zzb(this.zzai.zzbt);
        }
        if (this.zzai.zzbu) {
            this.zzah.zzc("intermediate-response");
        } else {
            this.zzah.zzd(PaymentStateKt.PAYMENT_STATE_DONE);
        }
        Runnable runnable = this.zzaj;
        if (runnable != null) {
            runnable.run();
        }
    }
}
