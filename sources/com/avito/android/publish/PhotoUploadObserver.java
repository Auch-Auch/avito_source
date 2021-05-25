package com.avito.android.publish;

import com.avito.android.remote.model.category_parameters.PhotoParameter;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\r\u000eJ'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/publish/PhotoUploadObserver;", "", "Lcom/avito/android/publish/PhotoUploadObserver$PhotoParameterProvider;", "parameterProvider", "", "withMilestones", "Lio/reactivex/Observable;", "Lcom/avito/android/publish/PhotoUploadObserver$UploadStatus;", "startObserve", "(Lcom/avito/android/publish/PhotoUploadObserver$PhotoParameterProvider;Z)Lio/reactivex/Observable;", "", "stopObserve", "()V", "PhotoParameterProvider", "UploadStatus", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoUploadObserver {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable startObserve$default(PhotoUploadObserver photoUploadObserver, PhotoParameterProvider photoParameterProvider, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return photoUploadObserver.startObserve(photoParameterProvider, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startObserve");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/publish/PhotoUploadObserver$PhotoParameterProvider;", "", "Lcom/avito/android/remote/model/category_parameters/PhotoParameter;", "getPhotoParameter", "()Lcom/avito/android/remote/model/category_parameters/PhotoParameter;", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
    public interface PhotoParameterProvider {
        @Nullable
        PhotoParameter getPhotoParameter();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/avito/android/publish/PhotoUploadObserver$UploadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UPLOADED", "PENDING", "SYNCED", "UNSYNCED", "ERROR", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
    public enum UploadStatus {
        UPLOADED,
        PENDING,
        SYNCED,
        UNSYNCED,
        ERROR
    }

    @NotNull
    Observable<UploadStatus> startObserve(@NotNull PhotoParameterProvider photoParameterProvider, boolean z);

    void stopObserve();
}
