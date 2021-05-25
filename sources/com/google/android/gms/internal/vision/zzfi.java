package com.google.android.gms.internal.vision;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;
public final class zzfi extends WeakReference<Throwable> {
    private final int zzoc;

    public zzfi(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zzoc = System.identityHashCode(th);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzfi.class) {
            if (this == obj) {
                return true;
            }
            zzfi zzfi = (zzfi) obj;
            if (this.zzoc == zzfi.zzoc && get() == zzfi.get()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.zzoc;
    }
}
