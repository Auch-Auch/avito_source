package com.avito.android.screen_opener;

import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter;", "", "Lcom/avito/android/screen_opener/ProfileScreenResolverView;", "view", "", "attachView", "(Lcom/avito/android/screen_opener/ProfileScreenResolverView;)V", "detachView", "()V", "Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter$Router;)V", "detachRouter", "Router", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileScreenResolverPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter$Router;", "", "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "profile", "", "userKey", "contextId", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "screenTransfer", "", "openPublicProfileScreen", "(Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", "openExtendedProfileScreen", "(Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "closeScreen", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void closeScreen();

        void openExtendedProfileScreen(@NotNull ExtendedPublicUserProfile extendedPublicUserProfile, @NotNull String str, @Nullable String str2, @NotNull ScreenTransfer screenTransfer);

        void openPublicProfileScreen(@NotNull DefaultPublicUserProfile defaultPublicUserProfile, @NotNull String str, @Nullable String str2, @NotNull ScreenTransfer screenTransfer);
    }

    void attachRouter(@Nullable Router router);

    void attachView(@NotNull ProfileScreenResolverView profileScreenResolverView);

    void detachRouter();

    void detachView();
}
