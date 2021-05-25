package com.avito.android.publish;

import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.publish.PhotoUploadObserver;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Completable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/publish/PhotoSyncDelegateImpl;", "Lcom/avito/android/publish/PhotoSyncDelegate;", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/category_parameters/PhotoParameter;", "Lio/reactivex/Completable;", "updateHandler", "syncPhotoObservable", "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/Completable;", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "uploadingInteractor", "Lcom/avito/android/publish/PhotoUploadObserver;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/PhotoUploadObserver;", "photoUploadObserver", "<init>", "(Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;Lcom/avito/android/publish/PhotoUploadObserver;Lcom/avito/android/util/SchedulersFactory;)V", "PhotoSyncException", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoSyncDelegateImpl implements PhotoSyncDelegate {
    public final UploadingInteractor a;
    public final PhotoUploadObserver b;
    public final SchedulersFactory c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/publish/PhotoSyncDelegateImpl$PhotoSyncException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhotoSyncException extends Exception {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            PhotoUploadObserver.UploadStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            PhotoUploadObserver.UploadStatus.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[2] = 1;
            iArr2[0] = 2;
            iArr2[3] = 3;
            iArr2[4] = 4;
        }
    }

    public PhotoSyncDelegateImpl(@NotNull UploadingInteractor uploadingInteractor, @NotNull PhotoUploadObserver photoUploadObserver, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(uploadingInteractor, "uploadingInteractor");
        Intrinsics.checkNotNullParameter(photoUploadObserver, "photoUploadObserver");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = uploadingInteractor;
        this.b = photoUploadObserver;
        this.c = schedulersFactory;
    }

    public static final PhotoParameter access$getPhotoParam(PhotoSyncDelegateImpl photoSyncDelegateImpl) {
        Objects.requireNonNull(photoSyncDelegateImpl);
        return new PhotoParameter("100004", "", null, Integer.MAX_VALUE, null, CollectionsKt__CollectionsKt.emptyList(), null, false, false, null, null, 960, null);
    }

    @Override // com.avito.android.publish.PhotoSyncDelegate
    @NotNull
    public Completable syncPhotoObservable(@NotNull Function1<? super PhotoParameter, ? extends Completable> function1) {
        Intrinsics.checkNotNullParameter(function1, "updateHandler");
        Completable create = Completable.create(new PhotoSyncDelegateImpl$syncPhotoObservable$1(this, function1));
        Intrinsics.checkNotNullExpressionValue(create, "Completable.create { emi…)\n            }\n        }");
        return create;
    }
}
