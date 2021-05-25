package com.avito.android.rating.details;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.rating.details.adapter.info.InfoItem;
import com.avito.android.ratings.ReviewData;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Kundle;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/rating/details/RatingDetailsPresenter;", "", "Lcom/avito/android/rating/details/RatingDetailsView;", "view", "", "attachView", "(Lcom/avito/android/rating/details/RatingDetailsView;)V", "detachView", "()V", "Lcom/avito/android/rating/details/RatingDetailsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/details/RatingDetailsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Router", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface RatingDetailsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0016\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/rating/details/RatingDetailsPresenter$Router;", "", "", "close", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/rating/details/adapter/info/InfoItem$Hint;", "hint", "showInfoHintDialog", "(Lcom/avito/android/rating/details/adapter/info/InfoItem$Hint;)V", "Lcom/avito/android/ratings/ReviewData;", "reviewData", "openReviewDetailsScreen", "(Lcom/avito/android/ratings/ReviewData;)V", "", "Lcom/avito/android/remote/model/Image;", "images", "", VKApiConst.POSITION, "openGallery", "(Ljava/util/List;I)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void close();

        void followDeepLink(@NotNull DeepLink deepLink);

        void openGallery(@NotNull List<Image> list, int i);

        void openReviewDetailsScreen(@NotNull ReviewData reviewData);

        void showInfoHintDialog(@NotNull InfoItem.Hint hint);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull RatingDetailsView ratingDetailsView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle onSaveState();
}
