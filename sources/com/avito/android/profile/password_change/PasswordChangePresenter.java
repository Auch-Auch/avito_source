package com.avito.android.profile.password_change;

import a2.g.r.g;
import com.avito.android.authorization.smart_lock.ResolvableResult;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002\u0019\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/profile/password_change/PasswordChangePresenter;", "", "Lcom/avito/android/profile/password_change/PasswordChangeView;", "view", "", "attachView", "(Lcom/avito/android/profile/password_change/PasswordChangeView;)V", "detachView", "()V", "Lcom/avito/android/profile/password_change/PasswordChangePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/password_change/PasswordChangePresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "resultCode", "onAuthResult", "(I)V", "", "isVisible", "onVisibilityChange", "(Z)V", "Mode", "Router", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface PasswordChangePresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/avito/android/profile/password_change/PasswordChangePresenter$Mode;", "", "", g.a, "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", ChannelContext.Item.USER_ID, "", AuthSource.SEND_ABUSE, "Z", "isSessionsFlow", "()Z", "c", "getLogin", "login", AuthSource.BOOKING_ORDER, "getSource", "source", "f", "getDeviceId", "deviceId", "d", "getLoginType", "loginType", "e", "getSessionIdHash", "sessionIdHash", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Mode {
        public final boolean a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final String e;
        @Nullable
        public final String f;
        @Nullable
        public final String g;

        public Mode(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            this.a = z;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
        }

        @Nullable
        public final String getDeviceId() {
            return this.f;
        }

        @Nullable
        public final String getLogin() {
            return this.c;
        }

        @Nullable
        public final String getLoginType() {
            return this.d;
        }

        @Nullable
        public final String getSessionIdHash() {
            return this.e;
        }

        @Nullable
        public final String getSource() {
            return this.b;
        }

        @Nullable
        public final String getUserId() {
            return this.g;
        }

        public final boolean isSessionsFlow() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0014\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/avito/android/profile/password_change/PasswordChangePresenter$Router;", "", "", "leaveScreen", "()V", "", "message", "leaveWithSuccessMessage", "(Ljava/lang/String;)V", "navigateToInfoScreen", "navigateToHomeScreen", "navigateToAuth", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "followDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/authorization/smart_lock/ResolvableResult;", "result", "resolveLoadingResult", "(Lcom/avito/android/authorization/smart_lock/ResolvableResult;)V", "resolveSaveResult", "login", "openPasswordRecovery", "profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDeeplink(@NotNull DeepLink deepLink);

        void leaveScreen();

        void leaveWithSuccessMessage(@NotNull String str);

        void navigateToAuth();

        void navigateToHomeScreen();

        void navigateToInfoScreen();

        void openPasswordRecovery(@Nullable String str);

        void resolveLoadingResult(@NotNull ResolvableResult resolvableResult);

        void resolveSaveResult(@NotNull ResolvableResult resolvableResult);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull PasswordChangeView passwordChangeView);

    void detachRouter();

    void detachView();

    void onAuthResult(int i);

    @NotNull
    Kundle onSaveState();

    void onVisibilityChange(boolean z);
}
