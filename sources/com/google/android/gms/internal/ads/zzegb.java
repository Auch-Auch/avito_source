package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
import java.io.IOException;
import java.util.List;
import java.util.Map;
public final class zzegb implements zzekk {
    private final zzefz zzibi;

    private zzegb(zzefz zzefz) {
        zzefz zzefz2 = (zzefz) zzegr.zza(zzefz, "output");
        this.zzibi = zzefz2;
        zzefz2.zzich = this;
    }

    public static zzegb zza(zzefz zzefz) {
        zzegb zzegb = zzefz.zzich;
        if (zzegb != null) {
            return zzegb;
        }
        return new zzegb(zzefz);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzab(int i, int i2) throws IOException {
        this.zzibi.zzab(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzac(int i, int i2) throws IOException {
        this.zzibi.zzac(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzad(int i, int i2) throws IOException {
        this.zzibi.zzad(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzae(int i, int i2) throws IOException {
        this.zzibi.zzae(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzal(int i, int i2) throws IOException {
        this.zzibi.zzae(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzam(int i, int i2) throws IOException {
        this.zzibi.zzab(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzb(int i, double d) throws IOException {
        this.zzibi.zzb(i, d);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final int zzbew() {
        return zzegp.zze.zzigh;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzc(int i, Object obj) throws IOException {
        if (obj instanceof zzeff) {
            this.zzibi.zzb(i, (zzeff) obj);
        } else {
            this.zzibi.zza(i, (zzehz) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzfm(list.get(i4).longValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzfo(list.get(i4).longValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzfk(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzg(list.get(i4).floatValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzf(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzc(list.get(i4).doubleValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzgz(int i) throws IOException {
        this.zzibi.writeTag(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzh(int i, long j) throws IOException {
        this.zzibi.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzha(int i) throws IOException {
        this.zzibi.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzi(int i, String str) throws IOException {
        this.zzibi.zzi(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzj(int i, long j) throws IOException {
        this.zzibi.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzgv(list.get(i4).intValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzgp(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzfp(list.get(i4).longValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzfk(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzgt(list.get(i4).intValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzgo(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzad(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzfn(list.get(i4).longValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzp(int i, long j) throws IOException {
        this.zzibi.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzq(int i, long j) throws IOException {
        this.zzibi.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzb(int i, Object obj, zzeiv zzeiv) throws IOException {
        zzefz zzefz = this.zzibi;
        zzefz.writeTag(i, 3);
        zzeiv.zza((zzehz) obj, zzefz.zzich);
        zzefz.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzh(int i, boolean z) throws IOException {
        this.zzibi.zzh(i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzi(int i, long j) throws IOException {
        this.zzibi.zzi(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzgs(list.get(i4).intValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzgn(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzac(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zza(int i, float f) throws IOException {
        this.zzibi.zza(i, f);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzgw(list.get(i4).intValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzgm(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzab(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzbt(list.get(i4).booleanValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzbs(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzh(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zza(int i, zzeff zzeff) throws IOException {
        this.zzibi.zza(i, zzeff);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzfl(list.get(i4).longValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zza(int i, Object obj, zzeiv zzeiv) throws IOException {
        this.zzibi.zza(i, (zzehz) obj, zzeiv);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzgr(list.get(i4).intValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzgm(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzab(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzibi.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzefz.zzgu(list.get(i4).intValue());
            }
            this.zzibi.zzgn(i3);
            while (i2 < list.size()) {
                this.zzibi.zzgp(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzehk) {
            zzehk zzehk = (zzehk) list;
            while (i2 < list.size()) {
                Object zzhe = zzehk.zzhe(i2);
                if (zzhe instanceof String) {
                    this.zzibi.zzi(i, (String) zzhe);
                } else {
                    this.zzibi.zza(i, (zzeff) zzhe);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzibi.zzi(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzb(int i, List<zzeff> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzibi.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zzb(int i, List<?> list, zzeiv zzeiv) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzeiv);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zza(int i, List<?> list, zzeiv zzeiv) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzeiv);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final <K, V> void zza(int i, zzehu<K, V> zzehu, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzibi.writeTag(i, 2);
            this.zzibi.zzgn(zzehr.zza(zzehu, entry.getKey(), entry.getValue()));
            zzehr.zza(this.zzibi, zzehu, entry.getKey(), entry.getValue());
        }
    }
}
