package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
public final class zzahh implements zzahf<Object> {
    private final Context zzvr;

    public zzahh(Context context) {
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(Object obj, Map<String, String> map) {
        if (zzp.zzln().zzac(this.zzvr)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 94399:
                    if (str.equals("_aa")) {
                        c = 0;
                        break;
                    }
                    break;
                case 94401:
                    if (str.equals("_ac")) {
                        c = 1;
                        break;
                    }
                    break;
                case 94407:
                    if (str.equals("_ai")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    zzp.zzln().zzl(this.zzvr, str2);
                    return;
                case 1:
                    zzp.zzln().zzi(this.zzvr, str2);
                    return;
                case 2:
                    zzp.zzln().zzj(this.zzvr, str2);
                    return;
                default:
                    zzbbd.zzfc("logScionEvent gmsg contained unsupported eventName");
                    return;
            }
        }
    }
}
