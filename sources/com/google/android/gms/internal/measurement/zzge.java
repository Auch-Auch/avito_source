package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;
public final class zzge extends WeakReference<Throwable> {
    private final int zza;

    public zzge(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zza = System.identityHashCode(th);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzge.class) {
            if (this == obj) {
                return true;
            }
            zzge zzge = (zzge) obj;
            if (this.zza == zzge.zza && get() == zzge.get()) {
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
