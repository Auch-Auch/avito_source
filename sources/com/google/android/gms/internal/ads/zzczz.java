package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;
public final class zzczz implements zzden<zzdek<Bundle>> {
    private final Set<String> zzgss;

    public zzczz(Set<String> set) {
        this.zzgss = set;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdek<Bundle>> zzaqs() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzgss) {
            arrayList.add(str);
        }
        return zzdvl.zzaf(new zzdek(arrayList) { // from class: com.google.android.gms.internal.ads.zzczy
            private final ArrayList zzgsr;

            {
                this.zzgsr = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdek
            public final void zzs(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", this.zzgsr);
            }
        });
    }
}
