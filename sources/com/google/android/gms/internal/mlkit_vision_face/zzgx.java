package com.google.android.gms.internal.mlkit_vision_face;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class zzgx extends zzgv {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgx() {
        super();
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zziz.zzf(obj, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzgv
    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zziz.zzf(obj, j);
        if (list instanceof zzgw) {
            obj2 = ((zzgw) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzhy) || !(list instanceof zzgm)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzgm zzgm = (zzgm) list;
                if (zzgm.zza()) {
                    zzgm.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zziz.zza(obj, j, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzgv
    public final <E> void zza(Object obj, Object obj2, long j) {
        ArrayList arrayList;
        List zzb = zzb(obj2, j);
        int size = zzb.size();
        List zzb2 = zzb(obj, j);
        if (zzb2.isEmpty()) {
            if (zzb2 instanceof zzgw) {
                zzb2 = new zzgt(size);
            } else if (!(zzb2 instanceof zzhy) || !(zzb2 instanceof zzgm)) {
                zzb2 = new ArrayList(size);
            } else {
                zzb2 = ((zzgm) zzb2).zzb(size);
            }
            zziz.zza(obj, j, zzb2);
        } else {
            if (zza.isAssignableFrom(zzb2.getClass())) {
                ArrayList arrayList2 = new ArrayList(zzb2.size() + size);
                arrayList2.addAll(zzb2);
                zziz.zza(obj, j, arrayList2);
                arrayList = arrayList2;
            } else if (zzb2 instanceof zziy) {
                zzgt zzgt = new zzgt(zzb2.size() + size);
                zzgt.addAll((zziy) zzb2);
                zziz.zza(obj, j, zzgt);
                arrayList = zzgt;
            } else if ((zzb2 instanceof zzhy) && (zzb2 instanceof zzgm)) {
                zzgm zzgm = (zzgm) zzb2;
                if (!zzgm.zza()) {
                    zzb2 = zzgm.zzb(zzb2.size() + size);
                    zziz.zza(obj, j, zzb2);
                }
            }
            zzb2 = arrayList;
        }
        int size2 = zzb2.size();
        int size3 = zzb.size();
        if (size2 > 0 && size3 > 0) {
            zzb2.addAll(zzb);
        }
        if (size2 > 0) {
            zzb = zzb2;
        }
        zziz.zza(obj, j, zzb);
    }
}
