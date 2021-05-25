package com.avito.android.push;

import android.content.Context;
import com.avito.android.NotificationWorkFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.notification.NotificationParameters;
import com.avito.android.remote.notification.NotificationServiceKt;
import com.avito.android.remote.notification.NotificationSystemSettingsLogger;
import com.avito.android.service.SafeServiceStarter;
import com.avito.android.social.AppleSignInManagerKt;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/push/MessagingServiceDelegate;", "", "Lcom/avito/android/push/PushToken;", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "", "updateTokenOnServer", "(Lcom/avito/android/push/PushToken;)V", "Landroid/content/Context;", "context", "Lcom/avito/android/push/Push;", "push", "handlePush", "(Landroid/content/Context;Lcom/avito/android/push/Push;)V", "Lcom/avito/android/push/MessagingInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/push/MessagingInteractor;", "messagingInteractor", "Lcom/avito/android/service/SafeServiceStarter;", "c", "Lcom/avito/android/service/SafeServiceStarter;", "safeServiceStarter", "Lcom/avito/android/NotificationWorkFactory;", "d", "Lcom/avito/android/NotificationWorkFactory;", "workFactory", "Lcom/avito/android/remote/notification/NotificationSystemSettingsLogger;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/notification/NotificationSystemSettingsLogger;", "notificationSystemSettingsLogger", "Lcom/avito/android/push/CallPushHandler;", "e", "Lcom/avito/android/push/CallPushHandler;", "callPushHandler", "<init>", "(Lcom/avito/android/push/MessagingInteractor;Lcom/avito/android/remote/notification/NotificationSystemSettingsLogger;Lcom/avito/android/service/SafeServiceStarter;Lcom/avito/android/NotificationWorkFactory;Lcom/avito/android/push/CallPushHandler;)V", "push_release"}, k = 1, mv = {1, 4, 2})
public final class MessagingServiceDelegate {
    public final MessagingInteractor a;
    public final NotificationSystemSettingsLogger b;
    public final SafeServiceStarter c;
    public final NotificationWorkFactory d;
    public final CallPushHandler e;

    @Inject
    public MessagingServiceDelegate(@NotNull MessagingInteractor messagingInteractor, @NotNull NotificationSystemSettingsLogger notificationSystemSettingsLogger, @NotNull SafeServiceStarter safeServiceStarter, @NotNull NotificationWorkFactory notificationWorkFactory, @NotNull CallPushHandler callPushHandler) {
        Intrinsics.checkNotNullParameter(messagingInteractor, "messagingInteractor");
        Intrinsics.checkNotNullParameter(notificationSystemSettingsLogger, "notificationSystemSettingsLogger");
        Intrinsics.checkNotNullParameter(safeServiceStarter, "safeServiceStarter");
        Intrinsics.checkNotNullParameter(notificationWorkFactory, "workFactory");
        Intrinsics.checkNotNullParameter(callPushHandler, "callPushHandler");
        this.a = messagingInteractor;
        this.b = notificationSystemSettingsLogger;
        this.c = safeServiceStarter;
        this.d = notificationWorkFactory;
        this.e = callPushHandler;
    }

    public final void handlePush(@NotNull Context context, @NotNull Push push) {
        NotificationParameters handleMessage;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(push, "push");
        this.b.handleMessage();
        Map<String, String> data = push.getData();
        if (data == null) {
            data = r.emptyMap();
        }
        if (!Intrinsics.areEqual(data.get("adjust_purpose"), "uninstall detection") && !this.e.handlePush(push) && (handleMessage = this.a.handleMessage(data)) != null && !this.e.handlePushDeepLink(handleMessage.getLink())) {
            this.c.start(context, NotificationServiceKt.notificationServiceIntent(context, handleMessage));
        }
    }

    public final void updateTokenOnServer(@NotNull PushToken pushToken) {
        Intrinsics.checkNotNullParameter(pushToken, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        this.d.enqueuePushTokenUpdate(pushToken);
        this.e.updatePushToken(pushToken);
    }
}
