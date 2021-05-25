package com.google.android.gms.auth;

import a2.b.a.a.a;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzay;
import com.google.android.gms.internal.auth.zzf;
import java.io.IOException;
public final class zzi implements zzj<Boolean> {
    private final /* synthetic */ String zzt;

    public zzi(String str) {
        this.zzt = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.auth.zzj
    public final /* synthetic */ Boolean zzb(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle bundle = (Bundle) zzd.zza(zzf.zza(iBinder).zza(this.zzt));
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzay zzc = zzay.zzc(string);
        if (zzay.SUCCESS.equals(zzc)) {
            return Boolean.TRUE;
        }
        if (zzay.zza(zzc)) {
            Logger logger = zzd.zzn;
            String valueOf = String.valueOf(zzc);
            logger.w("GoogleAuthUtil", a.r2(valueOf.length() + 31, "isUserRecoverableError status: ", valueOf));
            throw new UserRecoverableAuthException(string, intent);
        }
        throw new GoogleAuthException(string);
    }
}
