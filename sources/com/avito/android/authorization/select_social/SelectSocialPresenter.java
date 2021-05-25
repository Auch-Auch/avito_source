package com.avito.android.authorization.select_social;

import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0016\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/authorization/select_social/SelectSocialPresenter;", "", "Lcom/avito/android/authorization/select_social/SelectSocialView;", "view", "", "attachView", "(Lcom/avito/android/authorization/select_social/SelectSocialView;)V", "Lcom/avito/android/authorization/select_social/SelectSocialPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/select_social/SelectSocialPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "socialType", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "email", "user", "onSocialLoginSuccess", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onSocialLoginFailure", "onSocialLoginCanceled", "Router", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface SelectSocialPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onSocialLoginSuccess$default(SelectSocialPresenter selectSocialPresenter, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    str4 = null;
                }
                selectSocialPresenter.onSocialLoginSuccess(str, str2, str3, str4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSocialLoginSuccess");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/authorization/select_social/SelectSocialPresenter$Router;", "", "", "leaveScreen", "()V", "", "socialType", "openSocialLogin", "(Ljava/lang/String;)V", "completeAuthorization", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void completeAuthorization();

        void leaveScreen();

        void openSocialLogin(@NotNull String str);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SelectSocialView selectSocialView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle onSaveState();

    void onSocialLoginCanceled();

    void onSocialLoginFailure();

    void onSocialLoginSuccess(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);
}
