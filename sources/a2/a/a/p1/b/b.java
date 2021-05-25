package a2.a.a.p1.b;

import com.avito.android.notification_center.list.NotificationCenterListPresenterImpl;
import com.avito.android.notification_center.list.item.NotificationCenterListItem;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<NotificationCenterListItem.ErrorSnippet> {
    public final /* synthetic */ NotificationCenterListPresenterImpl a;

    public b(NotificationCenterListPresenterImpl notificationCenterListPresenterImpl) {
        this.a = notificationCenterListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(NotificationCenterListItem.ErrorSnippet errorSnippet) {
        this.a.c = null;
        this.a.c();
    }
}
