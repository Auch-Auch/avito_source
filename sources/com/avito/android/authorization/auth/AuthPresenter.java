package com.avito.android.authorization.auth;

import com.avito.android.authorization.smart_lock.ResolvableResult;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.preferences.Preference;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\fJ9\u0010\u0014\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\fJ\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\u00020 8&@&X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/avito/android/authorization/auth/AuthPresenter;", "", "Lcom/avito/android/authorization/auth/AuthView;", "view", "", "attachView", "(Lcom/avito/android/authorization/auth/AuthView;)V", "Lcom/avito/android/authorization/auth/AuthPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/auth/AuthPresenter$Router;)V", "detachRouter", "()V", "detachView", "onBackPressed", "", "socialType", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "email", "user", "onSocialLoginSuccess", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onSocialLoginFailure", "onSocialLoginCanceled", "onSmartLockLoginFailure", "show", "socialId", "saveSocialId", "(Ljava/lang/String;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "getSkipSavedLogin", "()Z", "setSkipSavedLogin", "(Z)V", "skipSavedLogin", "Router", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface AuthPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onSocialLoginSuccess$default(AuthPresenter authPresenter, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    str4 = null;
                }
                authPresenter.onSocialLoginSuccess(str, str2, str3, str4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSocialLoginSuccess");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000bH&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ5\u0010 \u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u0014\u001a\u00020\u000bH&¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/authorization/auth/AuthPresenter$Router;", "", "", "cancel", "()V", "finishAuth", "openRegistration", "", "skipSavedLogin", "openLogin", "(Z)V", "", "login", Preference.PASSWORD, "(Ljava/lang/String;Ljava/lang/String;)V", "openSuggests", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "socialType", "openSocialLogin", "(Ljava/lang/String;)V", "Lcom/avito/android/authorization/smart_lock/ResolvableResult;", "result", "resolveResult", "(Lcom/avito/android/authorization/smart_lock/ResolvableResult;)V", "title", "suggestKey", "", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "profiles", "openSocialRegistrationSuggestsScreen", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void cancel();

        void finishAuth();

        void followDeepLink(@NotNull DeepLink deepLink);

        void openLogin(@NotNull String str, @NotNull String str2);

        void openLogin(boolean z);

        void openRegistration();

        void openSocialLogin(@NotNull String str);

        void openSocialRegistrationSuggestsScreen(@NotNull String str, @NotNull String str2, @NotNull List<RegisteredProfile> list, @NotNull String str3);

        void openSuggests();

        void resolveResult(@NotNull ResolvableResult resolvableResult);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull AuthView authView);

    void detachRouter();

    void detachView();

    boolean getSkipSavedLogin();

    void onBackPressed();

    @NotNull
    Kundle onSaveState();

    void onSmartLockLoginFailure();

    void onSocialLoginCanceled();

    void onSocialLoginFailure();

    void onSocialLoginSuccess(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);

    void saveSocialId(@Nullable String str);

    void setSkipSavedLogin(boolean z);

    void show();
}
