package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
public final class zzeeq {
    private final ConcurrentHashMap<zzeep, List<Throwable>> zziak = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzial = new ReferenceQueue<>();

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzial.poll();
        while (poll != null) {
            this.zziak.remove(poll);
            poll = this.zzial.poll();
        }
        List<Throwable> list = this.zziak.get(new zzeep(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zziak.putIfAbsent(new zzeep(th, this.zzial), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
