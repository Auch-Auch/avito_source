package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.avito.android.remote.model.Navigation;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001authapi.zzan;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@KeepName
public class SignInHubActivity extends FragmentActivity {
    private static boolean zzcr = false;
    private boolean zzcs = false;
    private SignInConfiguration zzct;
    private boolean zzcu;
    private int zzcv;
    private Intent zzcw;

    public class zzc implements LoaderManager.LoaderCallbacks<Void> {
        private zzc() {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzf(SignInHubActivity.this, GoogleApiClient.getAllClients());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.loader.content.Loader, java.lang.Object] */
        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final /* synthetic */ void onLoadFinished(Loader<Void> loader, Void r3) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.zzcv, SignInHubActivity.this.zzcw);
            SignInHubActivity.this.finish();
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public final void onLoaderReset(Loader<Void> loader) {
        }
    }

    private final void zzc(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zzcr = false;
    }

    private final void zzr() {
        getSupportLoaderManager().initLoader(0, null, new zzc());
        zzcr = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (!this.zzcs) {
            setResult(0);
            if (i == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                    if (signInAccount != null && signInAccount.getGoogleSignInAccount() != null) {
                        GoogleSignInAccount googleSignInAccount = signInAccount.getGoogleSignInAccount();
                        zzo.zzd(this).zzc(this.zzct.zzp(), (GoogleSignInAccount) zzan.checkNotNull(googleSignInAccount));
                        intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                        intent.putExtra("googleSignInAccount", googleSignInAccount);
                        this.zzcu = true;
                        this.zzcv = i2;
                        this.zzcw = intent;
                        zzr();
                        return;
                    } else if (intent.hasExtra(CommonKt.TAG_ERROR_CODE)) {
                        int intExtra = intent.getIntExtra(CommonKt.TAG_ERROR_CODE, 8);
                        if (intExtra == 13) {
                            intExtra = GoogleSignInStatusCodes.SIGN_IN_CANCELLED;
                        }
                        zzc(intExtra);
                        return;
                    }
                }
                zzc(8);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str = (String) zzan.checkNotNull(intent.getAction());
        if ("com.google.android.gms.auth.NO_IMPL".equals(str)) {
            zzc(GoogleSignInStatusCodes.SIGN_IN_FAILED);
        } else if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || str.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            SignInConfiguration signInConfiguration = (SignInConfiguration) ((Bundle) zzan.checkNotNull(intent.getBundleExtra(Navigation.CONFIG))).getParcelable(Navigation.CONFIG);
            if (signInConfiguration == null) {
                setResult(0);
                finish();
                return;
            }
            this.zzct = signInConfiguration;
            if (bundle != null) {
                boolean z = bundle.getBoolean("signingInGoogleApiClients");
                this.zzcu = z;
                if (z) {
                    this.zzcv = bundle.getInt("signInResultCode");
                    this.zzcw = (Intent) zzan.checkNotNull((Intent) bundle.getParcelable("signInResultData"));
                    zzr();
                }
            } else if (zzcr) {
                setResult(0);
                zzc(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
            } else {
                zzcr = true;
                Intent intent2 = new Intent(str);
                if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                    intent2.setPackage("com.google.android.gms");
                } else {
                    intent2.setPackage(getPackageName());
                }
                intent2.putExtra(Navigation.CONFIG, this.zzct);
                try {
                    startActivityForResult(intent2, 40962);
                } catch (ActivityNotFoundException unused) {
                    this.zzcs = true;
                    zzc(17);
                }
            }
        } else {
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                "Unknown action: ".concat(valueOf);
            } else {
                new String("Unknown action: ");
            }
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zzcu);
        if (this.zzcu) {
            bundle.putInt("signInResultCode", this.zzcv);
            bundle.putParcelable("signInResultData", this.zzcw);
        }
    }
}
