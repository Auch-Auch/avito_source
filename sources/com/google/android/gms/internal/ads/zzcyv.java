package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.Collections;
import javax.annotation.Nonnull;
public final class zzcyv implements zzdvi<Uri> {
    private final /* synthetic */ zzarc zzgru;

    public zzcyv(zzcyk zzcyk, zzarc zzarc) {
        this.zzgru = zzarc;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(@Nonnull Uri uri) {
        try {
            this.zzgru.onSuccess(Collections.singletonList(uri));
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        try {
            zzarc zzarc = this.zzgru;
            String valueOf = String.valueOf(th.getMessage());
            zzarc.onError(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }
}
