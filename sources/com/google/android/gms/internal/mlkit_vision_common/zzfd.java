package com.google.android.gms.internal.mlkit_vision_common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class zzfd extends zzfb {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzfd() {
        super();
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zzhf.zzf(obj, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfb
    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzhf.zzf(obj, j);
        if (list instanceof zzfc) {
            obj2 = ((zzfc) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzge) || !(list instanceof zzes)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzes zzes = (zzes) list;
                if (zzes.zza()) {
                    zzes.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzhf.zza(obj, j, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfb
    public final <E> void zza(Object obj, Object obj2, long j) {
        ArrayList arrayList;
        List zzb = zzb(obj2, j);
        int size = zzb.size();
        List zzb2 = zzb(obj, j);
        if (zzb2.isEmpty()) {
            if (zzb2 instanceof zzfc) {
                zzb2 = new zzez(size);
            } else if (!(zzb2 instanceof zzge) || !(zzb2 instanceof zzes)) {
                zzb2 = new ArrayList(size);
            } else {
                zzb2 = ((zzes) zzb2).zzb(size);
            }
            zzhf.zza(obj, j, zzb2);
        } else {
            if (zza.isAssignableFrom(zzb2.getClass())) {
                ArrayList arrayList2 = new ArrayList(zzb2.size() + size);
                arrayList2.addAll(zzb2);
                zzhf.zza(obj, j, arrayList2);
                arrayList = arrayList2;
            } else if (zzb2 instanceof zzhe) {
                zzez zzez = new zzez(zzb2.size() + size);
                zzez.addAll((zzhe) zzb2);
                zzhf.zza(obj, j, zzez);
                arrayList = zzez;
            } else if ((zzb2 instanceof zzge) && (zzb2 instanceof zzes)) {
                zzes zzes = (zzes) zzb2;
                if (!zzes.zza()) {
                    zzb2 = zzes.zzb(zzb2.size() + size);
                    zzhf.zza(obj, j, zzb2);
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
        zzhf.zza(obj, j, zzb);
    }
}
