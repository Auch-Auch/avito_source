package com.avito.android.social;

import android.content.Intent;
import android.os.Bundle;
import com.avito.android.social.SignInManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J)\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/avito/android/social/SocialActivityPresenter;", "", "Lcom/avito/android/social/SocialType;", "type", "", "login", "(Lcom/avito/android/social/SocialType;)V", "logout", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "handleActivityResult", "(IILandroid/content/Intent;)Z", "Lcom/avito/android/social/SocialActivityPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/social/SocialActivityPresenter$Router;)V", "detachRouter", "()V", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "Router", "social_release"}, k = 1, mv = {1, 4, 2})
public interface SocialActivityPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\rJ5\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/social/SocialActivityPresenter$Router;", "", "Lcom/avito/android/social/SignInManager;", "signInManager", "Lkotlin/Function1;", "Lcom/avito/android/social/SignInManager$Result;", "", "callback", "login", "(Lcom/avito/android/social/SignInManager;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/social/SocialType;", "type", "leaveScreen", "(Lcom/avito/android/social/SocialType;)V", "leaveScreenWithError", "", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "email", "user", "leaveScreenWithSuccess", "(Lcom/avito/android/social/SocialType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "social_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void leaveScreenWithSuccess$default(Router router, SocialType socialType, String str, String str2, String str3, int i, Object obj) {
                if (obj == null) {
                    if ((i & 8) != 0) {
                        str3 = null;
                    }
                    router.leaveScreenWithSuccess(socialType, str, str2, str3);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: leaveScreenWithSuccess");
            }
        }

        void leaveScreen(@NotNull SocialType socialType);

        void leaveScreenWithError(@NotNull SocialType socialType);

        void leaveScreenWithSuccess(@NotNull SocialType socialType, @NotNull String str, @Nullable String str2, @Nullable String str3);

        void login(@NotNull SignInManager signInManager, @NotNull Function1<? super SignInManager.Result, Unit> function1);
    }

    void attachRouter(@NotNull Router router);

    void detachRouter();

    boolean handleActivityResult(int i, int i2, @Nullable Intent intent);

    void login(@NotNull SocialType socialType);

    void logout(@NotNull SocialType socialType);

    @NotNull
    Bundle saveState();
}
