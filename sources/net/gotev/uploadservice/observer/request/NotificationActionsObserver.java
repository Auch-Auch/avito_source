package net.gotev.uploadservice.observer.request;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.extensions.ContextExtensionsKt;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lnet/gotev/uploadservice/observer/request/NotificationActionsObserver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "onActionIntent", "(Landroid/content/Intent;)V", "register", "()V", "unregister", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public class NotificationActionsObserver extends BroadcastReceiver {
    public final Context a;

    public static final class a extends Lambda implements Function0<String> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return "requested upload cancellation";
        }
    }

    public static final class b extends Lambda implements Function0<String> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return "registered";
        }
    }

    public static final class c extends Lambda implements Function0<String> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return "unregistered";
        }
    }

    public NotificationActionsObserver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    public void onActionIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String uploadIdToCancel = ContextExtensionsKt.getUploadIdToCancel(intent);
        if (uploadIdToCancel != null) {
            String simpleName = NotificationActionsObserver.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "NotificationActionsObserver::class.java.simpleName");
            UploadServiceLogger.info(simpleName, uploadIdToCancel, a.a);
            UploadService.Companion.stopUpload(uploadIdToCancel);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (!(!Intrinsics.areEqual(intent != null ? intent.getAction() : null, UploadServiceConfig.getBroadcastNotificationAction()))) {
            onActionIntent(intent);
        }
    }

    public final void register() {
        this.a.registerReceiver(this, UploadServiceConfig.getBroadcastNotificationActionIntentFilter());
        String simpleName = NotificationActionsObserver.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "NotificationActionsObserver::class.java.simpleName");
        UploadServiceLogger.debug(simpleName, UploadServiceLogger.NA, b.a);
    }

    public final void unregister() {
        this.a.unregisterReceiver(this);
        String simpleName = NotificationActionsObserver.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "NotificationActionsObserver::class.java.simpleName");
        UploadServiceLogger.debug(simpleName, UploadServiceLogger.NA, c.a);
    }
}
