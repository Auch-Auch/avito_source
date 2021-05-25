package com.google.android.gms.internal.gtm;

import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public final class zzmg extends zzhb {
    private static final Set<String> zzarz = new HashSet(Arrays.asList(ShareTarget.METHOD_GET, "HEAD", ShareTarget.METHOD_POST, "PUT"));
    private final zzei zzary;

    public zzmg(zzei zzei) {
        this.zzary = zzei;
    }

    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        HashMap hashMap;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 1);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzok);
        zzoa<?> zzco = zzoaArr[0].zzco("url");
        Preconditions.checkArgument(zzco instanceof zzom);
        String str = (String) ((zzom) zzco).value();
        zzoa<?> zzco2 = zzoaArr[0].zzco("method");
        zzog zzog = zzog.zzaum;
        if (zzco2 == zzog) {
            zzco2 = new zzom(ShareTarget.METHOD_GET);
        }
        Preconditions.checkArgument(zzco2 instanceof zzom);
        String str2 = (String) ((zzom) zzco2).value();
        Preconditions.checkArgument(zzarz.contains(str2));
        zzoa<?> zzco3 = zzoaArr[0].zzco("uniqueId");
        Preconditions.checkArgument(zzco3 == zzog || zzco3 == zzog.zzaul || (zzco3 instanceof zzom));
        String str3 = null;
        String str4 = (zzco3 == zzog || zzco3 == zzog.zzaul) ? null : (String) ((zzom) zzco3).value();
        zzoa<?> zzco4 = zzoaArr[0].zzco("headers");
        Preconditions.checkArgument(zzco4 == zzog || (zzco4 instanceof zzok));
        HashMap hashMap2 = new HashMap();
        if (zzco4 == zzog) {
            hashMap = null;
        } else {
            for (Map.Entry<String, zzoa<?>> entry : ((zzok) zzco4).value().entrySet()) {
                String key = entry.getKey();
                zzoa<?> value = entry.getValue();
                if (!(value instanceof zzom)) {
                    zzev.zzac(String.format("Ignore the non-string value of header key %s.", key));
                } else {
                    hashMap2.put(key, (String) ((zzom) value).value());
                }
            }
            hashMap = hashMap2;
        }
        zzoa<?> zzco5 = zzoaArr[0].zzco(SDKConstants.PARAM_A2U_BODY);
        zzog zzog2 = zzog.zzaum;
        Preconditions.checkArgument(zzco5 == zzog2 || (zzco5 instanceof zzom));
        if (zzco5 != zzog2) {
            str3 = (String) ((zzom) zzco5).value();
        }
        if ((str2.equals(ShareTarget.METHOD_GET) || str2.equals("HEAD")) && str3 != null) {
            zzev.zzac(String.format("Body of %s hit will be ignored: %s.", str2, str3));
        }
        this.zzary.zza(str, str2, str4, hashMap, str3);
        zzev.zzab(String.format("QueueRequest:\n  url = %s,\n  method = %s,\n  uniqueId = %s,\n  headers = %s,\n  body = %s", str, str2, str4, hashMap, str3));
        return zzog2;
    }
}
