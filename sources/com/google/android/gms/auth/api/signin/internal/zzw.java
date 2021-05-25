package com.google.android.gms.auth.api.signin.internal;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.UidVerifier;
public final class zzw extends zzq {
    private final Context mContext;

    public zzw(Context context) {
        this.mContext = context;
    }

    private final void zzq() {
        if (!UidVerifier.isGooglePlayServicesUid(this.mContext, Binder.getCallingUid())) {
            throw new SecurityException(a.o2(52, "Calling UID ", Binder.getCallingUid(), " is not Google Play services."));
        }
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzr
    public final void zzn() {
        zzq();
        Storage instance = Storage.getInstance(this.mContext);
        GoogleSignInAccount savedDefaultGoogleSignInAccount = instance.getSavedDefaultGoogleSignInAccount();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
        if (savedDefaultGoogleSignInAccount != null) {
            googleSignInOptions = instance.getSavedDefaultGoogleSignInOptions();
        }
        GoogleSignInClient client = GoogleSignIn.getClient(this.mContext, googleSignInOptions);
        if (savedDefaultGoogleSignInAccount != null) {
            client.revokeAccess();
        } else {
            client.signOut();
        }
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzr
    public final void zzo() {
        zzq();
        zzo.zzd(this.mContext).clear();
    }
}
