package com.avito.android.social;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.SharingManager;
import com.avito.android.social.SignInManager;
import com.avito.android.util.Activities;
import com.avito.android.util.Contexts;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.tasks.Task;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010(\u001a\u00020%¢\u0006\u0004\b)\u0010*J?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/social/GoogleSocialManagerImpl;", "Lcom/avito/android/social/GoogleSocialManager;", "", "request", "result", "Landroid/content/Intent;", "data", "Lkotlin/Function1;", "Lcom/avito/android/social/SignInManager$Result;", "", "callback", "", "handleActivityResult", "(IILandroid/content/Intent;Lkotlin/jvm/functions/Function1;)Z", "", "getToken", "()Ljava/lang/String;", "Landroid/app/Activity;", "activity", "login", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "logout", "()V", "link", "Lcom/avito/android/social/SharingManager$ShareError;", "errorListener", "share", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "isAvailable", "()Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleSignInClient", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class GoogleSocialManagerImpl implements GoogleSocialManager {
    public final GoogleSignInClient a;
    public String b;
    public final Context c;

    @Inject
    public GoogleSocialManagerImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = context;
        GoogleSignInClient client = GoogleSignIn.getClient(context, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestIdToken(context.getString(R.string.googleRequestIdToken)).build());
        Intrinsics.checkNotNullExpressionValue(client, "GoogleSignIn.getClient(c…ext, googleSignInOptions)");
        this.a = client;
    }

    @Override // com.avito.android.social.SignInManager
    @Nullable
    public String getEmail() {
        return GoogleSocialManager.DefaultImpls.getEmail(this);
    }

    @Override // com.avito.android.social.SignInManager
    @Nullable
    public String getToken() {
        return this.b;
    }

    @Override // com.avito.android.social.GoogleSocialManager, com.avito.android.social.IsSocialNetwork
    @NotNull
    public SocialType getType() {
        return GoogleSocialManager.DefaultImpls.getType(this);
    }

    @Override // com.avito.android.social.SignInManager
    public boolean handleActivityResult(int i, int i2, @Nullable Intent intent, @Nullable Function1<? super SignInManager.Result, Unit> function1) {
        SignInManager.Result result;
        if (i != 1002) {
            return false;
        }
        if (i2 == -1) {
            Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(intent);
            Intrinsics.checkNotNullExpressionValue(signedInAccountFromIntent, "GoogleSignIn.getSignedInAccountFromIntent(data)");
            if (signedInAccountFromIntent.isSuccessful()) {
                GoogleSignInAccount result2 = signedInAccountFromIntent.getResult();
                Intrinsics.checkNotNullExpressionValue(result2, "task.result");
                this.b = result2.getIdToken();
                result = SignInManager.Result.Success.INSTANCE;
            } else if (signedInAccountFromIntent.isCanceled()) {
                result = SignInManager.Result.Cancel.INSTANCE;
            } else {
                result = SignInManager.Result.Error.INSTANCE;
            }
            if (function1 == null) {
                return true;
            }
            function1.invoke(result);
            return true;
        } else if (i2 != 0) {
            if (function1 == null) {
                return true;
            }
            function1.invoke(SignInManager.Result.Error.INSTANCE);
            return true;
        } else if (function1 == null) {
            return true;
        } else {
            function1.invoke(SignInManager.Result.Cancel.INSTANCE);
            return true;
        }
    }

    @Override // com.avito.android.social.SignInManager
    public boolean hasToken() {
        return GoogleSocialManager.DefaultImpls.hasToken(this);
    }

    @Override // com.avito.android.social.GoogleSocialManager
    public boolean isAvailable() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.c) == 0;
    }

    @Override // com.avito.android.social.SignInManager
    public void login(@NotNull Activity activity, @Nullable Function1<? super SignInManager.Result, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "GoogleApiAvailability.getInstance()");
        int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            instance.showErrorNotification(activity, isGooglePlayServicesAvailable);
            if (function1 != null) {
                function1.invoke(SignInManager.Result.Error.INSTANCE);
                return;
            }
            return;
        }
        logout();
        Intent signInIntent = this.a.getSignInIntent();
        Intrinsics.checkNotNullExpressionValue(signInIntent, "googleSignInClient.signInIntent");
        Activities.startActivityForResultSafely(activity, signInIntent, 1002);
    }

    @Override // com.avito.android.social.SignInManager
    public void logout() {
        this.b = null;
        this.a.signOut();
    }

    @Override // com.avito.android.social.SharingManager
    public void share(@NotNull Activity activity, @NotNull String str, @Nullable Function1<? super SharingManager.ShareError, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "link");
        PlusShare.Builder contentUrl = new PlusShare.Builder(activity).setType("text/plain").setContentUrl(Uri.parse(str));
        Intrinsics.checkNotNullExpressionValue(contentUrl, "PlusShare.Builder(activi…      .setContentUrl(uri)");
        Intent intent = contentUrl.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Contexts.startActivitySafely(activity, intent);
    }

    @Override // com.avito.android.social.SharingManager
    public boolean shouldRestoreShare(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return GoogleSocialManager.DefaultImpls.shouldRestoreShare(this, activity);
    }
}
