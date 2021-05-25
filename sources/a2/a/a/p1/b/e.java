package a2.a.a.p1.b;

import com.avito.android.remote.model.notification.Notification;
import com.avito.android.remote.model.notification.NotificationsResponse;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<NotificationsResponse, List<? extends Notification>> {
    public final /* synthetic */ List a;

    public e(List list) {
        this.a = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends Notification> apply(NotificationsResponse notificationsResponse) {
        NotificationsResponse notificationsResponse2 = notificationsResponse;
        Intrinsics.checkNotNullParameter(notificationsResponse2, "it");
        List<Notification> notifications = notificationsResponse2.getNotifications();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(notifications, 10));
        int i = 0;
        for (T t : notifications) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            arrayList.add(new Notification(t2.getId(), t2.getTitle(), t2.getDescription(), t2.getDate(), t2.isRead(), t2.getUri(), t2.getAnalyticParams()));
            i = i2;
        }
        return CollectionsKt___CollectionsKt.plus((Collection) this.a, (Iterable) arrayList);
    }
}
