package a2.a.a.p1.a.c;

import android.net.Uri;
import com.avito.android.notification_center.landing.share.NotificationCenterLandingSharePresenter;
import com.avito.android.notification_center.landing.share.NotificationCenterLandingShareRouter;
import com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<LoadingState<? super Uri>> {
    public final /* synthetic */ NotificationCenterLandingSharePresenter.Impl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public a(NotificationCenterLandingSharePresenter.Impl impl, String str, String str2) {
        this.a = impl;
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super Uri> loadingState) {
        NotificationCenterLandingShareRouter notificationCenterLandingShareRouter;
        LoadingState<? super Uri> loadingState2 = loadingState;
        this.a.c();
        NotificationCenterLandingShareView notificationCenterLandingShareView = this.a.f;
        if (notificationCenterLandingShareView != null) {
            notificationCenterLandingShareView.hideProgressDialog();
        }
        if (loadingState2 instanceof LoadingState.Error) {
            TypedError error = ((LoadingState.Error) loadingState2).getError();
            if (error instanceof ErrorResult) {
                NotificationCenterLandingShareView notificationCenterLandingShareView2 = this.a.f;
                if (notificationCenterLandingShareView2 != null) {
                    notificationCenterLandingShareView2.showMessage(((ErrorResult) error).getMessage());
                    return;
                }
                return;
            }
            NotificationCenterLandingShareView notificationCenterLandingShareView3 = this.a.f;
            if (notificationCenterLandingShareView3 != null) {
                notificationCenterLandingShareView3.showMessage();
            }
        } else if ((loadingState2 instanceof LoadingState.Loaded) && (notificationCenterLandingShareRouter = this.a.e) != null) {
            notificationCenterLandingShareRouter.share(this.b, this.c, (Uri) ((LoadingState.Loaded) loadingState2).getData());
        }
    }
}
