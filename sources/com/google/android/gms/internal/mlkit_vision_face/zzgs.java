package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Map;
public final class zzgs<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzgq> zza;

    private zzgs(Map.Entry<K, zzgq> entry) {
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
        return zzgq.zza();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzhl) {
            return this.zza.getValue().zza((zzhl) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzgq zza() {
        return this.zza.getValue();
    }
}
