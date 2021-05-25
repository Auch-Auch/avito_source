package com.avito.android.notification_center.list;

import com.avito.android.notification_center.list.NotificationCenterListView;
import com.avito.android.notification_center.list.item.NotificationCenterListItemClickListener;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/notification_center/list/NotificationCenterListPresenter;", "Lcom/avito/android/notification_center/list/NotificationCenterListView$Callback;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemClickListener;", "Lcom/avito/android/notification_center/list/NotificationCenterListRouter;", "router", "", "attachRouter", "(Lcom/avito/android/notification_center/list/NotificationCenterListRouter;)V", "detachRouter", "()V", "Lcom/avito/android/notification_center/list/NotificationCenterListView;", "view", "attachView", "(Lcom/avito/android/notification_center/list/NotificationCenterListView;)V", "detachView", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterListPresenter extends NotificationCenterListView.Callback, AppendingListener, NotificationCenterListItemClickListener {
    void attachRouter(@NotNull NotificationCenterListRouter notificationCenterListRouter);

    void attachView(@NotNull NotificationCenterListView notificationCenterListView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle getState();
}
