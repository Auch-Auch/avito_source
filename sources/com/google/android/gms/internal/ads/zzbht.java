package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;
public final class zzbht implements zzahf<zzbfq> {
    private final /* synthetic */ zzbhr zzepu;

    public zzbht(zzbhr zzbhr) {
        this.zzepu = zzbhr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzbfq zzbfq, Map map) {
        if (map != null) {
            String str = (String) map.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzepu) {
                        if (zzbhr.zza(this.zzepu) != parseInt) {
                            zzbhr.zza(this.zzepu, parseInt);
                            this.zzepu.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzbbd.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
