package com.google.android.gms.internal.ads;

import java.io.IOException;
public final class zzejp extends zzejn<zzejq, zzejq> {
    private static void zza(Object obj, zzejq zzejq) {
        ((zzegp) obj).zzifo = zzejq;
    }

    @Override // com.google.android.gms.internal.ads.zzejn
    public final boolean zza(zzeip zzeip) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzejn
    public final void zzaj(Object obj) {
        ((zzegp) obj).zzifo.zzbdg();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ zzejq zzar(zzejq zzejq) {
        zzejq zzejq2 = zzejq;
        zzejq2.zzbdg();
        return zzejq2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ int zzat(zzejq zzejq) {
        return zzejq.zzbfl();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ zzejq zzax(Object obj) {
        return ((zzegp) obj).zzifo;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ zzejq zzay(Object obj) {
        zzejq zzejq = ((zzegp) obj).zzifo;
        if (zzejq != zzejq.zzbhz()) {
            return zzejq;
        }
        zzejq zzbia = zzejq.zzbia();
        zza(obj, zzbia);
        return zzbia;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ int zzaz(zzejq zzejq) {
        return zzejq.zzbib();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ void zzb(zzejq zzejq, int i, long j) {
        zzejq.zzd((i << 3) | 1, Long.valueOf(j));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ zzejq zzbhy() {
        return zzejq.zzbia();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.android.gms.internal.ads.zzekk] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ void zzc(zzejq zzejq, zzekk zzekk) throws IOException {
        zzejq.zza(zzekk);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ void zzi(Object obj, zzejq zzejq) {
        zza(obj, zzejq);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ void zzj(Object obj, zzejq zzejq) {
        zza(obj, zzejq);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ zzejq zzk(zzejq zzejq, zzejq zzejq2) {
        zzejq zzejq3 = zzejq;
        zzejq zzejq4 = zzejq2;
        if (zzejq4.equals(zzejq.zzbhz())) {
            return zzejq3;
        }
        return zzejq.zza(zzejq3, zzejq4);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.android.gms.internal.ads.zzekk] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ void zza(zzejq zzejq, zzekk zzekk) throws IOException {
        zzejq.zzb(zzekk);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ void zzc(zzejq zzejq, int i, int i2) {
        zzejq.zzd((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ void zza(zzejq zzejq, int i, zzejq zzejq2) {
        zzejq.zzd((i << 3) | 3, zzejq2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, com.google.android.gms.internal.ads.zzeff] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ void zza(zzejq zzejq, int i, zzeff zzeff) {
        zzejq.zzd((i << 3) | 2, zzeff);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // com.google.android.gms.internal.ads.zzejn
    public final /* synthetic */ void zza(zzejq zzejq, int i, long j) {
        zzejq.zzd(i << 3, Long.valueOf(j));
    }
}
