package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import java.util.Map;
public final class zzcgz implements zzahf<Object> {
    private final zzeli<zzcgw> zzfxe;
    private final zzchc zzfzs;
    @Nullable
    private final zzafc zzgci;

    public zzcgz(zzcdg zzcdg, zzccv zzccv, zzchc zzchc, zzeli<zzcgw> zzeli) {
        this.zzgci = zzcdg.zzge(zzccv.getCustomTemplateId());
        this.zzfzs = zzchc;
        this.zzfxe = zzeli;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(UriUtil.LOCAL_ASSET_SCHEME);
        try {
            this.zzgci.zza(this.zzfxe.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzbbd.zzd(sb.toString(), e);
        }
    }

    public final void zzanf() {
        if (this.zzgci != null) {
            this.zzfzs.zza("/nativeAdCustomClick", this);
        }
    }
}
