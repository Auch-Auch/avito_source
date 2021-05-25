package a2.a.a.p1.a.d;

import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenterImpl;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedRouter;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class c<T> implements Consumer<Unit> {
    public final /* synthetic */ NotificationCenterLandingUnifiedPresenterImpl a;

    public c(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl) {
        this.a = notificationCenterLandingUnifiedPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        NotificationCenterLandingUnifiedRouter notificationCenterLandingUnifiedRouter = this.a.b;
        if (notificationCenterLandingUnifiedRouter != null) {
            notificationCenterLandingUnifiedRouter.leaveScreen();
        }
    }
}
