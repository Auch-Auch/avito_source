package com.google.android.gms.internal.ads;
public final class zzbdg implements Runnable {
    private boolean zzbsq = false;
    private zzbcr zzegi;

    public zzbdg(zzbcr zzbcr) {
        this.zzegi = zzbcr;
    }

    private final void zzzx() {
        zzdsf zzdsf = zzayh.zzeaj;
        zzdsf.removeCallbacks(this);
        zzdsf.postDelayed(this, 250);
    }

    public final void pause() {
        this.zzbsq = true;
        this.zzegi.zzzg();
    }

    public final void resume() {
        this.zzbsq = false;
        zzzx();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.zzbsq) {
            this.zzegi.zzzg();
            zzzx();
        }
    }
}
