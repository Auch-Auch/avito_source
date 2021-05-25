package a2.a.a.p1.a.d;

import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenterImpl;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedView;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class e<T> implements Consumer<Unit> {
    public final /* synthetic */ NotificationCenterLandingUnifiedPresenterImpl a;
    public final /* synthetic */ NotificationCenterLandingUnifiedView b;

    public e(NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl, NotificationCenterLandingUnifiedView notificationCenterLandingUnifiedView) {
        this.a = notificationCenterLandingUnifiedPresenterImpl;
        this.b = notificationCenterLandingUnifiedView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.b.showProgress();
        this.a.c();
    }
}
