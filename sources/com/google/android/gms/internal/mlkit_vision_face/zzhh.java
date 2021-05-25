package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
import java.util.Map;
public final class zzhh implements zzhi {
    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhi
    public final zzhg<?, ?> zza(Object obj) {
        zzhd zzhd = (zzhd) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhi
    public final Map<?, ?> zzb(Object obj) {
        return (zzhf) obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhi
    public final Object zzc(Object obj) {
        ((zzhf) obj).zzb();
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhi
    public final Object zza(Object obj, Object obj2) {
        zzhf zzhf = (zzhf) obj;
        zzhf zzhf2 = (zzhf) obj2;
        if (!zzhf2.isEmpty()) {
            if (!zzhf.zzc()) {
                zzhf = zzhf.zza();
            }
            zzhf.zza(zzhf2);
        }
        return zzhf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhi
    public final int zza(int i, Object obj, Object obj2) {
        zzhf zzhf = (zzhf) obj;
        zzhd zzhd = (zzhd) obj2;
        if (zzhf.isEmpty()) {
            return 0;
        }
        Iterator it = zzhf.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
