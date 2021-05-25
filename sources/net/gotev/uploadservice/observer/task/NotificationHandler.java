package net.gotev.uploadservice.observer.task;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.media.RingtoneManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.UploadService;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadNotificationStatusConfig;
import net.gotev.uploadservice.exceptions.UserCancelledUploadException;
import net.gotev.uploadservice.extensions.NotificationManagerExtensionsKt;
import net.gotev.uploadservice.network.ServerResponse;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import ru.ok.android.sdk.OkListener;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010-\u001a\u00020+¢\u0006\u0004\b1\u00102J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ/\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\nJ#\u0010\u0018\u001a\u00020\b*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010#\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010,R\u001d\u00100\u001a\u00020.8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b&\u0010/¨\u00063"}, d2 = {"Lnet/gotev/uploadservice/observer/task/NotificationHandler;", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "Lnet/gotev/uploadservice/data/UploadInfo;", "info", "", "notificationId", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "notificationConfig", "", "onStart", "(Lnet/gotev/uploadservice/data/UploadInfo;ILnet/gotev/uploadservice/data/UploadNotificationConfig;)V", "onProgress", "Lnet/gotev/uploadservice/network/ServerResponse;", CommonKt.EXTRA_RESPONSE, "onSuccess", "(Lnet/gotev/uploadservice/data/UploadInfo;ILnet/gotev/uploadservice/data/UploadNotificationConfig;Lnet/gotev/uploadservice/network/ServerResponse;)V", "", OkListener.KEY_EXCEPTION, "onError", "(Lnet/gotev/uploadservice/data/UploadInfo;ILnet/gotev/uploadservice/data/UploadNotificationConfig;Ljava/lang/Throwable;)V", "onCompleted", "Landroidx/core/app/NotificationCompat$Builder;", "", "uploadId", AuthSource.BOOKING_ORDER, "(Landroidx/core/app/NotificationCompat$Builder;Ljava/lang/String;I)V", "Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "statusConfig", "d", "(Landroidx/core/app/NotificationCompat$Builder;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;Lnet/gotev/uploadservice/data/UploadInfo;)Landroidx/core/app/NotificationCompat$Builder;", "c", "(Lnet/gotev/uploadservice/data/UploadNotificationConfig;Lnet/gotev/uploadservice/data/UploadInfo;)Landroidx/core/app/NotificationCompat$Builder;", "notificationChannelId", "", "isRingToneEnabled", "e", "(ILnet/gotev/uploadservice/data/UploadInfo;Ljava/lang/String;ZLnet/gotev/uploadservice/data/UploadNotificationStatusConfig;)V", "", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getNotificationCreationTimeMillis", "()J", "notificationCreationTimeMillis", "Lnet/gotev/uploadservice/UploadService;", "Lnet/gotev/uploadservice/UploadService;", NotificationCompat.CATEGORY_SERVICE, "Landroid/app/NotificationManager;", "()Landroid/app/NotificationManager;", "notificationManager", "<init>", "(Lnet/gotev/uploadservice/UploadService;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class NotificationHandler implements UploadTaskObserver {
    public final Lazy a = c.lazy(a.a);
    public final Lazy b = c.lazy(new b(this));
    public final UploadService c;

    public static final class a extends Lambda implements Function0<Long> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    public static final class b extends Lambda implements Function0<NotificationManager> {
        public final /* synthetic */ NotificationHandler a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NotificationHandler notificationHandler) {
            super(0);
            this.a = notificationHandler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public NotificationManager invoke() {
            Object systemService = this.a.c.getSystemService("notification");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService;
        }
    }

    public NotificationHandler(@NotNull UploadService uploadService) {
        Intrinsics.checkNotNullParameter(uploadService, NotificationCompat.CATEGORY_SERVICE);
        this.c = uploadService;
    }

    public final NotificationManager a() {
        return (NotificationManager) this.b.getValue();
    }

    public final void b(NotificationCompat.Builder builder, String str, int i) {
        Notification build = builder.build();
        UploadService uploadService = this.c;
        Intrinsics.checkNotNullExpressionValue(build, "this");
        if (uploadService.holdForegroundNotification(str, build)) {
            a().cancel(i);
        } else {
            a().notify(i, build);
        }
    }

    public final NotificationCompat.Builder c(UploadNotificationConfig uploadNotificationConfig, UploadInfo uploadInfo) {
        NotificationCompat.Builder when = new NotificationCompat.Builder(this.c, uploadNotificationConfig.getNotificationChannelId()).setWhen(((Number) this.a.getValue()).longValue());
        Intrinsics.checkNotNullExpressionValue(when, "NotificationCompat.Build…cationCreationTimeMillis)");
        NotificationCompat.Builder ongoing = d(when, uploadNotificationConfig.getProgress(), uploadInfo).setOngoing(true);
        Intrinsics.checkNotNullExpressionValue(ongoing, "NotificationCompat.Build…        .setOngoing(true)");
        return ongoing;
    }

    public final NotificationCompat.Builder d(NotificationCompat.Builder builder, UploadNotificationStatusConfig uploadNotificationStatusConfig, UploadInfo uploadInfo) {
        NotificationCompat.Builder color = builder.setGroup(UploadServiceConfig.getNamespace()).setContentTitle(UploadServiceConfig.getPlaceholdersProcessor().processPlaceholders(uploadNotificationStatusConfig.getTitle(), uploadInfo)).setContentText(UploadServiceConfig.getPlaceholdersProcessor().processPlaceholders(uploadNotificationStatusConfig.getMessage(), uploadInfo)).setContentIntent(uploadNotificationStatusConfig.getClickIntent(this.c)).setSmallIcon(uploadNotificationStatusConfig.getIconResourceID()).setLargeIcon(uploadNotificationStatusConfig.getLargeIcon()).setColor(uploadNotificationStatusConfig.getIconColorResourceID());
        Intrinsics.checkNotNullExpressionValue(color, "setGroup(namespace)\n    …nfig.iconColorResourceID)");
        Iterator<T> it = uploadNotificationStatusConfig.getActions().iterator();
        while (it.hasNext()) {
            color.addAction(it.next().asAction());
        }
        return color;
    }

    public final void e(int i, UploadInfo uploadInfo, String str, boolean z, UploadNotificationStatusConfig uploadNotificationStatusConfig) {
        NotificationCompat.Builder deleteIntent;
        a().cancel(i);
        if (!uploadNotificationStatusConfig.getAutoClear()) {
            NotificationCompat.Builder ongoing = d(new NotificationCompat.Builder(this.c, str), uploadNotificationStatusConfig, uploadInfo).setProgress(0, 0, false).setOngoing(false);
            Intrinsics.checkNotNullExpressionValue(ongoing, "NotificationCompat.Build…       .setOngoing(false)");
            PendingIntent onDismissed = uploadNotificationStatusConfig.getOnDismissed();
            if (!(onDismissed == null || (deleteIntent = ongoing.setDeleteIntent(onDismissed)) == null)) {
                ongoing = deleteIntent;
            }
            NotificationCompat.Builder autoCancel = ongoing.setAutoCancel(uploadNotificationStatusConfig.getClearOnAction());
            Intrinsics.checkNotNullExpressionValue(autoCancel, "NotificationCompat.Build…atusConfig.clearOnAction)");
            if (z && Build.VERSION.SDK_INT < 26) {
                autoCancel.setSound(RingtoneManager.getActualDefaultRingtoneUri(this.c, 2));
            }
            a().notify(i + 1, autoCancel.build());
        }
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onCompleted(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onError(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig, @NotNull Throwable th) {
        UploadNotificationStatusConfig uploadNotificationStatusConfig;
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(th, OkListener.KEY_EXCEPTION);
        if (th instanceof UserCancelledUploadException) {
            uploadNotificationStatusConfig = uploadNotificationConfig.getCancelled();
        } else {
            uploadNotificationStatusConfig = uploadNotificationConfig.getError();
        }
        e(i, uploadInfo, uploadNotificationConfig.getNotificationChannelId(), uploadNotificationConfig.isRingToneEnabled(), uploadNotificationStatusConfig);
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onProgress(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        NotificationCompat.Builder progress = c(uploadNotificationConfig, uploadInfo).setProgress(100, uploadInfo.getProgressPercent(), false);
        Intrinsics.checkNotNullExpressionValue(progress, "ongoingNotification(noti…o.progressPercent, false)");
        b(progress, uploadInfo.getUploadId(), i);
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onStart(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        NotificationManagerExtensionsKt.validateNotificationChannel(a(), uploadNotificationConfig.getNotificationChannelId());
        NotificationCompat.Builder progress = c(uploadNotificationConfig, uploadInfo).setProgress(100, 0, true);
        Intrinsics.checkNotNullExpressionValue(progress, "ongoingNotification(noti…setProgress(100, 0, true)");
        b(progress, uploadInfo.getUploadId(), i);
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onSuccess(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig, @NotNull ServerResponse serverResponse) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(serverResponse, CommonKt.EXTRA_RESPONSE);
        e(i, uploadInfo, uploadNotificationConfig.getNotificationChannelId(), uploadNotificationConfig.isRingToneEnabled(), uploadNotificationConfig.getSuccess());
    }
}
