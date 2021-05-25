package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;
public final class zzjj implements zzjg {
    @Override // com.google.android.gms.internal.vision.zzjg
    public final int zzb(int i, Object obj, Object obj2) {
        zzjh zzjh = (zzjh) obj;
        zzjf zzjf = (zzjf) obj2;
        if (zzjh.isEmpty()) {
            return 0;
        }
        Iterator it = zzjh.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.vision.zzjg
    public final Object zzc(Object obj, Object obj2) {
        zzjh zzjh = (zzjh) obj;
        zzjh zzjh2 = (zzjh) obj2;
        if (!zzjh2.isEmpty()) {
            if (!zzjh.isMutable()) {
                zzjh = zzjh.zzhy();
            }
            zzjh.zza(zzjh2);
        }
        return zzjh;
    }

    @Override // com.google.android.gms.internal.vision.zzjg
    public final Map<?, ?> zzn(Object obj) {
        return (zzjh) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzjg
    public final Map<?, ?> zzo(Object obj) {
        return (zzjh) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzjg
    public final boolean zzp(Object obj) {
        return !((zzjh) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.vision.zzjg
    public final Object zzq(Object obj) {
        ((zzjh) obj).zzej();
        return obj;
    }

    @Override // com.google.android.gms.internal.vision.zzjg
    public final Object zzr(Object obj) {
        return zzjh.zzhx().zzhy();
    }

    @Override // com.google.android.gms.internal.vision.zzjg
    public final zzje<?, ?> zzs(Object obj) {
        zzjf zzjf = (zzjf) obj;
        throw new NoSuchMethodError();
    }
}
