package com.google.android.datatransport.cct.a;

import android.util.SparseArray;
import com.facebook.share.internal.MessengerShareContentUtility;
/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class zzu extends Enum<zzu> {
    public static final SparseArray<zzu> a;
    public static final zzu zza;
    public static final zzu zzb;
    public static final zzu zzc;
    public static final zzu zzd;
    public static final zzu zze;
    public static final zzu zzf;

    static {
        zzu zzu = new zzu(MessengerShareContentUtility.PREVIEW_DEFAULT, 0);
        zza = zzu;
        zzu zzu2 = new zzu("UNMETERED_ONLY", 1);
        zzb = zzu2;
        zzu zzu3 = new zzu("UNMETERED_OR_DAILY", 2);
        zzc = zzu3;
        zzu zzu4 = new zzu("FAST_IF_RADIO_AWAKE", 3);
        zzd = zzu4;
        zzu zzu5 = new zzu("NEVER", 4);
        zze = zzu5;
        zzu zzu6 = new zzu("UNRECOGNIZED", 5);
        zzf = zzu6;
        SparseArray<zzu> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(0, zzu);
        sparseArray.put(1, zzu2);
        sparseArray.put(2, zzu3);
        sparseArray.put(3, zzu4);
        sparseArray.put(4, zzu5);
        sparseArray.put(-1, zzu6);
    }

    public zzu(String str, int i) {
    }
}
