package a2.a.a.f;

import com.avito.android.advert.AdvertDetailsToolbarPresenterImpl;
import com.avito.android.advert.AdvertDetailsToolbarView;
import com.avito.android.advert.item.AdvertDetailsPresenterKt;
import com.avito.android.remote.model.AdvertDetails;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class i<T> implements Consumer<Boolean> {
    public final /* synthetic */ AdvertDetailsToolbarPresenterImpl a;
    public final /* synthetic */ AdvertDetailsToolbarView b;
    public final /* synthetic */ AdvertDetails c;

    public i(AdvertDetailsToolbarPresenterImpl advertDetailsToolbarPresenterImpl, AdvertDetailsToolbarView advertDetailsToolbarView, AdvertDetails advertDetails) {
        this.a = advertDetailsToolbarPresenterImpl;
        this.b = advertDetailsToolbarView;
        this.c = advertDetails;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        AdvertDetailsToolbarView advertDetailsToolbarView = this.b;
        Intrinsics.checkNotNullExpressionValue(bool2, "isFavorite");
        advertDetailsToolbarView.setFavorite(bool2.booleanValue());
        if (!AdvertDetailsToolbarPresenterImpl.access$isPriceSubscriptionAvailable(this.a, bool2.booleanValue(), this.c)) {
            return;
        }
        if (!this.a.n.getAreNotificationsEnabled()) {
            this.b.showWarningBubble();
        } else if (!this.a.m.getBoolean(AdvertDetailsPresenterKt.PREF_KEY_PRICE_SUBSCRIPTION_BOTTOM_SHEET_SHOWED, false)) {
            this.b.showInfoBubble();
            this.a.m.putBoolean(AdvertDetailsPresenterKt.PREF_KEY_PRICE_SUBSCRIPTION_BOTTOM_SHEET_SHOWED, true);
        }
    }
}
