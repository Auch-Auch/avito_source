package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
@ShowFirstParty
@KeepForSdk
@CheckReturnValue
public class GoogleSignatureVerifier {
    @Nullable
    private static GoogleSignatureVerifier zza;
    private final Context zzb;
    private volatile String zzc;

    private GoogleSignatureVerifier(Context context) {
        this.zzb = context.getApplicationContext();
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(@RecentlyNonNull Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzc.zza(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    @RecentlyNonNull
    public static boolean zza(@RecentlyNonNull PackageInfo packageInfo, @RecentlyNonNull boolean z) {
        zzd zzd;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zzd = zza(packageInfo, zzi.zza);
            } else {
                zzd = zza(packageInfo, zzi.zza[0]);
            }
            if (zzd != null) {
                return true;
            }
        }
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isGooglePublicSignedPackage(@RecentlyNonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        return zza(packageInfo, true) && GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
    }

    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(@RecentlyNonNull String str) {
        zzl zza2 = zza(str, false, false);
        zza2.zzc();
        return zza2.zza;
    }

    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(@RecentlyNonNull int i) {
        zzl zzl;
        String[] packagesForUid = this.zzb.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && packagesForUid.length != 0) {
            zzl = null;
            int length = packagesForUid.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    zzl = (zzl) Preconditions.checkNotNull(zzl);
                    break;
                }
                zzl = zza(packagesForUid[i2], false, false);
                if (zzl.zza) {
                    break;
                }
                i2++;
            }
        } else {
            zzl = zzl.zza("no pkgs");
        }
        zzl.zzc();
        return zzl.zza;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final zzl zza(String str, boolean z, boolean z2) {
        zzl zzl;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return zzl.zza("null pkg");
        }
        if (str.equals(this.zzc)) {
            return zzl.zza();
        }
        try {
            PackageInfo packageInfo = this.zzb.getPackageManager().getPackageInfo(str, 64);
            boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
            if (packageInfo == null) {
                zzl = zzl.zza("null pkg");
            } else {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr == null || signatureArr.length != 1) {
                    zzl = zzl.zza("single cert required");
                } else {
                    zzg zzg = new zzg(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzl zza2 = zzc.zza(str2, zzg, honorsDebugCertificates, false);
                    zzl = (!zza2.zza || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !zzc.zza(str2, zzg, false, true).zza) ? zza2 : zzl.zza("debuggable release cert app rejected");
                }
            }
            if (zzl.zza) {
                this.zzc = str;
            }
            return zzl;
        } catch (PackageManager.NameNotFoundException e) {
            return zzl.zza(str.length() != 0 ? "no pkg ".concat(str) : new String("no pkg "), e);
        }
    }

    @Nullable
    private static zzd zza(PackageInfo packageInfo, zzd... zzdArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        zzg zzg = new zzg(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzdArr.length; i++) {
            if (zzdArr[i].equals(zzg)) {
                return zzdArr[i];
            }
        }
        return null;
    }
}
