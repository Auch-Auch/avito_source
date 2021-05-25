package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;
public final class zzarl extends zzarf {
    private final /* synthetic */ UpdateClickUrlCallback zzdpl;

    public zzarl(zzarj zzarj, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzdpl = updateClickUrlCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzarc
    public final void onError(String str) {
        this.zzdpl.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzarc
    public final void onSuccess(List<Uri> list) {
        this.zzdpl.onSuccess(list.get(0));
    }
}
