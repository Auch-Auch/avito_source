package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zztw;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
public class zzcyx {
    private String zzgrv;

    public static class zza {
        private String zzgrv;

        public final zza zzgs(String str) {
            this.zzgrv = str;
            return this;
        }
    }

    private zzcyx(zza zza2) {
        this.zzgrv = zza2.zzgrv;
    }

    public final Set<String> zzaqp() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zzgrv.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzaqq() {
        return this.zzgrv.toLowerCase(Locale.ROOT);
    }

    public final zztw.zza.EnumC0204zza zzaqr() {
        String str = this.zzgrv;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    c = 0;
                    break;
                }
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    c = 1;
                    break;
                }
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    c = 2;
                    break;
                }
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return zztw.zza.EnumC0204zza.AD_LOADER;
            case 1:
                return zztw.zza.EnumC0204zza.INTERSTITIAL;
            case 2:
                return zztw.zza.EnumC0204zza.REWARD_BASED_VIDEO_AD;
            case 3:
                return zztw.zza.EnumC0204zza.BANNER;
            default:
                return zztw.zza.EnumC0204zza.AD_INITIATER_UNSPECIFIED;
        }
    }
}
