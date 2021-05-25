package com.avito.android.social;

import android.app.Activity;
import android.content.Intent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.SignInManager;
import com.avito.android.social.apple.AppleAuthActivity;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001f\u0010\u0016J?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018¨\u0006 "}, d2 = {"Lcom/avito/android/social/AppleSignInManagerImpl;", "Lcom/avito/android/social/AppleSignInManager;", "", "request", "result", "Landroid/content/Intent;", "data", "Lkotlin/Function1;", "Lcom/avito/android/social/SignInManager$Result;", "", "callback", "", "handleActivityResult", "(IILandroid/content/Intent;Lkotlin/jvm/functions/Function1;)Z", "", "getToken", "()Ljava/lang/String;", "Landroid/app/Activity;", "activity", "login", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "logout", "()V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUser", "setUser", "(Ljava/lang/String;)V", "user", AuthSource.BOOKING_ORDER, AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "<init>", "social_release"}, k = 1, mv = {1, 4, 2})
public final class AppleSignInManagerImpl implements AppleSignInManager {
    @Nullable
    public String a;
    public String b;

    @Override // com.avito.android.social.SignInManager
    @Nullable
    public String getEmail() {
        return AppleSignInManager.DefaultImpls.getEmail(this);
    }

    @Override // com.avito.android.social.SignInManager
    @Nullable
    public String getToken() {
        return this.b;
    }

    @Override // com.avito.android.social.AppleSignInManager, com.avito.android.social.IsSocialNetwork
    @NotNull
    public SocialType getType() {
        return AppleSignInManager.DefaultImpls.getType(this);
    }

    @Override // com.avito.android.social.AppleSignInManager
    @Nullable
    public String getUser() {
        return this.a;
    }

    @Override // com.avito.android.social.SignInManager
    public boolean handleActivityResult(int i, int i2, @Nullable Intent intent, @Nullable Function1<? super SignInManager.Result, Unit> function1) {
        boolean z = false;
        if (i != 1008) {
            return false;
        }
        if (i2 == -1) {
            String str = null;
            this.b = intent != null ? intent.getStringExtra(AppleSignInManagerKt.EXTRA_APPLE_TOKEN) : null;
            if (intent != null) {
                str = intent.getStringExtra("user");
            }
            setUser(str);
            String str2 = this.b;
            if (str2 != null) {
                if (str2.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                if (function1 != null) {
                    function1.invoke(SignInManager.Result.Success.INSTANCE);
                }
            } else if (function1 != null) {
                function1.invoke(SignInManager.Result.Error.INSTANCE);
            }
        } else if (i2 != 0) {
            if (function1 != null) {
                function1.invoke(SignInManager.Result.Error.INSTANCE);
            }
        } else if (function1 != null) {
            function1.invoke(SignInManager.Result.Cancel.INSTANCE);
        }
        return true;
    }

    @Override // com.avito.android.social.SignInManager
    public boolean hasToken() {
        return AppleSignInManager.DefaultImpls.hasToken(this);
    }

    @Override // com.avito.android.social.SignInManager
    public void login(@NotNull Activity activity, @Nullable Function1<? super SignInManager.Result, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            activity.startActivityForResult(IntentsKt.makeSafeForExternalApps(AppleAuthActivity.Companion.launchIntent(activity)), 1008);
        } catch (Exception e) {
            Logs.error("APPLE_SIGN_IN_MANAGER", "", e);
        }
    }

    @Override // com.avito.android.social.SignInManager
    public void logout() {
    }

    @Override // com.avito.android.social.AppleSignInManager
    public void setUser(@Nullable String str) {
        this.a = str;
    }
}
