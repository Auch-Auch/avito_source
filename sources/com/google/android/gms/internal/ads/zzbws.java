package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
public final class zzbws extends zzbxe<AppEventListener> implements zzagn {
    public zzbws(Set<zzbys<AppEventListener>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzagn
    public final synchronized void onAppEvent(String str, String str2) {
        zza(new zzbxg(str, str2) { // from class: com.google.android.gms.internal.ads.zzbwv
            private final String zzdft;
            private final String zzdgb;

            {
                this.zzdgb = r1;
                this.zzdft = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzbxg
            public final void zzp(Object obj) {
                ((AppEventListener) obj).onAppEvent(this.zzdgb, this.zzdft);
            }
        });
    }
}
