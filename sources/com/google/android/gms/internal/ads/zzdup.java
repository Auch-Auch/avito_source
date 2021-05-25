package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzdup<InputT, OutputT> extends zzdus<OutputT> {
    private static final Logger logger = Logger.getLogger(zzdup.class.getName());
    @NullableDecl
    private zzdtf<? extends zzdvt<? extends InputT>> zzhpa;
    private final boolean zzhpb;
    private final boolean zzhpc;

    public enum zza {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public zzdup(zzdtf<? extends zzdvt<? extends InputT>> zzdtf, boolean z, boolean z2) {
        super(zzdtf.size());
        this.zzhpa = (zzdtf) zzdsv.checkNotNull(zzdtf);
        this.zzhpb = z;
        this.zzhpc = z2;
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.ads.zzdup<InputT, OutputT> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: public */
    private final void zza(int i, Future<? extends InputT> future) {
        try {
            zzb(i, (int) zzdvl.zza(future));
        } catch (ExecutionException e) {
            zzj(e.getCause());
        } catch (Throwable th) {
            zzj(th);
        }
    }

    private final void zzj(Throwable th) {
        zzdsv.checkNotNull(th);
        if (this.zzhpb && !setException(th) && zza(zzaxf(), th)) {
            zzk(th);
        } else if (th instanceof Error) {
            zzk(th);
        }
    }

    private static void zzk(Throwable th) {
        logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    @Override // com.google.android.gms.internal.ads.zzdui
    public final void afterDone() {
        super.afterDone();
        zzdtf<? extends zzdvt<? extends InputT>> zzdtf = this.zzhpa;
        zza(zza.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (zzdtf != null)) {
            boolean wasInterrupted = wasInterrupted();
            zzdub zzdub = (zzdub) zzdtf.iterator();
            while (zzdub.hasNext()) {
                ((Future) zzdub.next()).cancel(wasInterrupted);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdui
    public final String pendingToString() {
        zzdtf<? extends zzdvt<? extends InputT>> zzdtf = this.zzhpa;
        if (zzdtf == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzdtf);
        return a.r2(valueOf.length() + 8, "futures=", valueOf);
    }

    public final void zzaxd() {
        if (this.zzhpa.isEmpty()) {
            zzaxe();
        } else if (this.zzhpb) {
            int i = 0;
            zzdub zzdub = (zzdub) this.zzhpa.iterator();
            while (zzdub.hasNext()) {
                zzdvt zzdvt = (zzdvt) zzdub.next();
                zzdvt.addListener(new zzduo(this, zzdvt, i), zzdva.INSTANCE);
                i++;
            }
        } else {
            zzduq zzduq = new zzduq(this, this.zzhpc ? this.zzhpa : null);
            zzdub zzdub2 = (zzdub) this.zzhpa.iterator();
            while (zzdub2.hasNext()) {
                ((zzdvt) zzdub2.next()).addListener(zzduq, zzdva.INSTANCE);
            }
        }
    }

    public abstract void zzaxe();

    public abstract void zzb(int i, @NullableDecl InputT inputt);

    @Override // com.google.android.gms.internal.ads.zzdus
    public final void zzh(Set<Throwable> set) {
        zzdsv.checkNotNull(set);
        if (!isCancelled()) {
            zza(set, zzaxa());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(@NullableDecl zzdtf<? extends Future<? extends InputT>> zzdtf) {
        int zzaxg = zzaxg();
        int i = 0;
        if (!(zzaxg >= 0)) {
            throw new IllegalStateException("Less than 0 remaining futures");
        } else if (zzaxg == 0) {
            if (zzdtf != null) {
                zzdub zzdub = (zzdub) zzdtf.iterator();
                while (zzdub.hasNext()) {
                    Future<? extends InputT> future = (Future) zzdub.next();
                    if (!future.isCancelled()) {
                        zza(i, future);
                    }
                    i++;
                }
            }
            zzaxh();
            zzaxe();
            zza(zza.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    public void zza(zza zza2) {
        zzdsv.checkNotNull(zza2);
        this.zzhpa = null;
    }

    private static boolean zza(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    public static /* synthetic */ zzdtf zza(zzdup zzdup, zzdtf zzdtf) {
        zzdup.zzhpa = null;
        return null;
    }
}
