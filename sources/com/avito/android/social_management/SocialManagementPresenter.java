package com.avito.android.social_management;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/social_management/SocialManagementPresenter;", "", "Lcom/avito/android/social_management/SocialManagementView;", "view", "", "attachView", "(Lcom/avito/android/social_management/SocialManagementView;)V", "Lcom/avito/android/social_management/SocialManagementPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/social_management/SocialManagementPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "type", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "onSocialLoginResult", "(Ljava/lang/String;Ljava/lang/String;)V", "onSocialLoginError", "onBackPressed", "Router", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public interface SocialManagementPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/social_management/SocialManagementPresenter$Router;", "", "", "type", "", "loginSocial", "(Ljava/lang/String;)V", "", "changed", "leaveScreen", "(Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDeepLink(@NotNull DeepLink deepLink);

        void leaveScreen(boolean z);

        void loginSocial(@NotNull String str);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SocialManagementView socialManagementView);

    void detachRouter();

    void detachView();

    void onBackPressed();

    @NotNull
    Kundle onSaveState();

    void onSocialLoginError();

    void onSocialLoginResult(@NotNull String str, @NotNull String str2);
}
