package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;
public final class zzo {
    @Nullable
    private static zzo zzcl;
    @VisibleForTesting
    private Storage zzcm;
    @Nullable
    @VisibleForTesting
    private GoogleSignInAccount zzcn;
    @Nullable
    @VisibleForTesting
    private GoogleSignInOptions zzco = this.zzcm.getSavedDefaultGoogleSignInOptions();

    private zzo(Context context) {
        Storage instance = Storage.getInstance(context);
        this.zzcm = instance;
        this.zzcn = instance.getSavedDefaultGoogleSignInAccount();
    }

    public static synchronized zzo zzd(@NonNull Context context) {
        zzo zze;
        synchronized (zzo.class) {
            zze = zze(context.getApplicationContext());
        }
        return zze;
    }

    private static synchronized zzo zze(Context context) {
        synchronized (zzo.class) {
            zzo zzo = zzcl;
            if (zzo != null) {
                return zzo;
            }
            zzo zzo2 = new zzo(context);
            zzcl = zzo2;
            return zzo2;
        }
    }

    public final synchronized void clear() {
        this.zzcm.clear();
        this.zzcn = null;
        this.zzco = null;
    }

    public final synchronized void zzc(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.zzcm.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.zzcn = googleSignInAccount;
        this.zzco = googleSignInOptions;
    }

    @Nullable
    public final synchronized GoogleSignInAccount zzl() {
        return this.zzcn;
    }

    @Nullable
    public final synchronized GoogleSignInOptions zzm() {
        return this.zzco;
    }
}
