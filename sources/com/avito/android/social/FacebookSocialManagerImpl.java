package com.avito.android.social;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.SharingManager;
import com.avito.android.social.SignInManager;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001c\u0010\u0016J?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/social/FacebookSocialManagerImpl;", "Lcom/avito/android/social/FacebookSocialManager;", "", "request", "result", "Landroid/content/Intent;", "data", "Lkotlin/Function1;", "Lcom/avito/android/social/SignInManager$Result;", "", "callback", "", "handleActivityResult", "(IILandroid/content/Intent;Lkotlin/jvm/functions/Function1;)Z", "", "getToken", "()Ljava/lang/String;", "Landroid/app/Activity;", "activity", "login", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "logout", "()V", "link", "Lcom/avito/android/social/SharingManager$ShareError;", "errorListener", "share", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "<init>", "social_release"}, k = 1, mv = {1, 4, 2})
public final class FacebookSocialManagerImpl implements FacebookSocialManager {
    @Override // com.avito.android.social.SignInManager
    @Nullable
    public String getEmail() {
        return FacebookSocialManager.DefaultImpls.getEmail(this);
    }

    @Override // com.avito.android.social.SignInManager
    @Nullable
    public String getToken() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            return null;
        }
        return currentAccessToken.getToken();
    }

    @Override // com.avito.android.social.FacebookSocialManager, com.avito.android.social.IsSocialNetwork
    @NotNull
    public SocialType getType() {
        return FacebookSocialManager.DefaultImpls.getType(this);
    }

    @Override // com.avito.android.social.SignInManager
    public boolean handleActivityResult(int i, int i2, @Nullable Intent intent, @Nullable Function1<? super SignInManager.Result, Unit> function1) {
        CallbackManager create = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(create, new FacebookCallback<LoginResult>(function1) { // from class: com.avito.android.social.FacebookSocialManagerImpl$handleActivityResult$facebookCallback$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                Function1 function12 = this.a;
                if (function12 != null) {
                    Unit unit = (Unit) function12.invoke(SignInManager.Result.Cancel.INSTANCE);
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onError(@NotNull FacebookException facebookException) {
                Intrinsics.checkNotNullParameter(facebookException, "error");
                Function1 function12 = this.a;
                if (function12 != null) {
                    Unit unit = (Unit) function12.invoke(SignInManager.Result.Error.INSTANCE);
                }
            }

            public void onSuccess(@NotNull LoginResult loginResult) {
                Intrinsics.checkNotNullParameter(loginResult, "result");
                Function1 function12 = this.a;
                if (function12 != null) {
                    Unit unit = (Unit) function12.invoke(SignInManager.Result.Success.INSTANCE);
                }
            }
        });
        return create.onActivityResult(i, i2, intent);
    }

    @Override // com.avito.android.social.SignInManager
    public boolean hasToken() {
        return FacebookSocialManager.DefaultImpls.hasToken(this);
    }

    @Override // com.avito.android.social.SignInManager
    public void login(@NotNull Activity activity, @Nullable Function1<? super SignInManager.Result, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        logout();
        LoginManager.getInstance().logInWithReadPermissions(activity, d.listOf("email"));
    }

    @Override // com.avito.android.social.SignInManager
    public void logout() {
        LoginManager.getInstance().logOut();
    }

    @Override // com.avito.android.social.SharingManager
    public void share(@NotNull Activity activity, @NotNull String str, @Nullable Function1<? super SharingManager.ShareError, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "link");
        ShareDialog.show(activity, ((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(str))).build());
    }

    @Override // com.avito.android.social.SharingManager
    public boolean shouldRestoreShare(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return FacebookSocialManager.DefaultImpls.shouldRestoreShare(this, activity);
    }
}
