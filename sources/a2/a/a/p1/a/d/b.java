package a2.a.a.p1.a.d;

import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenterImpl;
import com.avito.android.serp.adapter.FavorableItem;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<FavorableItem> {
    public final /* synthetic */ NotificationCenterLandingUnifiedPresenterImpl a;

    public b(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl) {
        this.a = notificationCenterLandingUnifiedPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(FavorableItem favorableItem) {
        FavorableItem favorableItem2 = favorableItem;
        FavoriteAdvertsPresenter favoriteAdvertsPresenter = this.a.t;
        Intrinsics.checkNotNullExpressionValue(favorableItem2, "it");
        favoriteAdvertsPresenter.onFavoriteButtonClicked(favorableItem2);
    }
}
