package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdx<T> implements zzdv<T>, Serializable {
    private final zzdv<T> zza;
    private volatile transient boolean zzb;
    @NullableDecl
    private transient T zzc;

    public zzdx(zzdv<T> zzdv) {
        this.zza = (zzdv) zzdq.zza(zzdv);
    }

    @Override // java.lang.Object
    public final String toString() {
        Object obj;
        if (this.zzb) {
            String valueOf = String.valueOf(this.zzc);
            obj = a.s2(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
        } else {
            obj = this.zza;
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
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
