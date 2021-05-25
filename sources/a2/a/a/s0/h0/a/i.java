package a2.a.a.s0.h0.a;

import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl;
import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class i<T> implements Consumer<Disposable> {
    public final /* synthetic */ RecommendationItemPresenterImpl a;

    public i(RecommendationItemPresenterImpl recommendationItemPresenterImpl) {
        this.a = recommendationItemPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        SubscriptionSettingsView subscriptionSettingsView = this.a.e;
        if (subscriptionSettingsView != null) {
            subscriptionSettingsView.setUnsubscribeLoading(true);
        }
    }
}
