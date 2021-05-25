package com.avito.android.social_management.adapter.notification;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social_management.adapter.SocialItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction;", "", "<init>", "()V", "CrossClick", "DeepLinkClick", "Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction$CrossClick;", "Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction$DeepLinkClick;", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public abstract class SocialNotificationAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction$CrossClick;", "Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction;", "Lcom/avito/android/social_management/adapter/SocialItem$Notification;", AuthSource.SEND_ABUSE, "Lcom/avito/android/social_management/adapter/SocialItem$Notification;", "getNotification", "()Lcom/avito/android/social_management/adapter/SocialItem$Notification;", "notification", "<init>", "(Lcom/avito/android/social_management/adapter/SocialItem$Notification;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
    public static final class CrossClick extends SocialNotificationAction {
        @NotNull
        public final SocialItem.Notification a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CrossClick(@NotNull SocialItem.Notification notification) {
            super(null);
            Intrinsics.checkNotNullParameter(notification, "notification");
            this.a = notification;
        }

        @NotNull
        public final SocialItem.Notification getNotification() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction$DeepLinkClick;", "Lcom/avito/android/social_management/adapter/notification/SocialNotificationAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/social_management/adapter/SocialItem$Notification;", AuthSource.SEND_ABUSE, "Lcom/avito/android/social_management/adapter/SocialItem$Notification;", "getNotification", "()Lcom/avito/android/social_management/adapter/SocialItem$Notification;", "notification", "<init>", "(Lcom/avito/android/social_management/adapter/SocialItem$Notification;Lcom/avito/android/deep_linking/links/DeepLink;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeepLinkClick extends SocialNotificationAction {
        @NotNull
        public final SocialItem.Notification a;
        @NotNull
        public final DeepLink b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeepLinkClick(@NotNull SocialItem.Notification notification, @NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(notification, "notification");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = notification;
            this.b = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.b;
        }

        @NotNull
        public final SocialItem.Notification getNotification() {
            return this.a;
        }
    }

    public SocialNotificationAction() {
    }

    public SocialNotificationAction(j jVar) {
    }
}
