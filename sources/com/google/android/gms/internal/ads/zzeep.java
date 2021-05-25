package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;
public final class zzeep extends WeakReference<Throwable> {
    private final int zziaj;

    public zzeep(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zziaj = System.identityHashCode(th);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzeep.class) {
            if (this == obj) {
                return true;
            }
            zzeep zzeep = (zzeep) obj;
            if (this.zziaj == zzeep.zziaj && get() == zzeep.get()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.zziaj;
    }
}
