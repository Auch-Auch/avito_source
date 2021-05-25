package com.avito.android.push;

import android.app.Service;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.push.PushToken;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.Logs;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/push/MessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "", "onCreate", "()V", "", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "onNewToken", "(Ljava/lang/String;)V", "Lcom/google/firebase/messaging/RemoteMessage;", "remoteMessage", "onMessageReceived", "(Lcom/google/firebase/messaging/RemoteMessage;)V", "Lcom/avito/android/push/MessagingServiceDelegate;", "delegate", "Lcom/avito/android/push/MessagingServiceDelegate;", "getDelegate$push_release", "()Lcom/avito/android/push/MessagingServiceDelegate;", "setDelegate$push_release", "(Lcom/avito/android/push/MessagingServiceDelegate;)V", "<init>", "push_release"}, k = 1, mv = {1, 4, 2})
public final class MessagingService extends FirebaseMessagingService {
    @Inject
    public MessagingServiceDelegate delegate;

    @NotNull
    public final MessagingServiceDelegate getDelegate$push_release() {
        MessagingServiceDelegate messagingServiceDelegate = this.delegate;
        if (messagingServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return messagingServiceDelegate;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DaggerMessagingComponent.factory().create((MessagingDependencies) ComponentDependenciesKt.getDependencies(MessagingDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).inject(this);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(@NotNull RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        super.onMessageReceived(remoteMessage);
        Map<String, String> data = remoteMessage.getData();
        Intrinsics.checkNotNullExpressionValue(data, "remoteMessage.data");
        Logs.debug$default("FCM_MessagingService", "onMessageReceived: from=" + remoteMessage.getFrom() + ", data=" + data, null, 4, null);
        Push push = new Push(data, remoteMessage.getFrom(), remoteMessage.getOriginalPriority(), remoteMessage.getPriority(), remoteMessage.getTtl(), remoteMessage.getSentTime());
        MessagingServiceDelegate messagingServiceDelegate = this.delegate;
        if (messagingServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        messagingServiceDelegate.handlePush(this, push);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        Logs.debug$default("FCM_MessagingService", "onNewToken: token=" + str, null, 4, null);
        MessagingServiceDelegate messagingServiceDelegate = this.delegate;
        if (messagingServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        messagingServiceDelegate.updateTokenOnServer(new PushToken.GcmToken(str));
    }

    public final void setDelegate$push_release(@NotNull MessagingServiceDelegate messagingServiceDelegate) {
        Intrinsics.checkNotNullParameter(messagingServiceDelegate, "<set-?>");
        this.delegate = messagingServiceDelegate;
    }
}
