package net.gotev.uploadservice.observer.task;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.BroadcastData;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadStatus;
import net.gotev.uploadservice.network.ServerResponse;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ/\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nJ/\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lnet/gotev/uploadservice/observer/task/BroadcastEmitter;", "Lnet/gotev/uploadservice/observer/task/UploadTaskObserver;", "Lnet/gotev/uploadservice/data/UploadInfo;", "info", "", "notificationId", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "notificationConfig", "", "onStart", "(Lnet/gotev/uploadservice/data/UploadInfo;ILnet/gotev/uploadservice/data/UploadNotificationConfig;)V", "onProgress", "Lnet/gotev/uploadservice/network/ServerResponse;", CommonKt.EXTRA_RESPONSE, "onSuccess", "(Lnet/gotev/uploadservice/data/UploadInfo;ILnet/gotev/uploadservice/data/UploadNotificationConfig;Lnet/gotev/uploadservice/network/ServerResponse;)V", "onCompleted", "", OkListener.KEY_EXCEPTION, "onError", "(Lnet/gotev/uploadservice/data/UploadInfo;ILnet/gotev/uploadservice/data/UploadNotificationConfig;Ljava/lang/Throwable;)V", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class BroadcastEmitter implements UploadTaskObserver {
    public final Context a;

    public BroadcastEmitter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onCompleted(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        this.a.sendBroadcast(new BroadcastData(UploadStatus.Completed, uploadInfo, null, null, 12, null).toIntent());
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onError(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(th, OkListener.KEY_EXCEPTION);
        this.a.sendBroadcast(new BroadcastData(UploadStatus.Error, uploadInfo, null, th).toIntent());
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onProgress(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        this.a.sendBroadcast(new BroadcastData(UploadStatus.InProgress, uploadInfo, null, null, 12, null).toIntent());
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onStart(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
    }

    @Override // net.gotev.uploadservice.observer.task.UploadTaskObserver
    public void onSuccess(@NotNull UploadInfo uploadInfo, int i, @NotNull UploadNotificationConfig uploadNotificationConfig, @NotNull ServerResponse serverResponse) {
        Intrinsics.checkNotNullParameter(uploadInfo, "info");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        Intrinsics.checkNotNullParameter(serverResponse, CommonKt.EXTRA_RESPONSE);
        this.a.sendBroadcast(new BroadcastData(UploadStatus.Success, uploadInfo, serverResponse, null, 8, null).toIntent());
    }
}
