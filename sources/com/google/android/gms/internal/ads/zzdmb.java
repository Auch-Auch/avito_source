package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
public final class zzdmb {
    public static zzuw zza(int i, zzuw zzuw) {
        if (((Integer) zzwe.zzpu().zzd(zzaat.zzcxx)).intValue() > 0) {
            return zzuw;
        }
        return zza(i, null, zzuw);
    }

    public static zzuw zza(int i, @Nullable String str, @Nullable zzuw zzuw) {
        if (str == null) {
            switch (zzdme.zzhda[i - 1]) {
                case 1:
                    str = "Invalid request.";
                    break;
                case 2:
                    str = "Network error.";
                    break;
                case 3:
                    str = "No fill.";
                    break;
                case 4:
                    str = "App ID missing.";
                    break;
                case 5:
                    str = "Invalid request: Invalid ad unit ID.";
                    break;
                case 6:
                    str = "Invalid request: Invalid ad size.";
                    break;
                case 7:
                    str = "A mediation adapter failed to show the ad.";
                    break;
                case 8:
                    str = "The ad is not ready.";
                    break;
                case 9:
                    str = "The ad has already been shown.";
                    break;
                case 10:
                    str = "The ad can not be shown when app is not in foreground.";
                    break;
                default:
                    str = "Internal error.";
                    break;
            }
        }
        switch (zzdme.zzhda[i - 1]) {
            case 1:
                return new zzuw(1, str, MobileAds.ERROR_DOMAIN, zzuw);
            case 2:
                return new zzuw(2, str, MobileAds.ERROR_DOMAIN, zzuw);
            case 3:
                return new zzuw(3, str, MobileAds.ERROR_DOMAIN, zzuw);
            case 4:
                return new zzuw(8, str, MobileAds.ERROR_DOMAIN, zzuw);
            case 5:
                return new zzuw(1, str, MobileAds.ERROR_DOMAIN, zzuw);
            case 6:
                return new zzuw(1, str, MobileAds.ERROR_DOMAIN, zzuw);
            case 7:
                return new zzuw(4, str, MobileAds.ERROR_DOMAIN, zzuw);
            case 8:
                return new zzuw(2, str, MobileAds.ERROR_DOMAIN, zzuw);
            case 9:
                return new zzuw(1, str, MobileAds.ERROR_DOMAIN, zzuw);
            case 10:
                return new zzuw(3, str, MobileAds.ERROR_DOMAIN, zzuw);
            default:
                return new zzuw(0, str, MobileAds.ERROR_DOMAIN, zzuw);
        }
    }
}
