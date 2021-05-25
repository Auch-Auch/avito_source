package com.avito.android.messenger.service.direct_reply;

import a2.b.a.a.a;
import android.app.IntentService;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.app.core.R;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.messenger.di.DaggerDirectReplyServiceComponent;
import com.avito.android.messenger.di.DirectReplyServiceDependencies;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegate;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.remote.notification.NotificationIdentifier;
import com.avito.android.util.ToastsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/avito/android/messenger/service/direct_reply/DirectReplyIntentService;", "Landroid/app/IntentService;", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate$NotificationController;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleIntent", "(Landroid/content/Intent;)V", "Lcom/avito/android/remote/notification/NotificationIdentifier;", "identifier", "cancelNotification", "(Lcom/avito/android/remote/notification/NotificationIdentifier;)V", "", "channelId", "text", MessageBody.RANDOM_ID, "showFailureNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "id", "showToast", "(I)V", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "Lcom/avito/android/ServiceIntentFactory;", "getServiceIntentFactory", "()Lcom/avito/android/ServiceIntentFactory;", "setServiceIntentFactory", "(Lcom/avito/android/ServiceIntentFactory;)V", "Landroidx/core/app/NotificationManagerCompat;", "notificationManagerCompat", "Landroidx/core/app/NotificationManagerCompat;", "getNotificationManagerCompat", "()Landroidx/core/app/NotificationManagerCompat;", "setNotificationManagerCompat", "(Landroidx/core/app/NotificationManagerCompat;)V", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate;", "delegate", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate;", "getDelegate", "()Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate;", "setDelegate", "(Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate;)V", "<init>", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DirectReplyIntentService extends IntentService implements DirectReplyServiceDelegate.NotificationController {
    @Inject
    public DirectReplyServiceDelegate delegate;
    @Inject
    public NotificationManagerCompat notificationManagerCompat;
    @Inject
    public ServiceIntentFactory serviceIntentFactory;

    public DirectReplyIntentService() {
        super("DirectReplyIntentService");
        setIntentRedelivery(true);
    }

    @Override // com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegate.NotificationController
    public void cancelNotification(@NotNull NotificationIdentifier notificationIdentifier) {
        Intrinsics.checkNotNullParameter(notificationIdentifier, "identifier");
        NotificationManagerCompat notificationManagerCompat2 = this.notificationManagerCompat;
        if (notificationManagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerCompat");
        }
        notificationManagerCompat2.cancel(notificationIdentifier.getTag(), notificationIdentifier.getId());
    }

    @NotNull
    public final DirectReplyServiceDelegate getDelegate() {
        DirectReplyServiceDelegate directReplyServiceDelegate = this.delegate;
        if (directReplyServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return directReplyServiceDelegate;
    }

    @NotNull
    public final NotificationManagerCompat getNotificationManagerCompat() {
        NotificationManagerCompat notificationManagerCompat2 = this.notificationManagerCompat;
        if (notificationManagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerCompat");
        }
        return notificationManagerCompat2;
    }

    @NotNull
    public final ServiceIntentFactory getServiceIntentFactory() {
        ServiceIntentFactory serviceIntentFactory2 = this.serviceIntentFactory;
        if (serviceIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceIntentFactory");
        }
        return serviceIntentFactory2;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DaggerDirectReplyServiceComponent.builder().directReplyServiceDependencies((DirectReplyServiceDependencies) ComponentDependenciesKt.getDependencies(DirectReplyServiceDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).build().inject(this);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(@Nullable Intent intent) {
        String stringExtra;
        String str;
        CharSequence charSequence;
        if (intent != null && (stringExtra = intent.getStringExtra("channel_id")) != null) {
            String stringExtra2 = intent.getStringExtra("direct_reply_key");
            NotificationIdentifier notificationIdentifier = (NotificationIdentifier) intent.getParcelableExtra("notification_id");
            if (stringExtra2 != null) {
                Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
                str = (resultsFromIntent == null || (charSequence = resultsFromIntent.getCharSequence(stringExtra2)) == null) ? null : charSequence.toString();
            } else {
                str = intent.getStringExtra("text");
            }
            boolean booleanExtra = intent.getBooleanExtra("is_retry", false);
            String stringExtra3 = intent.getStringExtra("random_id");
            DirectReplyServiceDelegate directReplyServiceDelegate = this.delegate;
            if (directReplyServiceDelegate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("delegate");
            }
            directReplyServiceDelegate.sendMessageAndReadChat(stringExtra, str, notificationIdentifier, this, booleanExtra, stringExtra3);
        }
    }

    public final void setDelegate(@NotNull DirectReplyServiceDelegate directReplyServiceDelegate) {
        Intrinsics.checkNotNullParameter(directReplyServiceDelegate, "<set-?>");
        this.delegate = directReplyServiceDelegate;
    }

    public final void setNotificationManagerCompat(@NotNull NotificationManagerCompat notificationManagerCompat2) {
        Intrinsics.checkNotNullParameter(notificationManagerCompat2, "<set-?>");
        this.notificationManagerCompat = notificationManagerCompat2;
    }

    public final void setServiceIntentFactory(@NotNull ServiceIntentFactory serviceIntentFactory2) {
        Intrinsics.checkNotNullParameter(serviceIntentFactory2, "<set-?>");
        this.serviceIntentFactory = serviceIntentFactory2;
    }

    @Override // com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegate.NotificationController
    public void showFailureNotification(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "channelId", str2, "text", str3, MessageBody.RANDOM_ID);
        ServiceIntentFactory serviceIntentFactory2 = this.serviceIntentFactory;
        if (serviceIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceIntentFactory");
        }
        Intent sendMessageServiceIntent = serviceIntentFactory2.sendMessageServiceIntent(str, str2, true, str3);
        int hashCode = str2.hashCode() + (str.hashCode() * 31);
        NotificationManagerCompat notificationManagerCompat2 = this.notificationManagerCompat;
        if (notificationManagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerCompat");
        }
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this, getString(R.string.notification_channel_id_default)).setContentTitle(getString(com.avito.android.messenger.R.string.messenger_direct_reply_message_not_sent)).setContentText(getString(com.avito.android.messenger.R.string.messenger_direct_reply_tap_to_resend, new Object[]{str2})).setSmallIcon(com.avito.android.ui_components.R.drawable.ic_notification).setContentIntent(PendingIntent.getService(getApplicationContext(), 100, sendMessageServiceIntent, 134217728)).setColor(ContextCompat.getColor(this, com.avito.android.lib.design.avito.R.color.avito_red)).setAutoCancel(true);
        Intrinsics.checkNotNullExpressionValue(autoCancel, "NotificationCompat.Build…     .setAutoCancel(true)");
        notificationManagerCompat2.notify("tag_channel", hashCode, autoCancel.build());
    }

    @Override // com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegate.NotificationController
    public void showToast(@StringRes int i) {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        ToastsKt.showToast$default(applicationContext, i, 0, 2, (Object) null);
    }
}
