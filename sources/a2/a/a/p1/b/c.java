package a2.a.a.p1.b;

import com.avito.android.notification_center.list.NotificationCenterListPresenterImpl;
import com.avito.android.remote.model.notification.Notification;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class c<T> implements Consumer<List<? extends Notification>> {
    public final /* synthetic */ NotificationCenterListPresenterImpl a;

    public c(NotificationCenterListPresenterImpl notificationCenterListPresenterImpl) {
        this.a = notificationCenterListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends Notification> list) {
        this.a.b = list;
        this.a.c();
    }
}
