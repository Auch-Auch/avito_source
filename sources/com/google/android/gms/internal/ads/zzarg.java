package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
public final class zzarg extends zzaws {
    private final /* synthetic */ QueryInfoGenerationCallback zzdpf;

    public zzarg(zzarh zzarh, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zzdpf = queryInfoGenerationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzawt
    public final void onError(String str) {
        this.zzdpf.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzawt
    public final void zza(String str, String str2, Bundle bundle) {
        QueryInfo queryInfo = new QueryInfo(new zzzb(str, bundle));
        zzwe.zzpy().put(queryInfo, str2);
        this.zzdpf.onSuccess(queryInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzawt
    public final void zzk(String str, String str2) {
        QueryInfo queryInfo = new QueryInfo(new zzzb(str, null));
        zzwe.zzpy().put(queryInfo, str2);
        this.zzdpf.onSuccess(queryInfo);
    }
}
