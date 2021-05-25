package a2.a.a.p1.a.d;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenterImpl;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedRouter;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItem;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<UnifiedSubtitleItem> {
    public final /* synthetic */ NotificationCenterLandingUnifiedPresenterImpl a;

    public f(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl) {
        this.a = notificationCenterLandingUnifiedPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(UnifiedSubtitleItem unifiedSubtitleItem) {
        NotificationCenterLandingUnifiedRouter notificationCenterLandingUnifiedRouter;
        UnifiedSubtitleItem unifiedSubtitleItem2 = unifiedSubtitleItem;
        NotificationCenterLandingUnifiedPresenterImpl.access$sendEvent(this.a, unifiedSubtitleItem2.getAnalyticParams());
        DeepLink deepLink = unifiedSubtitleItem2.getDeepLink();
        if (deepLink != null && (notificationCenterLandingUnifiedRouter = this.a.b) != null) {
            notificationCenterLandingUnifiedRouter.followDeepLink(deepLink);
        }
    }
}
