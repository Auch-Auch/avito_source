package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
public final class zzehv implements zzehw {
    @Override // com.google.android.gms.internal.ads.zzehw
    public final Map<?, ?> zzan(Object obj) {
        return (zzeht) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzehw
    public final zzehu<?, ?> zzao(Object obj) {
        zzehr zzehr = (zzehr) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzehw
    public final Map<?, ?> zzap(Object obj) {
        return (zzeht) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzehw
    public final boolean zzaq(Object obj) {
        return !((zzeht) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.ads.zzehw
    public final Object zzar(Object obj) {
        ((zzeht) obj).zzbdg();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzehw
    public final Object zzas(Object obj) {
        return zzeht.zzbgt().zzbgu();
    }

    @Override // com.google.android.gms.internal.ads.zzehw
    public final int zzb(int i, Object obj, Object obj2) {
        zzeht zzeht = (zzeht) obj;
        zzehr zzehr = (zzehr) obj2;
        if (zzeht.isEmpty()) {
            return 0;
        }
        Iterator it = zzeht.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzehw
    public final Object zzf(Object obj, Object obj2) {
        zzeht zzeht = (zzeht) obj;
        zzeht zzeht2 = (zzeht) obj2;
        if (!zzeht2.isEmpty()) {
            if (!zzeht.isMutable()) {
                zzeht = zzeht.zzbgu();
            }
            zzeht.zza(zzeht2);
        }
        return zzeht;
    }
}
