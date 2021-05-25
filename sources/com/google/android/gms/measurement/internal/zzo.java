package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;
public final class zzo extends zzkl {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzq> zzd;
    private Long zze;
    private Long zzf;

    public zzo(zzkk zzkk) {
        super(zzkk);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0634, code lost:
        r7 = zzr().zzi();
        r9 = com.google.android.gms.measurement.internal.zzez.zza(r46.zzb);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0646, code lost:
        if (r8.zza() == false) goto L_0x0651;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0648, code lost:
        r8 = java.lang.Integer.valueOf(r8.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0651, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0652, code lost:
        r7.zza("Invalid property filter ID. appId, id", r9, java.lang.String.valueOf(r8));
        r8 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x02d2 A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzcc.zza> zza(java.lang.String r47, java.util.List<com.google.android.gms.internal.measurement.zzcc.zzc> r48, java.util.List<com.google.android.gms.internal.measurement.zzcc.zzk> r49, java.lang.Long r50, java.lang.Long r51) {
        /*
        // Method dump skipped, instructions count: 1806
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzo.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    @Override // com.google.android.gms.measurement.internal.zzkl
    public final boolean zze() {
        return false;
    }

    private final zzq zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzq zzq = new zzq(this, this.zzb, null);
        this.zzd.put(Integer.valueOf(i), zzq);
        return zzq;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return zzq.zza(this.zzd.get(Integer.valueOf(i))).get(i2);
    }
}
