package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;
public final class zzaoj {
    public static int zza(AdRequest.ErrorCode errorCode) {
        int i = zzaom.zzdlk[errorCode.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }

    public static MediationAdRequest zza(zzvc zzvc, boolean z) {
        AdRequest.Gender gender;
        HashSet hashSet = zzvc.zzcgx != null ? new HashSet(zzvc.zzcgx) : null;
        Date date = new Date(zzvc.zzcgv);
        int i = zzvc.zzcgw;
        if (i == 1) {
            gender = AdRequest.Gender.MALE;
        } else if (i != 2) {
            gender = AdRequest.Gender.UNKNOWN;
        } else {
            gender = AdRequest.Gender.FEMALE;
        }
        return new MediationAdRequest(date, gender, hashSet, z, zzvc.zznb);
    }
}
