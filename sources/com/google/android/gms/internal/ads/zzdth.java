package com.google.android.gms.internal.ads;

import java.util.Iterator;
public abstract class zzdth<E> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.ads.zzdth<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public zzdth<E> zza(Iterator<? extends E> it) {
        while (it.hasNext()) {
            zzab(it.next());
        }
        return this;
    }

    public abstract zzdth<E> zzab(E e);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.ads.zzdth<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public zzdth<E> zzg(Iterable<? extends E> iterable) {
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            zzab(it.next());
        }
        return this;
    }
}
