package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;
public final class zzari extends zzarf {
    private final /* synthetic */ UpdateImpressionUrlsCallback zzdpi;

    public zzari(zzarj zzarj, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzdpi = updateImpressionUrlsCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzarc
    public final void onError(String str) {
        this.zzdpi.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzarc
    public final void onSuccess(List<Uri> list) {
        this.zzdpi.onSuccess(list);
    }
}
