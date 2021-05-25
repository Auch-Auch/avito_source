package com.google.android.gms.internal.p001authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.identity.SignInOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
/* renamed from: com.google.android.gms.internal.auth-api.zzaf  reason: invalid package */
public final class zzaf extends GoogleApi<SignInOptions> implements SignInClient {
    private static final Api<SignInOptions> API;
    private static final Api.ClientKey<zzak> CLIENT_KEY;
    private static final Api.AbstractClientBuilder<zzak, SignInOptions> zzbm;

    static {
        Api.ClientKey<zzak> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zzag zzag = new zzag();
        zzbm = zzag;
        API = new Api<>("Auth.Api.Identity.SignIn.API", zzag, clientKey);
    }

    public zzaf(@NonNull Context context, @NonNull SignInOptions signInOptions) {
        super(context, API, SignInOptions.Builder.zzc(signInOptions).zze(zzal.zzs()).build(), GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final Task<BeginSignInResult> beginSignIn(@NonNull BeginSignInRequest beginSignInRequest) {
        return doRead(TaskApiCall.builder().setFeatures(zzam.zzcz).run(new RemoteCall(this, BeginSignInRequest.zzc(beginSignInRequest).zzd(((SignInOptions) getApiOptions()).zzg()).build()) { // from class: com.google.android.gms.internal.auth-api.zzae
            private final zzaf zzbk;
            private final BeginSignInRequest zzbl;

            {
                this.zzbk = r1;
                this.zzbl = r2;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzaf zzaf = this.zzbk;
                BeginSignInRequest beginSignInRequest2 = this.zzbl;
                ((zzad) ((zzak) obj).getService()).zzc(new zzaj(zzaf, (TaskCompletionSource) obj2), (BeginSignInRequest) Preconditions.checkNotNull(beginSignInRequest2));
            }
        }).setAutoResolveMissingFeatures(false).build());
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final SignInCredential getSignInCredentialFromIntent(@Nullable Intent intent) throws ApiException {
        if (intent != null) {
            Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "status", Status.CREATOR);
            if (status == null) {
                throw new ApiException(Status.RESULT_CANCELED);
            } else if (status.isSuccess()) {
                SignInCredential signInCredential = (SignInCredential) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "sign_in_credential", SignInCredential.CREATOR);
                if (signInCredential != null) {
                    return signInCredential;
                }
                throw new ApiException(Status.RESULT_INTERNAL_ERROR);
            } else {
                throw new ApiException(status);
            }
        } else {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final Task<Void> signOut() {
        getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
        for (GoogleApiClient googleApiClient : GoogleApiClient.getAllClients()) {
            googleApiClient.maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
        return doRead(TaskApiCall.builder().setFeatures(zzam.zzda).run(new RemoteCall(this) { // from class: com.google.android.gms.internal.auth-api.zzah
            private final zzaf zzbk;

            {
                this.zzbk = r1;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzaf zzaf = this.zzbk;
                ((zzad) ((zzak) obj).getService()).zzc(new zzai(zzaf, (TaskCompletionSource) obj2), ((SignInOptions) zzaf.getApiOptions()).zzg());
            }
        }).setAutoResolveMissingFeatures(false).build());
    }

    public zzaf(@NonNull Activity activity, @NonNull SignInOptions signInOptions) {
        super(activity, API, SignInOptions.Builder.zzc(signInOptions).zze(zzal.zzs()).build(), GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
