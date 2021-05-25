package com.google.android.gms.internal.ads;
public final class zzacb<T> extends zzaca<T> {
    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Ljava/lang/Integer;)V */
    public zzacb(String str, Object obj, int i) {
        super(str, obj, i);
    }

    public static zzaca<Boolean> zzg(String str, boolean z) {
        return new zzacb(str, Boolean.TRUE, zzacc.zzczc);
    }

    @Override // com.google.android.gms.internal.ads.zzaca
    public final T get() {
        if (zzadb.zzdcd.get()) {
            return (T) super.get();
        }
        throw new IllegalStateException("Striped code is accessed: 54c42518-856a-44fb-aae0-cd6676d514e5");
    }
}
