package a2.a.a.p1.a.a;

import com.avito.android.analytics.event.notification_center.NotificationCenterLandingFeedbackPositiveActionClickEvent;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenterImpl;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingFeedback;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ NotificationCenterLandingFeedbackPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(NotificationCenterLandingFeedbackPresenterImpl notificationCenterLandingFeedbackPresenterImpl) {
        super(1);
        this.a = notificationCenterLandingFeedbackPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        NotificationCenterLandingFeedback notificationCenterLandingFeedback = this.a.c;
        if (notificationCenterLandingFeedback != null) {
            Map<String, String> analyticParams = notificationCenterLandingFeedback.getAnalyticParams();
            if (analyticParams != null) {
                this.a.j.track(new NotificationCenterLandingFeedbackPositiveActionClickEvent(analyticParams));
            }
            NotificationCenterLandingFeedbackPresenterImpl.access$sendFeedbackResult(this.a, true);
        }
        return Unit.INSTANCE;
    }
}
