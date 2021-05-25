package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@ShowFirstParty
public final class zzs extends zzi<zzs> {
    private Map<Integer, String> zzuh = new HashMap(4);

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, String> entry : this.zzuh.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(a.r2(valueOf.length() + 9, ViewHierarchyConstants.DIMENSION_KEY, valueOf), entry.getValue());
        }
        return zzi.zza((Object) hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzs zzs) {
        zzs.zzuh.putAll(this.zzuh);
    }

    public final Map<Integer, String> zzbk() {
        return Collections.unmodifiableMap(this.zzuh);
    }
}
