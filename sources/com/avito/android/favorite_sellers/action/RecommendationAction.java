package com.avito.android.favorite_sellers.action;

import com.avito.android.favorite_sellers.SellerCarouselItem;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.AppEventsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/favorite_sellers/action/RecommendationAction;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", "<init>", "()V", "OpenSubscriptionSettings", AppEventsConstants.EVENT_NAME_SUBSCRIBE, "Lcom/avito/android/favorite_sellers/action/RecommendationAction$Subscribe;", "Lcom/avito/android/favorite_sellers/action/RecommendationAction$OpenSubscriptionSettings;", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public abstract class RecommendationAction implements FavoriteSellersItemAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/favorite_sellers/action/RecommendationAction$OpenSubscriptionSettings;", "Lcom/avito/android/favorite_sellers/action/RecommendationAction;", "Lcom/avito/android/favorite_sellers/SellerCarouselItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/favorite_sellers/SellerCarouselItem;", "getItem", "()Lcom/avito/android/favorite_sellers/SellerCarouselItem;", "item", "<init>", "(Lcom/avito/android/favorite_sellers/SellerCarouselItem;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    public static final class OpenSubscriptionSettings extends RecommendationAction {
        @NotNull
        public final SellerCarouselItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenSubscriptionSettings(@NotNull SellerCarouselItem sellerCarouselItem) {
            super(null);
            Intrinsics.checkNotNullParameter(sellerCarouselItem, "item");
            this.a = sellerCarouselItem;
        }

        @NotNull
        public final SellerCarouselItem getItem() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/favorite_sellers/action/RecommendationAction$Subscribe;", "Lcom/avito/android/favorite_sellers/action/RecommendationAction;", "Lcom/avito/android/favorite_sellers/SellerCarouselItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/favorite_sellers/SellerCarouselItem;", "getItem", "()Lcom/avito/android/favorite_sellers/SellerCarouselItem;", "item", "<init>", "(Lcom/avito/android/favorite_sellers/SellerCarouselItem;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    public static final class Subscribe extends RecommendationAction {
        @NotNull
        public final SellerCarouselItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Subscribe(@NotNull SellerCarouselItem sellerCarouselItem) {
            super(null);
            Intrinsics.checkNotNullParameter(sellerCarouselItem, "item");
            this.a = sellerCarouselItem;
        }

        @NotNull
        public final SellerCarouselItem getItem() {
            return this.a;
        }
    }

    public RecommendationAction() {
    }

    public RecommendationAction(j jVar) {
    }
}
