package net.gotev.uploadservice.observer.request;

import android.content.Context;
import kotlin.Metadata;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.network.ServerResponse;
import org.jetbrains.annotations.NotNull;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "", "Landroid/content/Context;", "context", "Lnet/gotev/uploadservice/data/UploadInfo;", "uploadInfo", "", "onProgress", "(Landroid/content/Context;Lnet/gotev/uploadservice/data/UploadInfo;)V", "Lnet/gotev/uploadservice/network/ServerResponse;", "serverResponse", "onSuccess", "(Landroid/content/Context;Lnet/gotev/uploadservice/data/UploadInfo;Lnet/gotev/uploadservice/network/ServerResponse;)V", "", OkListener.KEY_EXCEPTION, "onError", "(Landroid/content/Context;Lnet/gotev/uploadservice/data/UploadInfo;Ljava/lang/Throwable;)V", "onCompleted", "onCompletedWhileNotObserving", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public interface RequestObserverDelegate {
    void onCompleted(@NotNull Context context, @NotNull UploadInfo uploadInfo);

    void onCompletedWhileNotObserving();

    void onError(@NotNull Context context, @NotNull UploadInfo uploadInfo, @NotNull Throwable th);

    void onProgress(@NotNull Context context, @NotNull UploadInfo uploadInfo);

    void onSuccess(@NotNull Context context, @NotNull UploadInfo uploadInfo, @NotNull ServerResponse serverResponse);
}
