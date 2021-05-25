package a2.a.a.p1.b;

import com.avito.android.notification_center.list.NotificationCenterListPresenterImpl;
import com.avito.android.util.TypedResultException;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ NotificationCenterListPresenterImpl a;

    public d(NotificationCenterListPresenterImpl notificationCenterListPresenterImpl) {
        this.a = notificationCenterListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        if (th2 instanceof TypedResultException) {
            this.a.c = ((TypedResultException) th2).getMessage();
            this.a.c();
        }
    }
}
