package com.google.android.gms.internal.ads;
public final class zzdt implements Runnable {
    private final /* synthetic */ zzdu zzwf;

    public zzdt(zzdu zzdu) {
        this.zzwf = zzdu;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        if (this.zzwf.zzwj == null) {
            synchronized (zzdu.zzwh) {
                if (this.zzwf.zzwj == null) {
                    boolean z2 = false;
                    try {
                        z = zzaat.zzcqi.get().booleanValue();
                    } catch (IllegalStateException unused) {
                        z = false;
                    }
                    if (z) {
                        try {
                            zzdu.zzwi = new zztt(this.zzwf.zzwg.zzvr, "ADSHIELD", null);
                        } catch (Throwable unused2) {
                        }
                    }
                    z2 = z;
                    this.zzwf.zzwj = Boolean.valueOf(z2);
                    zzdu.zzwh.open();
                }
            }
        }
    }
}
