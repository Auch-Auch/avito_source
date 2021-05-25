package com.avito.android.profile.sessions.info;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0002\u000e\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter;", "", "Lcom/avito/android/profile/sessions/info/SessionsInfoView;", "view", "", "attachView", "(Lcom/avito/android/profile/sessions/info/SessionsInfoView;)V", "detachView", "()V", "Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Router;)V", "detachRouter", "Mode", "Router", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SessionsInfoPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "LOGOUT", "PASSWORD_CHANGE", "profile_release"}, k = 1, mv = {1, 4, 2})
    public enum Mode {
        LOGOUT,
        PASSWORD_CHANGE
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Router;", "", "", "navigateToSessionsList", "()V", "", "url", "openHelpCenter", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void navigateToSessionsList();

        void openHelpCenter(@NotNull String str);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SessionsInfoView sessionsInfoView);

    void detachRouter();

    void detachView();
}
