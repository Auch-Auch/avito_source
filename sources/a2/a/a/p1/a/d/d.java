package a2.a.a.p1.a.d;

import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenterImpl;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedRouter;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonItem;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<UnifiedButtonItem> {
    public final /* synthetic */ NotificationCenterLandingUnifiedPresenterImpl a;

    public d(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl) {
        this.a = notificationCenterLandingUnifiedPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(UnifiedButtonItem unifiedButtonItem) {
        UnifiedButtonItem unifiedButtonItem2 = unifiedButtonItem;
        NotificationCenterLandingUnifiedPresenterImpl.access$sendEvent(this.a, unifiedButtonItem2.getAnalyticParams());
        NotificationCenterLandingUnifiedRouter notificationCenterLandingUnifiedRouter = this.a.b;
        if (notificationCenterLandingUnifiedRouter != null) {
            notificationCenterLandingUnifiedRouter.followDeepLink(unifiedButtonItem2.getDeepLink());
        }
        NotificationCenterLandingUnifiedRouter notificationCenterLandingUnifiedRouter2 = this.a.b;
        if (notificationCenterLandingUnifiedRouter2 != null) {
            notificationCenterLandingUnifiedRouter2.leaveScreen();
        }
    }
}
