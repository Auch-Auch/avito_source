package a2.a.a.p1.a.a;

import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ NotificationCenterLandingFeedbackPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(NotificationCenterLandingFeedbackPresenterImpl notificationCenterLandingFeedbackPresenterImpl) {
        super(1);
        this.a = notificationCenterLandingFeedbackPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        this.a.b();
        return Unit.INSTANCE;
    }
}
