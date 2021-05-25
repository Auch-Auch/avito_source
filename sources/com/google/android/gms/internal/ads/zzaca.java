package com.google.android.gms.internal.ads;
public class zzaca<T> {
    private final T zzckv;
    private final String zzcn;
    private final int zzczb;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Ljava/lang/Integer;)V */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public zzaca(String str, Object obj, int i) {
        this.zzcn = str;
        this.zzckv = obj;
        this.zzczb = i;
    }

    public static zzaca<Long> zzb(String str, long j) {
        return new zzaca<>(str, Long.valueOf(j), zzacc.zzczd);
    }

    public static zzaca<Boolean> zzg(String str, boolean z) {
        return new zzaca<>(str, Boolean.valueOf(z), zzacc.zzczc);
    }

    public static zzaca<String> zzi(String str, String str2) {
        return new zzaca<>(str, str2, zzacc.zzczf);
    }

    public T get() {
        zzadc zzrx = zzadb.zzrx();
        if (zzrx != null) {
            int i = zzabz.zzcza[this.zzczb - 1];
            if (i == 1) {
                return (T) zzrx.zzf(this.zzcn, this.zzckv.booleanValue());
            }
            if (i == 2) {
                return (T) zzrx.getLong(this.zzcn, this.zzckv.longValue());
            }
            if (i == 3) {
                return (T) zzrx.zza(this.zzcn, this.zzckv.doubleValue());
            }
            if (i == 4) {
                return (T) zzrx.get(this.zzcn, this.zzckv);
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException("Flag is not initialized.");
    }

    public static zzaca<Double> zzb(String str, double d) {
        return new zzaca<>(str, Double.valueOf(d), zzacc.zzcze);
    }
}
