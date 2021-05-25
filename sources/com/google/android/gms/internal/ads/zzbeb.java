package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
public final class zzbeb implements zzhf, zzmy, zzpa<zzom>, zzqd {
    @VisibleForTesting
    private static int zzeju;
    @VisibleForTesting
    private static int zzejv;
    private int bytesTransferred;
    private final zzbdf zzeiw;
    private final zzbdy zzejw;
    private final zzhx zzejx;
    private final zzhx zzejy;
    private final zzoa zzejz;
    private zzhc zzeka;
    private ByteBuffer zzekb;
    private boolean zzekc;
    private zzbei zzekd;
    private Set<WeakReference<zzbdu>> zzeke = new HashSet();
    private final Context zzvr;

    public zzbeb(Context context, zzbdf zzbdf) {
        this.zzvr = context;
        this.zzeiw = zzbdf;
        zzbdy zzbdy = new zzbdy();
        this.zzejw = zzbdy;
        zzlw zzlw = zzlw.zzbcs;
        zzpx zzpx = new zzpx(context, zzlw, 0, zzayh.zzeaj, this, -1);
        this.zzejx = zzpx;
        zzjb zzjb = new zzjb(zzlw);
        this.zzejy = zzjb;
        zznv zznv = new zznv();
        this.zzejz = zznv;
        if (zzaxy.zzww()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(valueOf.length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzaxy.zzei(sb.toString());
        }
        zzeju++;
        zzhc zza = zzhg.zza(new zzhx[]{zzjb, zzpx}, zznv, zzbdy);
        this.zzeka = zza;
        zza.zza(this);
    }

    public static int zzaar() {
        return zzeju;
    }

    public static int zzaas() {
        return zzejv;
    }

    public final void finalize() throws Throwable {
        zzeju--;
        if (zzaxy.zzww()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(valueOf.length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzaxy.zzei(sb.toString());
        }
    }

    public final long getBytesTransferred() {
        return (long) this.bytesTransferred;
    }

    public final void release() {
        zzhc zzhc = this.zzeka;
        if (zzhc != null) {
            zzhc.zzb(this);
            this.zzeka.release();
            this.zzeka = null;
            zzejv--;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zza(Surface surface) {
    }

    public final void zza(zzbei zzbei) {
        this.zzekd = zzbei;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(zzhu zzhu) {
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(zzhy zzhy, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(zznp zznp, zzod zzod) {
    }

    public final zzhc zzaaq() {
        return this.zzeka;
    }

    public final zzbdy zzaat() {
        return this.zzejw;
    }

    public final void zzaw(boolean z) {
        if (this.zzeka != null) {
            for (int i = 0; i < this.zzeka.zzej(); i++) {
                this.zzejz.zzf(i, !z);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void zzb(IOException iOException) {
        zzbei zzbei = this.zzekd;
        if (zzbei != null) {
            zzbei.zza("onLoadError", iOException);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* synthetic */ void zzc(zzom zzom, int i) {
        this.bytesTransferred += i;
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zzd(String str, long j, long j2) {
    }

    public final /* synthetic */ void zzd(boolean z, long j) {
        zzbei zzbei = this.zzekd;
        if (zzbei != null) {
            zzbei.zzb(z, j);
        }
    }

    public final void zzdp(int i) {
        for (WeakReference<zzbdu> weakReference : this.zzeke) {
            zzbdu zzbdu = weakReference.get();
            if (zzbdu != null) {
                zzbdu.setReceiveBufferSize(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zze(int i, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zze(zzjl zzjl) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* bridge */ /* synthetic */ void zze(zzom zzom) {
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zzel() {
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zzf(zzjl zzjl) {
    }

    public final /* synthetic */ zzom zzfl(String str) {
        zzbdf zzbdf = this.zzeiw;
        return new zzop(str, null, zzbdf.zzeid ? null : this, zzbdf.zzehx, zzbdf.zzehz, true, null);
    }

    public final /* synthetic */ zzom zzfm(String str) {
        zzbdf zzbdf = this.zzeiw;
        zzbdu zzbdu = new zzbdu(str, zzbdf.zzeid ? null : this, zzbdf.zzehx, zzbdf.zzehz, zzbdf.zzeic);
        this.zzeke.add(new WeakReference<>(zzbdu));
        return zzbdu;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zzg(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zzk(zzho zzho) {
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzmz zzmz;
        if (this.zzeka != null) {
            this.zzekb = byteBuffer;
            this.zzekc = z;
            if (uriArr.length == 1) {
                zzmz = zzb(uriArr[0], str);
            } else {
                zzmz[] zzmzArr = new zzmz[uriArr.length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzmzArr[i] = zzb(uriArr[i], str);
                }
                zzmz = new zzne(zzmzArr);
            }
            this.zzeka.zza(zzmz);
            zzejv++;
        }
    }

    public final void zzb(float f, boolean z) {
        if (this.zzeka != null) {
            zzhh zzhh = new zzhh(this.zzejy, 2, Float.valueOf(f));
            if (z) {
                this.zzeka.zzb(zzhh);
            } else {
                this.zzeka.zza(zzhh);
            }
        }
    }

    @VisibleForTesting
    private final zzmz zzb(Uri uri, String str) {
        zzol zzol;
        zzka zzka;
        if (!this.zzekc || this.zzekb.limit() <= 0) {
            if (this.zzeiw.zzeic > 0) {
                zzol = new zzol(this, str) { // from class: com.google.android.gms.internal.ads.zzbed
                    private final String zzdft;
                    private final zzbeb zzekf;

                    {
                        this.zzekf = r1;
                        this.zzdft = r2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzol
                    public final zzom zzin() {
                        return this.zzekf.zzfm(this.zzdft);
                    }
                };
            } else {
                zzol = new zzol(this, str) { // from class: com.google.android.gms.internal.ads.zzbec
                    private final String zzdft;
                    private final zzbeb zzekf;

                    {
                        this.zzekf = r1;
                        this.zzdft = r2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzol
                    public final zzom zzin() {
                        return this.zzekf.zzfl(this.zzdft);
                    }
                };
            }
            if (this.zzeiw.zzeid) {
                zzol = new zzol(this, zzol) { // from class: com.google.android.gms.internal.ads.zzbef
                    private final zzbeb zzekf;
                    private final zzol zzekh;

                    {
                        this.zzekf = r1;
                        this.zzekh = r2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzol
                    public final zzom zzin() {
                        return this.zzekf.zza(this.zzekh);
                    }
                };
            }
            if (this.zzekb.limit() > 0) {
                byte[] bArr = new byte[this.zzekb.limit()];
                this.zzekb.get(bArr);
                zzol = new zzol(zzol, bArr) { // from class: com.google.android.gms.internal.ads.zzbee
                    private final byte[] zzdtc;
                    private final zzol zzekg;

                    {
                        this.zzekg = r1;
                        this.zzdtc = r2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzol
                    public final zzom zzin() {
                        zzol zzol2 = this.zzekg;
                        byte[] bArr2 = this.zzdtc;
                        return new zzbel(new zzoj(bArr2), bArr2.length, zzol2.zzin());
                    }
                };
            }
        } else {
            byte[] bArr2 = new byte[this.zzekb.limit()];
            this.zzekb.get(bArr2);
            zzol = new zzol(bArr2) { // from class: com.google.android.gms.internal.ads.zzbea
                private final byte[] zzedn;

                {
                    this.zzedn = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzol
                public final zzom zzin() {
                    return new zzoj(this.zzedn);
                }
            };
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzclv)).booleanValue()) {
            zzka = zzbeh.zzeki;
        } else {
            zzka = zzbeg.zzeki;
        }
        zzbdf zzbdf = this.zzeiw;
        return new zzmv(uri, zzol, zzka, zzbdf.zzeie, zzayh.zzeaj, this, null, zzbdf.zzeia);
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zza(int i, int i2, int i3, float f) {
        zzbei zzbei = this.zzekd;
        if (zzbei != null) {
            zzbei.zzn(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(boolean z, int i) {
        zzbei zzbei = this.zzekd;
        if (zzbei != null) {
            zzbei.zzdq(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zza(zzhd zzhd) {
        zzbei zzbei = this.zzekd;
        if (zzbei != null) {
            zzbei.zza("onPlayerError", zzhd);
        }
    }

    public final void zza(Surface surface, boolean z) {
        if (this.zzeka != null) {
            zzhh zzhh = new zzhh(this.zzejx, 1, surface);
            if (z) {
                this.zzeka.zzb(zzhh);
            } else {
                this.zzeka.zza(zzhh);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.android.gms.internal.ads.zzon] */
    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* synthetic */ void zza(zzom zzom, zzon zzon) {
        this.bytesTransferred = 0;
    }

    public final /* synthetic */ zzom zza(zzol zzol) {
        return new zzbdw(this.zzvr, zzol.zzin(), this, new zzbdz(this) { // from class: com.google.android.gms.internal.ads.zzbej
            private final zzbeb zzekf;

            {
                this.zzekf = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbdz
            public final void zzb(boolean z, long j) {
                this.zzekf.zzd(z, j);
            }
        });
    }
}
