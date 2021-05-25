package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public final class zzelt<T> implements zzelo<Set<T>> {
    private static final zzelo<Set<Object>> zzirf = zzeln.zzba(Collections.emptySet());
    private final List<zzelx<T>> zzirg;
    private final List<zzelx<Collection<T>>> zzirh;

    private zzelt(List<zzelx<T>> list, List<zzelx<Collection<T>>> list2) {
        this.zzirg = list;
        this.zzirh = list2;
    }

    public static <T> zzelv<T> zzar(int i, int i2) {
        return new zzelv<>(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        int size = this.zzirg.size();
        ArrayList arrayList = new ArrayList(this.zzirh.size());
        int size2 = this.zzirh.size();
        for (int i = 0; i < size2; i++) {
            Collection<T> collection = this.zzirh.get(i).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zzhz = zzelj.zzhz(size);
        int size3 = this.zzirg.size();
        for (int i2 = 0; i2 < size3; i2++) {
            zzhz.add(zzelu.checkNotNull(this.zzirg.get(i2).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object obj : (Collection) arrayList.get(i3)) {
                zzhz.add(zzelu.checkNotNull(obj));
            }
        }
        return Collections.unmodifiableSet(zzhz);
    }
}
