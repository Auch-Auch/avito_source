package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zar;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
@KeepForSdk
public class SignInClientImpl extends GmsClient<zae> implements zad {
    private final boolean zaa;
    private final ClientSettings zab;
    private final Bundle zac;
    @Nullable
    private final Integer zad;

    public SignInClientImpl(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull boolean z, @RecentlyNonNull ClientSettings clientSettings, @RecentlyNonNull Bundle bundle, @RecentlyNonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @RecentlyNonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zaa = z;
        this.zab = clientSettings;
        this.zac = bundle;
        this.zad = clientSettings.zad();
    }

    @RecentlyNonNull
    @KeepForSdk
    public static Bundle createBundleFromClientSettings(@RecentlyNonNull ClientSettings clientSettings) {
        SignInOptions zac2 = clientSettings.zac();
        Integer zad2 = clientSettings.zad();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.getAccount());
        if (zad2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zad2.intValue());
        }
        if (zac2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public /* synthetic */ IInterface createServiceInterface(@RecentlyNonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zae) {
            return (zae) queryLocalInterface;
        }
        return new zah(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.zab.getRealClientPackageName())) {
            this.zac.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zab.getRealClientPackageName());
        }
        return this.zac;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    @RecentlyNonNull
    public int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    @RecentlyNonNull
    public boolean requiresSignIn() {
        return this.zaa;
    }

    @Override // com.google.android.gms.signin.zad
    public final void zaa(@RecentlyNonNull IAccountAccessor iAccountAccessor, @RecentlyNonNull boolean z) {
        try {
            ((zae) getService()).zaa(iAccountAccessor, ((Integer) Preconditions.checkNotNull(this.zad)).intValue(), z);
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.signin.zad
    public final void zab() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
    }

    @Override // com.google.android.gms.signin.zad
    public final void zaa() {
        try {
            ((zae) getService()).zaa(((Integer) Preconditions.checkNotNull(this.zad)).intValue());
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.signin.zad
    public final void zaa(zac zac2) {
        Preconditions.checkNotNull(zac2, "Expecting a valid ISignInCallbacks");
        try {
            Account accountOrDefault = this.zab.getAccountOrDefault();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(accountOrDefault.name)) {
                googleSignInAccount = Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount();
            }
            ((zae) getService()).zaa(new zak(new zar(accountOrDefault, ((Integer) Preconditions.checkNotNull(this.zad)).intValue(), googleSignInAccount)), zac2);
        } catch (RemoteException e) {
            try {
                zac2.zaa(new zam(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public SignInClientImpl(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull boolean z, @RecentlyNonNull ClientSettings clientSettings, @RecentlyNonNull SignInOptions signInOptions, @RecentlyNonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @RecentlyNonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, true, clientSettings, createBundleFromClientSettings(clientSettings), connectionCallbacks, onConnectionFailedListener);
    }
}
