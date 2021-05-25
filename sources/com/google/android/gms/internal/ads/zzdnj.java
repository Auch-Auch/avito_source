package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.avito.android.BuildConfig;
import com.facebook.applinks.AppLinkData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
public final class zzdnj implements zzdnk {
    private final Object[] zzhfk;

    public zzdnj(zzvc zzvc, String str, int i, String str2, zzvm zzvm) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzvc.zzcgv));
        }
        if (hashSet.contains(AppLinkData.ARGUMENTS_EXTRAS_KEY)) {
            arrayList.add(zzr(zzvc.extras));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzvc.extras.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzvc.zzcgw));
        }
        if (hashSet.contains("keywords")) {
            List<String> list = zzvc.zzcgx;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzvc.zzcgy));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzvc.zzadj));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzvc.zzbnu));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzvc.zzcgz);
        }
        if (hashSet.contains("location")) {
            Location location = zzvc.zznb;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzvc.zzchb);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzr(zzvc.zzchc));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzr(zzvc.zzchd));
        }
        if (hashSet.contains("categoryExclusions")) {
            List<String> list2 = zzvc.zzche;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzvc.zzchf);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzvc.zzchg);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzvc.zzchh));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzvc.zzadk));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzvc.zzadl);
        }
        if (hashSet.contains("orientation")) {
            if (zzvm != null) {
                arrayList.add(Integer.valueOf(zzvm.orientation));
            } else {
                arrayList.add(null);
            }
        }
        this.zzhfk = arrayList.toArray();
    }

    private static String zzr(@Nullable Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            if (obj == null) {
                str = BuildConfig.ADJUST_DEFAULT_TRACKER;
            } else if (obj instanceof Bundle) {
                str = zzr((Bundle) obj);
            } else {
                str = obj.toString();
            }
            sb.append(str);
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdnk
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdnj)) {
            return false;
        }
        return Arrays.equals(this.zzhfk, ((zzdnj) obj).zzhfk);
    }

    @Override // com.google.android.gms.internal.ads.zzdnk
    public final int hashCode() {
        return Arrays.hashCode(this.zzhfk);
    }

    public final String toString() {
        int hashCode = hashCode();
        String arrays = Arrays.toString(this.zzhfk);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 22);
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
