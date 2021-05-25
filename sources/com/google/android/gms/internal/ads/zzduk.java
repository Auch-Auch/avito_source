package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzduk<I, O, F, T> extends zzdvf<O> implements Runnable {
    @NullableDecl
    private zzdvt<? extends I> zzhof;
    @NullableDecl
    private F zzhow;

    public zzduk(zzdvt<? extends I> zzdvt, F f) {
        this.zzhof = (zzdvt) zzdsv.checkNotNull(zzdvt);
        this.zzhow = (F) zzdsv.checkNotNull(f);
    }

    public static <I, O> zzdvt<O> zza(zzdvt<I> zzdvt, zzduv<? super I, ? extends O> zzduv, Executor executor) {
        zzdsv.checkNotNull(executor);
        zzdun zzdun = new zzdun(zzdvt, zzduv);
        zzdvt.addListener(zzdun, zzdvv.zza(executor, zzdun));
        return zzdun;
    }

    @Override // com.google.android.gms.internal.ads.zzdui
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhof);
        this.zzhof = null;
        this.zzhow = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdui
    public final String pendingToString() {
        String str;
        zzdvt<? extends I> zzdvt = this.zzhof;
        F f = this.zzhow;
        String pendingToString = super.pendingToString();
        if (zzdvt != null) {
            String valueOf = String.valueOf(zzdvt);
            str = a.s2(valueOf.length() + 16, "inputFuture=[", valueOf, "], ");
        } else {
            str = "";
        }
        if (f != null) {
            String valueOf2 = String.valueOf(f);
            return a.t2(valueOf2.length() + a.q0(str, 11), str, "function=[", valueOf2, "]");
        } else if (pendingToString == null) {
            return null;
        } else {
            String valueOf3 = String.valueOf(str);
            return pendingToString.length() != 0 ? valueOf3.concat(pendingToString) : new String(valueOf3);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.android.gms.internal.ads.zzduk<I, O, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        zzdvt<? extends I> zzdvt = this.zzhof;
        F f = this.zzhow;
        boolean z = true;
        boolean isCancelled = isCancelled() | (zzdvt == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.zzhof = null;
            if (zzdvt.isCancelled()) {
                setFuture(zzdvt);
                return;
            }
            try {
                try {
                    Object zzd = zzd(f, zzdvl.zza(zzdvt));
                    this.zzhow = null;
                    setResult(zzd);
                } catch (Throwable th) {
                    this.zzhow = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    public abstract void setResult(@NullableDecl T t);

    @NullableDecl
    public abstract T zzd(F f, @NullableDecl I i) throws Exception;

    public static <I, O> zzdvt<O> zza(zzdvt<I> zzdvt, zzdsl<? super I, ? extends O> zzdsl, Executor executor) {
        zzdsv.checkNotNull(zzdsl);
        zzdum zzdum = new zzdum(zzdvt, zzdsl);
        zzdvt.addListener(zzdum, zzdvv.zza(executor, zzdum));
        return zzdum;
    }
}
