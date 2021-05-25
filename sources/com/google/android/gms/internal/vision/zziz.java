package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class zziz extends zzix {
    private static final Class<?> zzzw = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zziz() {
        super();
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzld.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzld.zzp(obj, j);
        if (list instanceof zziu) {
            obj2 = ((zziu) list).zzht();
        } else if (!zzzw.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzjz) || !(list instanceof zzik)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzik zzik = (zzik) list;
                if (zzik.zzei()) {
                    zzik.zzej();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzld.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zziv zziv;
        List<L> list;
        List<L> zzd = zzd(obj, j);
        if (zzd.isEmpty()) {
            if (zzd instanceof zziu) {
                list = new zziv(i);
            } else if (!(zzd instanceof zzjz) || !(zzd instanceof zzik)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzik) zzd).zzan(i);
            }
            zzld.zza(obj, j, list);
            return list;
        }
        if (zzzw.isAssignableFrom(zzd.getClass())) {
            ArrayList arrayList = new ArrayList(zzd.size() + i);
            arrayList.addAll(zzd);
            zzld.zza(obj, j, arrayList);
            zziv = arrayList;
        } else if (zzd instanceof zzky) {
            zziv zziv2 = new zziv(zzd.size() + i);
            zziv2.addAll((zzky) zzd);
            zzld.zza(obj, j, zziv2);
            zziv = zziv2;
        } else if (!(zzd instanceof zzjz) || !(zzd instanceof zzik)) {
            return zzd;
        } else {
            zzik zzik = (zzik) zzd;
            if (zzik.zzei()) {
                return zzd;
            }
            zzik zzan = zzik.zzan(zzd.size() + i);
            zzld.zza(obj, j, zzan);
            return zzan;
        }
        return zziv;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzd = zzd(obj2, j);
        List zza = zza(obj, j, zzd.size());
        int size = zza.size();
        int size2 = zzd.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzd);
        }
        if (size > 0) {
            zzd = zza;
        }
        zzld.zza(obj, j, zzd);
    }
}
