package com.avito.android.profile.sessions.social_logout;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002\u0012\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter;", "", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutView;", "view", "", "attachView", "(Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutView;)V", "detachView", "()V", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$Router;)V", "detachRouter", "", "resultCode", "onAuthResult", "(I)V", "Router", "SessionParams", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SessionsSocialLogoutPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$Router;", "", "", "openInfoScreen", "()V", "openAuthScreen", "openHomeScreen", "closeScreen", "profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void closeScreen();

        void openAuthScreen();

        void openHomeScreen();

        void openInfoScreen();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B9\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$SessionParams;", "", "", "c", "Ljava/lang/String;", "getSessionHashId", "()Ljava/lang/String;", "sessionHashId", AuthSource.SEND_ABUSE, "getUserId", ChannelContext.Item.USER_ID, "e", "getSource", "source", AuthSource.BOOKING_ORDER, "getDeviceId", "deviceId", "d", "getLoginType", "loginType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class SessionParams {
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final String e;

        public SessionParams(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        @Nullable
        public final String getDeviceId() {
            return this.b;
        }

        @Nullable
        public final String getLoginType() {
            return this.d;
        }

        @Nullable
        public final String getSessionHashId() {
            return this.c;
        }

        @Nullable
        public final String getSource() {
            return this.e;
        }

        @Nullable
        public final String getUserId() {
            return this.a;
        }
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SessionsSocialLogoutView sessionsSocialLogoutView);

    void detachRouter();

    void detachView();

    void onAuthResult(int i);
}
