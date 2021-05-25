package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;
public final class zzdls {
    public static zzdkw zza(List<zzdkw> list, zzdkw zzdkw) {
        return list.get(0);
    }

    public static zzvj zzb(Context context, List<zzdkw> list) {
        ArrayList arrayList = new ArrayList();
        for (zzdkw zzdkw : list) {
            if (zzdkw.zzhae) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzdkw.width, zzdkw.height));
            }
        }
        return new zzvj(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzdkw zzf(zzvj zzvj) {
        if (zzvj.zzchp) {
            return new zzdkw(-3, 0, true);
        }
        return new zzdkw(zzvj.width, zzvj.height, false);
    }
}
