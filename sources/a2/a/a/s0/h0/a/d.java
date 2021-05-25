package a2.a.a.s0.h0.a;

import com.avito.android.favorite_sellers.SellerCarouselItem;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl;
import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import io.reactivex.rxjava3.functions.Action;
public final class d implements Action {
    public final /* synthetic */ RecommendationItemPresenterImpl a;
    public final /* synthetic */ SubscriptionSettingsView b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ SellerCarouselItem d;

    public d(RecommendationItemPresenterImpl recommendationItemPresenterImpl, SubscriptionSettingsView subscriptionSettingsView, boolean z, SellerCarouselItem sellerCarouselItem) {
        this.a = recommendationItemPresenterImpl;
        this.b = subscriptionSettingsView;
        this.c = z;
        this.d = sellerCarouselItem;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.b.setNotificationActivated(this.c);
        this.d.setNotificationsActivated(Boolean.valueOf(this.c));
        RecommendationItemPresenterImpl.access$updateSeller(this.a, this.d);
    }
}
