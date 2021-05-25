package com.avito.android.advert.item.rating_publish;

import com.avito.android.deep_linking.links.RatingPublishLink;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishView;", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishItem;", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter$Router;)V", "detachRouter", "()V", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsRatingPublishPresenter extends ItemPresenter<AdvertDetailsRatingPublishView, AdvertDetailsRatingPublishItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter$Router;", "", "Lcom/avito/android/deep_linking/links/RatingPublishLink;", "link", "", "openRatingPublishScreen", "(Lcom/avito/android/deep_linking/links/RatingPublishLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void openRatingPublishScreen(@NotNull RatingPublishLink ratingPublishLink);
    }

    void attachRouter(@NotNull Router router);

    void detachRouter();
}
