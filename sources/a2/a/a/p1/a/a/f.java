package a2.a.a.p1.a.a;

import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenterImpl;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackRouter;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function1<LoadingState<? super String>, Unit> {
    public final /* synthetic */ NotificationCenterLandingFeedbackPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(NotificationCenterLandingFeedbackPresenterImpl notificationCenterLandingFeedbackPresenterImpl) {
        super(1);
        this.a = notificationCenterLandingFeedbackPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(LoadingState<? super String> loadingState) {
        NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView;
        LoadingState<? super String> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView2 = this.a.b;
            if (notificationCenterLandingFeedbackView2 != null) {
                notificationCenterLandingFeedbackView2.showProgressDialog();
            }
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView3 = this.a.b;
            if (notificationCenterLandingFeedbackView3 != null) {
                notificationCenterLandingFeedbackView3.showResultMessage((String) ((LoadingState.Loaded) loadingState2).getData());
            }
            NotificationCenterLandingFeedbackRouter notificationCenterLandingFeedbackRouter = this.a.d;
            if (notificationCenterLandingFeedbackRouter != null) {
                notificationCenterLandingFeedbackRouter.leaveScreen();
            }
        } else if (loadingState2 instanceof LoadingState.Error) {
            TypedError error = ((LoadingState.Error) loadingState2).getError();
            if ((error instanceof ErrorResult) && (notificationCenterLandingFeedbackView = this.a.b) != null) {
                notificationCenterLandingFeedbackView.showResultMessage(((ErrorResult) error).getMessage());
            }
            NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView4 = this.a.b;
            if (notificationCenterLandingFeedbackView4 != null) {
                notificationCenterLandingFeedbackView4.hideProgressDialog();
            }
        }
        return Unit.INSTANCE;
    }
}
