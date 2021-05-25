package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;
public final class zzbgi implements zzahf<zzbfq> {
    private final /* synthetic */ zzbgg zzeox;

    public zzbgi(zzbgg zzbgg) {
        this.zzeox = zzbgg;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzbfq zzbfq, Map map) {
        if (map != null) {
            String str = (String) map.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzeox) {
                        if (zzbgg.zza(this.zzeox) != parseInt) {
                            zzbgg.zza(this.zzeox, parseInt);
                            this.zzeox.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzbbd.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
