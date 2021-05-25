package com.avito.android.authorization.login_protection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter;", "", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListView;", "view", "", "attachView", "(Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListView;)V", "detachView", "()V", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter$Router;)V", "detachRouter", "onPhoneProved", "onTfaSuccess", "Router", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface LoginProtectionPhoneListPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter$Router;", "", "", "challengeId", "phonePart", "", "openPhoneProving", "(Ljava/lang/String;Ljava/lang/String;)V", "", "isSuccessful", "isAntihackMode", "leaveScreen", "(ZZ)V", "url", "openHelpCenter", "(Ljava/lang/String;)V", "login", "phone", "text", "", "codeTimeout", "", "codeLength", "openTfaCodeConfirmation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void leaveScreen(boolean z, boolean z2);

        void openHelpCenter(@NotNull String str);

        void openPhoneProving(@NotNull String str, @NotNull String str2);

        void openTfaCodeConfirmation(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, int i);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull LoginProtectionPhoneListView loginProtectionPhoneListView);

    void detachRouter();

    void detachView();

    void onPhoneProved();

    void onTfaSuccess();
}
