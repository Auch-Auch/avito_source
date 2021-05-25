package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdui;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
public abstract class zzdus<OutputT> extends zzdui.zzj<OutputT> {
    private static final Logger zzhoi = Logger.getLogger(zzdus.class.getName());
    private static final zzb zzhph;
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    public static final class zza extends zzb {
        private final AtomicReferenceFieldUpdater<zzdus, Set<Throwable>> zzhpi;
        private final AtomicIntegerFieldUpdater<zzdus> zzhpj;

        public zza(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.zzhpi = atomicReferenceFieldUpdater;
            this.zzhpj = atomicIntegerFieldUpdater;
        }

        @Override // com.google.android.gms.internal.ads.zzdus.zzb
        public final void zza(zzdus zzdus, Set<Throwable> set, Set<Throwable> set2) {
            this.zzhpi.compareAndSet(zzdus, null, set2);
        }

        @Override // com.google.android.gms.internal.ads.zzdus.zzb
        public final int zzc(zzdus zzdus) {
            return this.zzhpj.decrementAndGet(zzdus);
        }
    }

    public static abstract class zzb {
        private zzb() {
        }

        public abstract void zza(zzdus zzdus, Set<Throwable> set, Set<Throwable> set2);

        public abstract int zzc(zzdus zzdus);
    }

    public static final class zzc extends zzb {
        private zzc() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdus.zzb
        public final void zza(zzdus zzdus, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (zzdus) {
                if (zzdus.seenExceptions == null) {
                    zzdus.seenExceptions = set2;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdus.zzb
        public final int zzc(zzdus zzdus) {
            int zzb;
            synchronized (zzdus) {
                zzb = zzdus.zzb(zzdus);
            }
            return zzb;
        }
    }

    static {
        Throwable th;
        zzb zzb2;
        try {
            zzb2 = new zza(AtomicReferenceFieldUpdater.newUpdater(zzdus.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzdus.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzb2 = new zzc();
        }
        zzhph = zzb2;
        if (th != null) {
            zzhoi.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    public zzdus(int i) {
        this.remaining = i;
    }

    public static /* synthetic */ int zzb(zzdus zzdus) {
        int i = zzdus.remaining - 1;
        zzdus.remaining = i;
        return i;
    }

    public final Set<Throwable> zzaxf() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set<Throwable> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzh(newSetFromMap);
        zzhph.zza(this, null, newSetFromMap);
        return this.seenExceptions;
    }

    public final int zzaxg() {
        return zzhph.zzc(this);
    }

    public final void zzaxh() {
        this.seenExceptions = null;
    }

    public abstract void zzh(Set<Throwable> set);
}
