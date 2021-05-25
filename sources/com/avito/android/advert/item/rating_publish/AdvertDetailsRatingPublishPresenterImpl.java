package com.avito.android.advert.item.rating_publish;

import com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishPresenter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.RatingPublishLink;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenterImpl;", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter;", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishView;", "view", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishView;Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishItem;I)V", "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter$Router;)V", "detachRouter", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/rating_publish/AdvertDetailsRatingPublishPresenter$Router;", "<init>", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsRatingPublishPresenterImpl implements AdvertDetailsRatingPublishPresenter {
    public AdvertDetailsRatingPublishPresenter.Router a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertDetailsRatingPublishPresenterImpl a;
        public final /* synthetic */ AdvertDetailsRatingPublishItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsRatingPublishPresenterImpl advertDetailsRatingPublishPresenterImpl, AdvertDetailsRatingPublishItem advertDetailsRatingPublishItem) {
            super(0);
            this.a = advertDetailsRatingPublishPresenterImpl;
            this.b = advertDetailsRatingPublishItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            AdvertDetailsRatingPublishPresenter.Router router;
            DeepLink deepLink = this.b.getAction().getDeepLink();
            if (!(deepLink instanceof RatingPublishLink)) {
                deepLink = null;
            }
            RatingPublishLink ratingPublishLink = (RatingPublishLink) deepLink;
            if (!(ratingPublishLink == null || (router = this.a.a) == null)) {
                router.openRatingPublishScreen(ratingPublishLink);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishPresenter
    public void attachRouter(@NotNull AdvertDetailsRatingPublishPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    @Override // com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishPresenter
    public void detachRouter() {
        this.a = null;
    }

    public void bindView(@NotNull AdvertDetailsRatingPublishView advertDetailsRatingPublishView, @NotNull AdvertDetailsRatingPublishItem advertDetailsRatingPublishItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsRatingPublishView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsRatingPublishItem, "item");
        advertDetailsRatingPublishView.setActionText(advertDetailsRatingPublishItem.getAction().getTitle());
        advertDetailsRatingPublishView.setOnClickListener(new a(this, advertDetailsRatingPublishItem));
    }
}
