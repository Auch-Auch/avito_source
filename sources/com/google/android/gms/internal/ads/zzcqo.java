package com.google.android.gms.internal.ads;
public final class zzcqo implements zzbsz, zzbuj {
    private static final Object zzgjy = new Object();
    private static int zzgjz;
    private final zzcqt zzgka;

    public zzcqo(zzcqt zzcqt) {
        this.zzgka = zzcqt;
    }

    private static boolean zzapn() {
        boolean z;
        synchronized (zzgjy) {
            z = zzgjz < ((Integer) zzwe.zzpu().zzd(zzaat.zzcvy)).intValue();
        }
        return z;
    }

    private final void zzbk(boolean z) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvx)).booleanValue() && zzapn()) {
            this.zzgka.zzbk(z);
            synchronized (zzgjy) {
                zzgjz++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        zzbk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzg(zzuw zzuw) {
        zzbk(false);
    }
}
