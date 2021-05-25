package a2.a.a.p1.a.d;

import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenterImpl;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedRouter;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItem;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<UnifiedAdvertItem> {
    public final /* synthetic */ NotificationCenterLandingUnifiedPresenterImpl a;

    public a(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl) {
        this.a = notificationCenterLandingUnifiedPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(UnifiedAdvertItem unifiedAdvertItem) {
        UnifiedAdvertItem unifiedAdvertItem2 = unifiedAdvertItem;
        NotificationCenterLandingUnifiedPresenterImpl.access$sendEvent(this.a, unifiedAdvertItem2.getAnalyticParams());
        NotificationCenterLandingUnifiedRouter notificationCenterLandingUnifiedRouter = this.a.b;
        if (notificationCenterLandingUnifiedRouter != null) {
            notificationCenterLandingUnifiedRouter.followDeepLink(unifiedAdvertItem2.getDeepLink());
        }
    }
}
