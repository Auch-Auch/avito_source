package com.google.android.gms.internal.measurement;

import java.io.Serializable;
public final class zzfi extends zzfk<Comparable> implements Serializable {
    public static final zzfi zza = new zzfi();

    private zzfi() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        zzdq.zza(comparable);
        zzdq.zza(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // java.lang.Object
    public final String toString() {
        return "Ordering.natural()";
    }
}
