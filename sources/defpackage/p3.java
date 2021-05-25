package defpackage;

import com.avito.android.favorite_sellers.SellerCarouselItem;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl;
import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import io.reactivex.rxjava3.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: p3  reason: default package */
public final class p3 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public p3(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            SubscriptionSettingsView subscriptionSettingsView = ((RecommendationItemPresenterImpl) this.b).e;
            if (subscriptionSettingsView != null) {
                subscriptionSettingsView.setUnsubscribeLoading(false);
            }
            ((RecommendationItemPresenterImpl) this.b).e((SellerCarouselItem) this.c);
        } else if (i == 1) {
            ((SellerCarouselItem) this.c).setSubscribed(false);
            ((SellerCarouselItem) this.c).setNotificationsActivated(null);
            RecommendationItemPresenterImpl.access$updateSeller((RecommendationItemPresenterImpl) this.b, (SellerCarouselItem) this.c);
            SubscriptionSettingsView subscriptionSettingsView2 = ((RecommendationItemPresenterImpl) this.b).e;
            if (subscriptionSettingsView2 != null) {
                subscriptionSettingsView2.closeSubscriptionSettings();
            }
        } else {
            throw null;
        }
    }
}
