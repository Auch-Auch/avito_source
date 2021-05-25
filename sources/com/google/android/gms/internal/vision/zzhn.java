package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;
public final class zzhn implements zzlq {
    private final zzhl zztz;

    private zzhn(zzhl zzhl) {
        zzhl zzhl2 = (zzhl) zzie.zza(zzhl, "output");
        this.zztz = zzhl2;
        zzhl2.zzuo = this;
    }

    public static zzhn zza(zzhl zzhl) {
        zzhn zzhn = zzhl.zzuo;
        if (zzhn != null) {
            return zzhn;
        }
        return new zzhn(zzhl);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzb(int i, long j) throws IOException {
        this.zztz.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzbq(int i) throws IOException {
        this.zztz.writeTag(i, 3);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzbr(int i) throws IOException {
        this.zztz.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzc(int i, long j) throws IOException {
        this.zztz.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzw(list.get(i4).longValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzs(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzy(list.get(i4).longValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzu(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzt(list.get(i4).floatValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzs(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzb(list.get(i4).doubleValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final int zzgd() {
        return zzlt.zzaex;
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzbn(list.get(i4).intValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzbd(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzi(int i, long j) throws IOException {
        this.zztz.zza(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzj(int i, long j) throws IOException {
        this.zztz.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzk(int i, int i2) throws IOException {
        this.zztz.zzk(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzl(int i, int i2) throws IOException {
        this.zztz.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzm(int i, int i2) throws IOException {
        this.zztz.zzm(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzx(list.get(i4).longValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzt(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzt(int i, int i2) throws IOException {
        this.zztz.zzm(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzu(int i, int i2) throws IOException {
        this.zztz.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzb(int i, Object obj, zzkf zzkf) throws IOException {
        zzhl zzhl = this.zztz;
        zzhl.writeTag(i, 3);
        zzkf.zza((zzjn) obj, zzhl.zzuo);
        zzhl.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzv(list.get(i4).longValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzs(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzbm(list.get(i4).intValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzbg(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zzm(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzz(list.get(i4).longValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzu(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzbk(list.get(i4).intValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzbf(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zzl(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, float f) throws IOException {
        this.zztz.zza(i, f);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzl(list.get(i4).booleanValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzk(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzj(int i, int i2) throws IOException {
        this.zztz.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, double d) throws IOException {
        this.zztz.zza(i, d);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzbj(list.get(i4).intValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzbe(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zzk(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, long j) throws IOException {
        this.zztz.zza(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, boolean z) throws IOException {
        this.zztz.zza(i, z);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzbl(list.get(i4).intValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzbg(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zzm(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, String str) throws IOException {
        this.zztz.zza(i, str);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, zzgs zzgs) throws IOException {
        this.zztz.zza(i, zzgs);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, Object obj, zzkf zzkf) throws IOException {
        this.zztz.zza(i, (zzjn) obj, zzkf);
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzgs) {
            this.zztz.zzb(i, (zzgs) obj);
        } else {
            this.zztz.zza(i, (zzjn) obj);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zztz.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhl.zzbi(list.get(i4).intValue());
            }
            this.zztz.zzbe(i3);
            while (i2 < list.size()) {
                this.zztz.zzbd(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzb(int i, List<zzgs> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zztz.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zzb(int i, List<?> list, zzkf zzkf) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzkf);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            while (i2 < list.size()) {
                Object zzbt = zziu.zzbt(i2);
                if (zzbt instanceof String) {
                    this.zztz.zza(i, (String) zzbt);
                } else {
                    this.zztz.zza(i, (zzgs) zzbt);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zztz.zza(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final void zza(int i, List<?> list, zzkf zzkf) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzkf);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlq
    public final <K, V> void zza(int i, zzje<K, V> zzje, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zztz.writeTag(i, 2);
            this.zztz.zzbe(zzjf.zza(zzje, entry.getKey(), entry.getValue()));
            zzjf.zza(this.zztz, zzje, entry.getKey(), entry.getValue());
        }
    }
}
