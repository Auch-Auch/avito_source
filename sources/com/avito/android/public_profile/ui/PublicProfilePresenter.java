package com.avito.android.public_profile.ui;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/public_profile/ui/PublicProfilePresenter;", "", "Lcom/avito/android/public_profile/ui/PublicProfileView;", "view", "", "attachView", "(Lcom/avito/android/public_profile/ui/PublicProfileView;)V", "detachView", "()V", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/public_profile/ui/PublicProfilePresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackClicked", "onRetryClicked", "", "activeTab", "onActiveTabChanged", "(I)V", "", "message", "showMessage", "(Ljava/lang/String;)V", "onAuthCompleted", "reloadProfileAdverts", "Router", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface PublicProfilePresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/public_profile/ui/PublicProfilePresenter$Router;", "", "", "leaveScreen", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "requestCode", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Integer;)V", "Lcom/avito/android/remote/model/Image;", "image", "showPhotoGallery", "(Lcom/avito/android/remote/model/Image;)V", "", "title", "text", "openShareDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void followDeepLink$default(Router router, DeepLink deepLink, Integer num, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        num = null;
                    }
                    router.followDeepLink(deepLink, num);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: followDeepLink");
            }
        }

        void followDeepLink(@NotNull DeepLink deepLink, @Nullable Integer num);

        void leaveScreen();

        void openShareDialog(@NotNull String str, @NotNull String str2);

        void showPhotoGallery(@NotNull Image image);
    }

    void attachRouter(@Nullable Router router);

    void attachView(@NotNull PublicProfileView publicProfileView);

    void detachRouter();

    void detachView();

    void onActiveTabChanged(int i);

    void onAuthCompleted();

    void onBackClicked();

    void onRetryClicked();

    @NotNull
    Kundle onSaveState();

    void reloadProfileAdverts();

    void showMessage(@NotNull String str);
}
