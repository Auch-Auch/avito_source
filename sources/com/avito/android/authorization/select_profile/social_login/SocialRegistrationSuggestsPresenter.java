package com.avito.android.authorization.select_profile.social_login;

import com.avito.android.remote.model.registration.ProfileSocial;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter;", "", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsView;", "view", "", "attachView", "(Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsView;)V", "detachView", "()V", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter$Router;)V", "detachRouter", "Router", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface SocialRegistrationSuggestsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsPresenter$Router;", "", "", "login", "suggestKey", "", "openLogin", "(Ljava/lang/String;Ljava/lang/String;)V", "", "Lcom/avito/android/remote/model/registration/ProfileSocial;", "social", "openSelectSocial", "(Ljava/util/List;Ljava/lang/String;)V", "leaveScreen", "()V", "onProfileCreated", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void leaveScreen();

        void onProfileCreated();

        void openLogin(@NotNull String str, @NotNull String str2);

        void openSelectSocial(@NotNull List<ProfileSocial> list, @NotNull String str);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SocialRegistrationSuggestsView socialRegistrationSuggestsView);

    void detachRouter();

    void detachView();
}
