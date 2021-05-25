package com.avito.android.social_management.adapter.notification;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social_management.adapter.SocialItem;
import com.avito.android.social_management.adapter.notification.SocialNotificationAction;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/social_management/adapter/notification/NotificationItemPresenterImpl;", "Lcom/avito/android/social_management/adapter/notification/NotificationItemPresenter;", "Lcom/avito/android/social_management/adapter/notification/NotificationItemView;", "view", "Lcom/avito/android/social_management/adapter/SocialItem$Notification;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/social_management/adapter/notification/NotificationItemView;Lcom/avito/android/social_management/adapter/SocialItem$Notification;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "actionsConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationItemPresenterImpl implements NotificationItemPresenter {
    public final Consumer<SocialNotificationAction> a;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((NotificationItemPresenterImpl) this.b).a.accept(new SocialNotificationAction.CrossClick((SocialItem.Notification) this.c));
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((SocialItem.Notification) this.b).getText().setOnDeepLinkClickListener(null);
                ((NotificationItemView) this.c).setUnbindListener(null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public NotificationItemPresenterImpl(@NotNull Consumer<SocialNotificationAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "actionsConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull NotificationItemView notificationItemView, @NotNull SocialItem.Notification notification, int i) {
        Intrinsics.checkNotNullParameter(notificationItemView, "view");
        Intrinsics.checkNotNullParameter(notification, "item");
        notificationItemView.setText(notification.getText());
        notification.getText().setOnDeepLinkClickListener(new OnDeepLinkClickListener(this, notification) { // from class: com.avito.android.social_management.adapter.notification.NotificationItemPresenterImpl$bindView$1
            public final /* synthetic */ NotificationItemPresenterImpl a;
            public final /* synthetic */ SocialItem.Notification b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
            public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                NotificationItemPresenterImpl.access$getActionsConsumer$p(this.a).accept(new SocialNotificationAction.DeepLinkClick(this.b, deepLink));
            }
        });
        notificationItemView.setCrossClickListener(new a(0, this, notification));
        notificationItemView.setUnbindListener(new a(1, notification, notificationItemView));
    }
}
