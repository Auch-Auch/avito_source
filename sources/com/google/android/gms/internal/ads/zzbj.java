package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
public final class zzbj implements zzaz {
    private final /* synthetic */ Context val$appContext;
    private File zzcz = null;

    public zzbj(Context context) {
        this.val$appContext = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final File zzo() {
        if (this.zzcz == null) {
            this.zzcz = new File(this.val$appContext.getCacheDir(), "volley");
        }
        return this.zzcz;
    }
}
