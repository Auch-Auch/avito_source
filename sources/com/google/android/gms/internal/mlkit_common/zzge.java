package com.google.android.gms.internal.mlkit_common;

import java.util.Map;
public final class zzge<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzgc> zza;

    private zzge(Map.Entry<K, zzgc> entry) {
        this.zza = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzgc.zza();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzhb) {
            return this.zza.getValue().zza((zzhb) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzgc zza() {
        return this.zza.getValue();
    }
}
