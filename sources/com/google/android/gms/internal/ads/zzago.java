package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzago implements zzahf<Object> {
    private final zzagn zzddw;

    public zzago(zzagn zzagn) {
        this.zzddw = zzagn;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzbbd.zzfe("App event with no name parameter.");
        } else {
            this.zzddw.onAppEvent(str, map.get("info"));
        }
    }
}
