package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
public final class zzal extends zzae<T> {
    private final Object lock = new Object();
    private String zzec;
    private T zzed;
    private final /* synthetic */ zzan zzee;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzal(zzao zzao, String str, Object obj, zzan zzan) {
        super(zzao, str, obj, null);
        this.zzee = zzan;
    }

    @Override // com.google.android.gms.internal.clearcut.zzae
    public final T zza(SharedPreferences sharedPreferences) {
        try {
            return (T) zzb(sharedPreferences.getString(this.zzds, ""));
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.zzds);
            if (valueOf.length() != 0) {
                "Invalid byte[] value in SharedPreferences for ".concat(valueOf);
                return null;
            }
            new String("Invalid byte[] value in SharedPreferences for ");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        java.lang.String.valueOf(r3.zzds).length();
        java.lang.String.valueOf(r4).length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        return null;
     */
    @Override // com.google.android.gms.internal.clearcut.zzae
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzb(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            java.lang.String r1 = r3.zzec     // Catch:{ all -> 0x001e }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x001a
            com.google.android.gms.internal.clearcut.zzan r1 = r3.zzee     // Catch:{ all -> 0x001e }
            r2 = 3
            byte[] r2 = android.util.Base64.decode(r4, r2)     // Catch:{ all -> 0x001e }
            java.lang.Object r1 = r1.zzb(r2)     // Catch:{ all -> 0x001e }
            r3.zzec = r4     // Catch:{ all -> 0x001e }
            r3.zzed = r1     // Catch:{ all -> 0x001e }
        L_0x001a:
            T r1 = r3.zzed     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return r1
        L_0x001e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r1     // Catch:{ IOException | IllegalArgumentException -> 0x0021 }
        L_0x0021:
            java.lang.String r0 = r3.zzds
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r0.length()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r4.length()
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzal.zzb(java.lang.String):java.lang.Object");
    }
}
