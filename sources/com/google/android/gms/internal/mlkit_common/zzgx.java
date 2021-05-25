package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Map;
public final class zzgx implements zzgu {
    @Override // com.google.android.gms.internal.mlkit_common.zzgu
    public final Map<?, ?> zza(Object obj) {
        return (zzgv) obj;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgu
    public final Object zzb(Object obj) {
        ((zzgv) obj).zzb();
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgu
    public final zzgs<?, ?> zzc(Object obj) {
        zzgt zzgt = (zzgt) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgu
    public final Object zza(Object obj, Object obj2) {
        zzgv zzgv = (zzgv) obj;
        zzgv zzgv2 = (zzgv) obj2;
        if (!zzgv2.isEmpty()) {
            if (!zzgv.zzc()) {
                zzgv = zzgv.zza();
            }
            zzgv.zza(zzgv2);
        }
        return zzgv;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgu
    public final int zza(int i, Object obj, Object obj2) {
        zzgv zzgv = (zzgv) obj;
        zzgt zzgt = (zzgt) obj2;
        if (zzgv.isEmpty()) {
            return 0;
        }
        Iterator it = zzgv.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
