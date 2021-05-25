package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import java.util.Map;
@KeepForSdk
public abstract class LazyInstanceMap<K, V> {
    @GuardedBy("instances")
    private final Map<K, V> zza = new HashMap();

    @KeepForSdk
    public abstract V create(K k);

    @KeepForSdk
    public V get(K k) {
        synchronized (this.zza) {
            if (this.zza.containsKey(k)) {
                return this.zza.get(k);
            }
            V create = create(k);
            this.zza.put(k, create);
            return create;
        }
    }
}
