package com.avito.android.messenger.conversation.mvi.file_upload;

import a2.a.a.o1.d.a0.f.m;
import android.content.Context;
import com.avito.android.messenger.conversation.mvi.file_upload.UploadStatusUpdatesHandlerImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.exceptions.UserCancelledUploadException;
import net.gotev.uploadservice.network.ServerResponse;
import net.gotev.uploadservice.observer.request.RequestObserverDelegate;
import org.jetbrains.annotations.NotNull;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ'\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandlerImpl$uploadRequestObserverDelegate$2$1", "Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "Landroid/content/Context;", "context", "Lnet/gotev/uploadservice/data/UploadInfo;", "uploadInfo", "", "onCompleted", "(Landroid/content/Context;Lnet/gotev/uploadservice/data/UploadInfo;)V", "onCompletedWhileNotObserving", "()V", "", OkListener.KEY_EXCEPTION, "onError", "(Landroid/content/Context;Lnet/gotev/uploadservice/data/UploadInfo;Ljava/lang/Throwable;)V", "onProgress", "Lnet/gotev/uploadservice/network/ServerResponse;", "serverResponse", "onSuccess", "(Landroid/content/Context;Lnet/gotev/uploadservice/data/UploadInfo;Lnet/gotev/uploadservice/network/ServerResponse;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UploadStatusUpdatesHandlerImpl$uploadRequestObserverDelegate$2$1 implements RequestObserverDelegate {
    public final /* synthetic */ UploadStatusUpdatesHandlerImpl.e a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public UploadStatusUpdatesHandlerImpl$uploadRequestObserverDelegate$2$1(UploadStatusUpdatesHandlerImpl.e eVar) {
        this.a = eVar;
    }

    @Override // net.gotev.uploadservice.observer.request.RequestObserverDelegate
    public void onCompleted(@NotNull Context context, @NotNull UploadInfo uploadInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uploadInfo, "uploadInfo");
        this.a.a.b.accept(UploadStatusUpdatesHandlerImpl.c(this.a.a, uploadInfo, m.COMPLETED, null, 2));
    }

    @Override // net.gotev.uploadservice.observer.request.RequestObserverDelegate
    public void onCompletedWhileNotObserving() {
    }

    @Override // net.gotev.uploadservice.observer.request.RequestObserverDelegate
    public void onError(@NotNull Context context, @NotNull UploadInfo uploadInfo, @NotNull Throwable th) {
        m mVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uploadInfo, "uploadInfo");
        Intrinsics.checkNotNullParameter(th, OkListener.KEY_EXCEPTION);
        if (th instanceof UserCancelledUploadException) {
            mVar = m.CANCELLED;
        } else {
            mVar = m.ERROR;
        }
        this.a.a.b.accept(this.a.a.b(uploadInfo, mVar, th));
    }

    @Override // net.gotev.uploadservice.observer.request.RequestObserverDelegate
    public void onProgress(@NotNull Context context, @NotNull UploadInfo uploadInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uploadInfo, "uploadInfo");
        this.a.a.b.accept(UploadStatusUpdatesHandlerImpl.c(this.a.a, uploadInfo, m.PROGRESS, null, 2));
    }

    @Override // net.gotev.uploadservice.observer.request.RequestObserverDelegate
    public void onSuccess(@NotNull Context context, @NotNull UploadInfo uploadInfo, @NotNull ServerResponse serverResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uploadInfo, "uploadInfo");
        Intrinsics.checkNotNullParameter(serverResponse, "serverResponse");
        this.a.a.b.accept(UploadStatusUpdatesHandlerImpl.c(this.a.a, uploadInfo, m.SUCCESS, null, 2));
    }
}
