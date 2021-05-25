package defpackage;

import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenterImpl;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedRouter;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonItem;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: k2  reason: default package */
public final class k2<T> implements Consumer<UnifiedPairButtonItem> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public k2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(UnifiedPairButtonItem unifiedPairButtonItem) {
        int i = this.a;
        if (i == 0) {
            UnifiedPairButtonItem unifiedPairButtonItem2 = unifiedPairButtonItem;
            NotificationCenterLandingUnifiedPresenterImpl.access$sendEvent((NotificationCenterLandingUnifiedPresenterImpl) this.b, unifiedPairButtonItem2.getFirstAnalyticParams());
            NotificationCenterLandingUnifiedRouter notificationCenterLandingUnifiedRouter = ((NotificationCenterLandingUnifiedPresenterImpl) this.b).b;
            if (notificationCenterLandingUnifiedRouter != null) {
                notificationCenterLandingUnifiedRouter.followDeepLink(unifiedPairButtonItem2.getFirstDeepLink());
            }
            NotificationCenterLandingUnifiedRouter notificationCenterLandingUnifiedRouter2 = ((NotificationCenterLandingUnifiedPresenterImpl) this.b).b;
            if (notificationCenterLandingUnifiedRouter2 != null) {
                notificationCenterLandingUnifiedRouter2.leaveScreen();
            }
        } else if (i == 1) {
            UnifiedPairButtonItem unifiedPairButtonItem3 = unifiedPairButtonItem;
            NotificationCenterLandingUnifiedPresenterImpl.access$sendEvent((NotificationCenterLandingUnifiedPresenterImpl) this.b, unifiedPairButtonItem3.getSecondAnalyticParams());
            NotificationCenterLandingUnifiedRouter notificationCenterLandingUnifiedRouter3 = ((NotificationCenterLandingUnifiedPresenterImpl) this.b).b;
            if (notificationCenterLandingUnifiedRouter3 != null) {
                notificationCenterLandingUnifiedRouter3.followDeepLink(unifiedPairButtonItem3.getSecondDeepLink());
            }
            NotificationCenterLandingUnifiedRouter notificationCenterLandingUnifiedRouter4 = ((NotificationCenterLandingUnifiedPresenterImpl) this.b).b;
            if (notificationCenterLandingUnifiedRouter4 != null) {
                notificationCenterLandingUnifiedRouter4.leaveScreen();
            }
        } else {
            throw null;
        }
    }
}
