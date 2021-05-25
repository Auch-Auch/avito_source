package com.avito.android.notification_center.list.item;

import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.notification_center.list.item.NotificationCenterListItem;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/notification_center/list/item/NotificationCenterListItemPresenterImpl;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemPresenter;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemView;", "view", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$Notification;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/notification_center/list/item/NotificationCenterListItemView;Lcom/avito/android/notification_center/list/item/NotificationCenterListItem$Notification;I)V", "Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", "dateFormatter", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemClickListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/date_time_formatter/RelativeDateFormatter;Lcom/avito/android/notification_center/list/item/NotificationCenterListItemClickListener;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterListItemPresenterImpl implements NotificationCenterListItemPresenter {
    public final RelativeDateFormatter a;
    public final NotificationCenterListItemClickListener b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NotificationCenterListItemPresenterImpl a;
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(NotificationCenterListItemPresenterImpl notificationCenterListItemPresenterImpl, int i) {
            super(0);
            this.a = notificationCenterListItemPresenterImpl;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.b.onItemClick(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NotificationCenterListItemView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NotificationCenterListItemView notificationCenterListItemView) {
            super(0);
            this.a = notificationCenterListItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setClickListener(null);
            this.a.setUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public NotificationCenterListItemPresenterImpl(@NotNull RelativeDateFormatter relativeDateFormatter, @NotNull NotificationCenterListItemClickListener notificationCenterListItemClickListener) {
        Intrinsics.checkNotNullParameter(relativeDateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(notificationCenterListItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = relativeDateFormatter;
        this.b = notificationCenterListItemClickListener;
    }

    public void bindView(@NotNull NotificationCenterListItemView notificationCenterListItemView, @NotNull NotificationCenterListItem.Notification notification, int i) {
        Intrinsics.checkNotNullParameter(notificationCenterListItemView, "view");
        Intrinsics.checkNotNullParameter(notification, "item");
        notificationCenterListItemView.setTitle(notification.getTitle());
        notificationCenterListItemView.setDescription(notification.getDescription());
        notificationCenterListItemView.setDate(this.a.format(Long.valueOf(TimeUnit.SECONDS.toMillis(notification.getDate()))));
        if (notification.isRead()) {
            notificationCenterListItemView.hideIndicator();
        } else {
            notificationCenterListItemView.showIndicator();
        }
        notificationCenterListItemView.setClickListener(new a(this, i));
        notificationCenterListItemView.setUnbindListener(new b(notificationCenterListItemView));
    }
}
