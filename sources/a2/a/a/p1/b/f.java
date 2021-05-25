package a2.a.a.p1.b;

import com.avito.android.notification_center.list.NotificationCenterListPresenterImpl;
import com.avito.android.remote.model.notification.NotificationsResponse;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<NotificationsResponse> {
    public final /* synthetic */ NotificationCenterListPresenterImpl a;

    public f(NotificationCenterListPresenterImpl notificationCenterListPresenterImpl) {
        this.a = notificationCenterListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(NotificationsResponse notificationsResponse) {
        this.a.d = notificationsResponse.getNextPage();
    }
}
