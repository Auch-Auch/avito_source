package a2.a.a.h2.a;

import com.avito.android.remote.notification.UnreadNotificationsInteractorImpl;
import java.util.concurrent.Callable;
public final class c<V> implements Callable<Integer> {
    public final /* synthetic */ UnreadNotificationsInteractorImpl a;

    public c(UnreadNotificationsInteractorImpl unreadNotificationsInteractorImpl) {
        this.a = unreadNotificationsInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        return Integer.valueOf(this.a.d.getUnreadChangesCount());
    }
}
