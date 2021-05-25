package com.avito.android.authorization.login;

import com.avito.android.authorization.smart_lock.ResolvableResult;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Kundle;
import com.avito.android.util.preferences.Preference;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ5\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH&¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/avito/android/authorization/login/LoginPresenter;", "", "", "login", Preference.PASSWORD, "", "isHiddenLogin", "skipSavedLogin", "", "setStartLogin", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "onPhoneVerified", "()V", "Lcom/avito/android/authorization/login/LoginView;", "view", "attachView", "(Lcom/avito/android/authorization/login/LoginView;)V", "Lcom/avito/android/authorization/login/LoginPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/login/LoginPresenter$Router;)V", "detachRouter", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Router", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface LoginPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setStartLogin$default(LoginPresenter loginPresenter, String str, String str2, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z2 = false;
                }
                loginPresenter.setStartLogin(str, str2, z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStartLogin");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u000fJ7\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0015\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H&¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010!\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H&¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0002H&¢\u0006\u0004\b+\u0010\u0004¨\u0006,"}, d2 = {"Lcom/avito/android/authorization/login/LoginPresenter$Router;", "", "", "completeLogin", "()V", "", "login", "openPasswordRecovery", "(Ljava/lang/String;)V", "text", "", "codeTimeout", "", "codeLength", "openPasswordResetCodeConfirmation", "(Ljava/lang/String;Ljava/lang/String;JI)V", "openLoginCodeConfirmation", "challengeId", "openPhoneAntihackLoginCodeConfirmation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "phone", "openTfaCodeConfirmation", "hash", "openChangePassword", "(Ljava/lang/String;Ljava/lang/String;)V", "phonePart", "inputHint", "openPhoneProving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "phones", "", "isAntihackMode", "openPhoneList", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/authorization/smart_lock/ResolvableResult;", "resolvableResult", "resolveResult", "(Lcom/avito/android/authorization/smart_lock/ResolvableResult;)V", "leaveScreen", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void completeLogin();

        void followDeepLink(@NotNull DeepLink deepLink);

        void leaveScreen();

        void openChangePassword(@NotNull String str, @NotNull String str2);

        void openLoginCodeConfirmation(@NotNull String str, @NotNull String str2, long j, int i);

        void openPasswordRecovery(@Nullable String str);

        void openPasswordResetCodeConfirmation(@NotNull String str, @NotNull String str2, long j, int i);

        void openPhoneAntihackLoginCodeConfirmation(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, int i);

        void openPhoneList(@Nullable String str, @NotNull List<String> list, @Nullable String str2, boolean z);

        void openPhoneProving(@NotNull String str, @NotNull String str2, @NotNull String str3);

        void openTfaCodeConfirmation(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, int i);

        void resolveResult(@NotNull ResolvableResult resolvableResult);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull LoginView loginView);

    void detachRouter();

    void detachView();

    void onPhoneVerified();

    @NotNull
    Kundle onSaveState();

    void setStartLogin(@Nullable String str, @Nullable String str2, boolean z, boolean z2);
}
