package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;
public final class zzo extends WeakReference<Throwable> {
    private final int zza;

    public zzo(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zza = System.identityHashCode(th);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzo.class) {
            if (this == obj) {
                return true;
            }
            zzo zzo = (zzo) obj;
            if (this.zza == zzo.zza && get() == zzo.get()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.zza;
    }
}
