package com.avito.android.notification_center.counter;

import com.avito.android.remote.model.notification.NotificationsCount;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "", "", "hasCount", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/notification/NotificationsCount;", "getCount", "()Lio/reactivex/rxjava3/core/Observable;", "notification_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterCounterInteractor {
    @NotNull
    Observable<NotificationsCount> getCount();

    boolean hasCount();
}
