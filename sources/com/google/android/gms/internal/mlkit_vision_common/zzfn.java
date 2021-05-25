package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.Map;
public final class zzfn implements zzfo {
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfo
    public final zzfm<?, ?> zza(Object obj) {
        zzfj zzfj = (zzfj) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfo
    public final Map<?, ?> zzb(Object obj) {
        return (zzfl) obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfo
    public final Object zzc(Object obj) {
        ((zzfl) obj).zzb();
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfo
    public final Object zza(Object obj, Object obj2) {
        zzfl zzfl = (zzfl) obj;
        zzfl zzfl2 = (zzfl) obj2;
        if (!zzfl2.isEmpty()) {
            if (!zzfl.zzc()) {
                zzfl = zzfl.zza();
            }
            zzfl.zza(zzfl2);
        }
        return zzfl;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfo
    public final int zza(int i, Object obj, Object obj2) {
        zzfl zzfl = (zzfl) obj;
        zzfj zzfj = (zzfj) obj2;
        if (zzfl.isEmpty()) {
            return 0;
        }
        Iterator it = zzfl.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
