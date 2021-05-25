package com.avito.android.rating.user_review_details;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Kundle;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter;", "", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsView;", "view", "", "attachView", "(Lcom/avito/android/rating/user_review_details/UserReviewDetailsView;)V", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Router", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface UserReviewDetailsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0010\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter$Router;", "", "", "isReviewRemoved", "", "leaveScreen", "(Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "Lcom/avito/android/remote/model/Image;", "images", "", VKApiConst.POSITION, "openGallery", "(Ljava/util/List;I)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void leaveScreen$default(Router router, boolean z, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        z = false;
                    }
                    router.leaveScreen(z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: leaveScreen");
            }
        }

        void followDeepLink(@NotNull DeepLink deepLink);

        void leaveScreen(boolean z);

        void openGallery(@NotNull List<Image> list, int i);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull UserReviewDetailsView userReviewDetailsView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle onSaveState();
}
