package com.avito.android.remote.notification;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.DaggerNotificationServiceComponent;
import com.avito.android.di.NotificationServiceDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.SafeServiceStarter;
import com.avito.android.service.ServiceCountdownHandler;
import com.avito.android.util.Logs;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b0\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0012\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010(\u001a\u00060%R\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/avito/android/remote/notification/NotificationService;", "Landroid/app/Service;", "Lcom/avito/android/service/ServiceCountdownHandler$Listener;", "", "onCreate", "()V", "onDestroy", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "onUnbind", "(Landroid/content/Intent;)Z", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "lastStartId", "onStop", "(I)V", "Lcom/avito/android/service/ServiceCountdownHandler;", "countdownHandler", "Lcom/avito/android/service/ServiceCountdownHandler;", "getCountdownHandler", "()Lcom/avito/android/service/ServiceCountdownHandler;", "setCountdownHandler", "(Lcom/avito/android/service/ServiceCountdownHandler;)V", "Lcom/avito/android/service/SafeServiceStarter;", "safeStarter", "Lcom/avito/android/service/SafeServiceStarter;", "getSafeStarter", "()Lcom/avito/android/service/SafeServiceStarter;", "setSafeStarter", "(Lcom/avito/android/service/SafeServiceStarter;)V", "Lcom/avito/android/remote/notification/NotificationService$LocalBinder;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/notification/NotificationService$LocalBinder;", "binder", "Lcom/avito/android/remote/notification/NotificationServiceInteractor;", "interactor", "Lcom/avito/android/remote/notification/NotificationServiceInteractor;", "getInteractor", "()Lcom/avito/android/remote/notification/NotificationServiceInteractor;", "setInteractor", "(Lcom/avito/android/remote/notification/NotificationServiceInteractor;)V", "<init>", "LocalBinder", "notification_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationService extends Service implements ServiceCountdownHandler.Listener {
    public final LocalBinder a = new LocalBinder();
    @Inject
    public ServiceCountdownHandler countdownHandler;
    @Inject
    public NotificationServiceInteractor interactor;
    @Inject
    public SafeServiceStarter safeStarter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/notification/NotificationService$LocalBinder;", "Landroid/os/Binder;", "Lcom/avito/android/remote/notification/NotificationProvider;", "getNotificationProvider", "()Lcom/avito/android/remote/notification/NotificationProvider;", "notificationProvider", "<init>", "(Lcom/avito/android/remote/notification/NotificationService;)V", "notification_release"}, k = 1, mv = {1, 4, 2})
    public final class LocalBinder extends Binder {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public LocalBinder() {
        }

        @NotNull
        public final NotificationProvider getNotificationProvider() {
            return NotificationService.this.getInteractor();
        }
    }

    @NotNull
    public final ServiceCountdownHandler getCountdownHandler() {
        ServiceCountdownHandler serviceCountdownHandler = this.countdownHandler;
        if (serviceCountdownHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countdownHandler");
        }
        return serviceCountdownHandler;
    }

    @NotNull
    public final NotificationServiceInteractor getInteractor() {
        NotificationServiceInteractor notificationServiceInteractor = this.interactor;
        if (notificationServiceInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return notificationServiceInteractor;
    }

    @NotNull
    public final SafeServiceStarter getSafeStarter() {
        SafeServiceStarter safeServiceStarter = this.safeStarter;
        if (safeServiceStarter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safeStarter");
        }
        return safeServiceStarter;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logs.verbose$default("NotificationService", "onBind", null, 4, null);
        return this.a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Logs.debug$default("NotificationService", "onCreate", null, 4, null);
        DaggerNotificationServiceComponent.builder().dependencies((NotificationServiceDependencies) ComponentDependenciesKt.getDependencies(NotificationServiceDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).withName("NotificationService").withCountdownHandlerListener(null).build().inject(this);
        ServiceCountdownHandler serviceCountdownHandler = this.countdownHandler;
        if (serviceCountdownHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countdownHandler");
        }
        serviceCountdownHandler.setListener(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Logs.debug$default("NotificationService", "onDestroy", null, 4, null);
        super.onDestroy();
    }

    @Override // com.avito.android.service.ServiceCountdownHandler.Listener
    public void onStart() {
        ServiceCountdownHandler.Listener.DefaultImpls.onStart(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048 A[SYNTHETIC, Splitter:B:16:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008e  */
    @Override // android.app.Service
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(@org.jetbrains.annotations.Nullable android.content.Intent r3, int r4, int r5) {
        /*
            r2 = this;
            super.onStartCommand(r3, r4, r5)
            r4 = 1
            if (r3 == 0) goto L_0x0017
            com.avito.android.service.SafeServiceStarter r0 = r2.safeStarter
            if (r0 != 0) goto L_0x000f
            java.lang.String r1 = "safeStarter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x000f:
            boolean r0 = r0.needForeground(r3)
            if (r0 == 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x003a
            android.content.res.Resources r0 = r2.getResources()
            int r1 = com.avito.android.app.core.R.string.notification_channel_id_default
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "resources.getString(com.…ation_channel_id_default)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder
            r1.<init>(r2, r0)
            android.app.Notification r0 = r1.build()
            java.lang.String r1 = "NotificationCompat.Build…(this, channelId).build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.startForeground(r4, r0)
        L_0x003a:
            com.avito.android.service.ServiceCountdownHandler r4 = r2.countdownHandler
            java.lang.String r0 = "countdownHandler"
            if (r4 != 0) goto L_0x0043
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
        L_0x0043:
            r4.onStartAction(r5)
            if (r3 == 0) goto L_0x008a
            java.lang.String r4 = r3.getAction()     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x008a
            java.lang.String r4 = r3.getAction()     // Catch:{ all -> 0x007e }
            if (r4 != 0) goto L_0x0055
            goto L_0x008a
        L_0x0055:
            int r5 = r4.hashCode()     // Catch:{ all -> 0x007e }
            r1 = 624410341(0x2537bee5, float:1.5937397E-16)
            if (r5 == r1) goto L_0x005f
            goto L_0x008a
        L_0x005f:
            java.lang.String r5 = "com.avito.android.PUSH_NOTIFICATION"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x008a
            java.lang.String r4 = "notification"
            android.os.Parcelable r3 = r3.getParcelableExtra(r4)     // Catch:{ all -> 0x007e }
            com.avito.android.remote.notification.NotificationParameters r3 = (com.avito.android.remote.notification.NotificationParameters) r3     // Catch:{ all -> 0x007e }
            if (r3 == 0) goto L_0x008a
            com.avito.android.remote.notification.NotificationServiceInteractor r4 = r2.interactor     // Catch:{ all -> 0x007e }
            if (r4 != 0) goto L_0x007a
            java.lang.String r5 = "interactor"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x007e }
        L_0x007a:
            r4.handleNotification(r3)     // Catch:{ all -> 0x007e }
            goto L_0x008a
        L_0x007e:
            r3 = move-exception
            com.avito.android.service.ServiceCountdownHandler r4 = r2.countdownHandler
            if (r4 != 0) goto L_0x0086
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
        L_0x0086:
            r4.onActionDone()
            throw r3
        L_0x008a:
            com.avito.android.service.ServiceCountdownHandler r3 = r2.countdownHandler
            if (r3 != 0) goto L_0x0091
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
        L_0x0091:
            r3.onActionDone()
            r3 = 2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.notification.NotificationService.onStartCommand(android.content.Intent, int, int):int");
    }

    @Override // com.avito.android.service.ServiceCountdownHandler.Listener
    public void onStop(int i) {
        stopSelfResult(i);
    }

    @Override // android.app.Service
    public boolean onUnbind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logs.verbose$default("NotificationService", "onUnbind", null, 4, null);
        NotificationServiceInteractor notificationServiceInteractor = this.interactor;
        if (notificationServiceInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        notificationServiceInteractor.setHandler(null);
        return super.onUnbind(intent);
    }

    public final void setCountdownHandler(@NotNull ServiceCountdownHandler serviceCountdownHandler) {
        Intrinsics.checkNotNullParameter(serviceCountdownHandler, "<set-?>");
        this.countdownHandler = serviceCountdownHandler;
    }

    public final void setInteractor(@NotNull NotificationServiceInteractor notificationServiceInteractor) {
        Intrinsics.checkNotNullParameter(notificationServiceInteractor, "<set-?>");
        this.interactor = notificationServiceInteractor;
    }

    public final void setSafeStarter(@NotNull SafeServiceStarter safeServiceStarter) {
        Intrinsics.checkNotNullParameter(safeServiceStarter, "<set-?>");
        this.safeStarter = safeServiceStarter;
    }
}
