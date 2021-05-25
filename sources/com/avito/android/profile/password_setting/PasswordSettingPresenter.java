package com.avito.android.profile.password_setting;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/profile/password_setting/PasswordSettingPresenter;", "", "Lcom/avito/android/profile/password_setting/PasswordSettingView;", "view", "", "attachView", "(Lcom/avito/android/profile/password_setting/PasswordSettingView;)V", "detachView", "()V", "Lcom/avito/android/profile/password_setting/PasswordSettingPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/password_setting/PasswordSettingPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "resultCode", "onAuthResult", "(I)V", "Router", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface PasswordSettingPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/profile/password_setting/PasswordSettingPresenter$Router;", "", "", "leaveScreen", "()V", "", "message", "leaveWithSuccessMessage", "(Ljava/lang/String;)V", "navigateToAuth", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "followDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDeeplink(@NotNull DeepLink deepLink);

        void leaveScreen();

        void leaveWithSuccessMessage(@NotNull String str);

        void navigateToAuth();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull PasswordSettingView passwordSettingView);

    void detachRouter();

    void detachView();

    void onAuthResult(int i);

    @NotNull
    Kundle onSaveState();
}
