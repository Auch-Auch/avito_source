package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class zzehl extends zzehj {
    private static final Class<?> zzihn = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzehl() {
        super();
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzejt.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.ads.zzehj
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzehj
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzejt.zzp(obj, j);
        if (list instanceof zzehk) {
            obj2 = ((zzehk) list).zzbgo();
        } else if (!zzihn.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzeil) || !(list instanceof zzeha)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzeha zzeha = (zzeha) list;
                if (zzeha.zzbdf()) {
                    zzeha.zzbdg();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzejt.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzehh zzehh;
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zzehk) {
                list = new zzehh(i);
            } else if (!(zzc instanceof zzeil) || !(zzc instanceof zzeha)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzeha) zzc).zzft(i);
            }
            zzejt.zza(obj, j, list);
            return list;
        }
        if (zzihn.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zzejt.zza(obj, j, arrayList);
            zzehh = arrayList;
        } else if (zzc instanceof zzejs) {
            zzehh zzehh2 = new zzehh(zzc.size() + i);
            zzehh2.addAll((zzejs) zzc);
            zzejt.zza(obj, j, zzehh2);
            zzehh = zzehh2;
        } else if (!(zzc instanceof zzeil) || !(zzc instanceof zzeha)) {
            return zzc;
        } else {
            zzeha zzeha = (zzeha) zzc;
            if (zzeha.zzbdf()) {
                return zzc;
            }
            zzeha zzft = zzeha.zzft(zzc.size() + i);
            zzejt.zza(obj, j, zzft);
            return zzft;
        }
        return zzehh;
    }

    @Override // com.google.android.gms.internal.ads.zzehj
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza = zza(obj, j, zzc.size());
        int size = zza.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza;
        }
        zzejt.zza(obj, j, zzc);
    }
}
