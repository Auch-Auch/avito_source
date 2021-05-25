package com.google.android.gms.internal.gtm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;
public final class zzpi extends WeakReference<Throwable> {
    private final int zzavn;

    public zzpi(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zzavn = System.identityHashCode(th);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzpi.class) {
            if (this == obj) {
                return true;
            }
            zzpi zzpi = (zzpi) obj;
            if (this.zzavn == zzpi.zzavn && get() == zzpi.get()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.zzavn;
    }
}
