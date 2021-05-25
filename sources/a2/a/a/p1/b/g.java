package a2.a.a.p1.b;

import com.avito.android.notification_center.list.item.NotificationCenterListItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class g extends Lambda implements Function1<NotificationCenterListItem, Boolean> {
    public static final g a = new g();

    public g() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(NotificationCenterListItem notificationCenterListItem) {
        NotificationCenterListItem notificationCenterListItem2 = notificationCenterListItem;
        Intrinsics.checkNotNullParameter(notificationCenterListItem2, "it");
        return Boolean.valueOf(notificationCenterListItem2.getId() == Long.MAX_VALUE);
    }
}
