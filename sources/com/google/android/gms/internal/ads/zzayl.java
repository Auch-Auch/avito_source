package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
public final class zzayl implements zzbau {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzeao;

    public zzayl(zzayh zzayh, Context context, String str) {
        this.val$context = context;
        this.zzeao = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbau
    public final void zzes(String str) {
        zzp.zzkp();
        zzayh.zzb(this.val$context, this.zzeao, str);
    }
}
