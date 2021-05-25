package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdw<T> implements zzdv<T> {
    private volatile zzdv<T> zza;
    private volatile boolean zzb;
    @NullableDecl
    private T zzc;

    public zzdw(zzdv<T> zzdv) {
        this.zza = (zzdv) zzdq.zza(zzdv);
    }

    public final String toString() {
        Object obj = this.zza;
        if (obj == null) {
            String valueOf = String.valueOf(this.zzc);
            obj = a.s2(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
        }
        String valueOf2 = String.valueOf(obj);
        return a.s2(valueOf2.length() + 19, "Suppliers.memoize(", valueOf2, ")");
    }

    @Override // com.google.android.gms.internal.measurement.zzdv
    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    T zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
