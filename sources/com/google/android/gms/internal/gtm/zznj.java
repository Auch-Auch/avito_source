package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
public final class zznj implements Runnable {
    private final zzmn zzatm;
    private final zzni zzatn;
    private final zzmw zzato;
    private final zznf zzatp;
    private final Context zzrm;

    public zznj(Context context, zzmw zzmw, zzmn zzmn) {
        this(context, zzmw, zzmn, new zzni(), new zznf());
    }

    @VisibleForTesting
    private final boolean zzx(String str) {
        return this.zzrm.getPackageManager().checkPermission(str, this.zzrm.getPackageName()) == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    @Override // java.lang.Runnable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 338
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zznj.run():void");
    }

    @VisibleForTesting
    private zznj(Context context, zzmw zzmw, zzmn zzmn, zzni zzni, zznf zznf) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
        this.zzatm = (zzmn) Preconditions.checkNotNull(zzmn);
        this.zzato = zzmw;
        this.zzatn = zzni;
        this.zzatp = zznf;
    }
}
