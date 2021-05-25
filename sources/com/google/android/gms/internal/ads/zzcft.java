package com.google.android.gms.internal.ads;

import com.avito.android.util.preferences.db_preferences.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;
public final class zzcft {
    private final Executor executor;
    private final zzcfj zzgaz;

    public zzcft(Executor executor2, zzcfj zzcfj) {
        this.executor = executor2;
        this.zzgaz = zzcfj;
    }

    public final zzdvt<List<zzcfy>> zzg(JSONObject jSONObject, String str) {
        zzdvt zzdvt;
        String optString;
        char c;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzdvl.zzaf(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (!(optJSONObject == null || (optString = optJSONObject.optString("name")) == null)) {
                String optString2 = optJSONObject.optString("type");
                if (Types.STRING.equals(optString2)) {
                    c = 1;
                } else {
                    c = "image".equals(optString2) ? (char) 2 : 0;
                }
                if (c == 1) {
                    zzdvt = zzdvl.zzaf(new zzcfy(optString, optJSONObject.optString("string_value")));
                } else if (c == 2) {
                    zzdvt = zzdvl.zzb(this.zzgaz.zzc(optJSONObject, "image_value"), new zzdsl(optString) { // from class: com.google.android.gms.internal.ads.zzcfv
                        private final String zzdgb;

                        {
                            this.zzdgb = r1;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdsl
                        public final Object apply(Object obj) {
                            return new zzcfy(this.zzdgb, (zzadi) obj);
                        }
                    }, this.executor);
                }
                arrayList.add(zzdvt);
            }
            zzdvt = zzdvl.zzaf(null);
            arrayList.add(zzdvt);
        }
        return zzdvl.zzb(zzdvl.zzi(arrayList), zzcfw.zzdwg, this.executor);
    }
}
