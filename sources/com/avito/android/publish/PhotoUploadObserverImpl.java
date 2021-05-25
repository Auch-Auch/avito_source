package com.avito.android.publish;

import com.avito.android.photo_picker.UploadingState;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.publish.PhotoUploadObserver;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ImageUpload;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/publish/PhotoUploadObserverImpl;", "Lcom/avito/android/publish/PhotoUploadObserver;", "Lcom/avito/android/publish/PhotoUploadObserver$PhotoParameterProvider;", "parameterProvider", "", "withMilestones", "Lio/reactivex/Observable;", "Lcom/avito/android/publish/PhotoUploadObserver$UploadStatus;", "startObserve", "(Lcom/avito/android/publish/PhotoUploadObserver$PhotoParameterProvider;Z)Lio/reactivex/Observable;", "", "stopObserve", "()V", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "c", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "uploadingProgressInteractor", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "photoParameterValueChanged", "Lio/reactivex/disposables/Disposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/Disposable;", "disposable", "<init>", "(Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoUploadObserverImpl implements PhotoUploadObserver {
    public Disposable a;
    public final PublishRelay<PhotoUploadObserver.UploadStatus> b;
    public final UploadingProgressInteractor c;
    public final SchedulersFactory d;

    public static final class a extends Lambda implements Function1<UploadingState, Unit> {
        public final /* synthetic */ PhotoUploadObserverImpl a;
        public final /* synthetic */ PhotoUploadObserver.PhotoParameterProvider b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PhotoUploadObserverImpl photoUploadObserverImpl, PhotoUploadObserver.PhotoParameterProvider photoParameterProvider, boolean z) {
            super(1);
            this.a = photoUploadObserverImpl;
            this.b = photoParameterProvider;
            this.c = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(UploadingState uploadingState) {
            UploadingState uploadingState2 = uploadingState;
            if (uploadingState2 instanceof UploadingState.HasUploadData) {
                PhotoUploadObserverImpl.access$handleData(this.a, this.b, (UploadingState.HasUploadData) uploadingState2, this.c);
            } else if ((uploadingState2 instanceof UploadingState.Error) && this.c) {
                this.a.b.accept(PhotoUploadObserver.UploadStatus.UNSYNCED);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ PhotoUploadObserverImpl a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PhotoUploadObserverImpl photoUploadObserverImpl, boolean z) {
            super(1);
            this.a = photoUploadObserverImpl;
            this.b = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            Logs.error("Failed to get uploading info", th2);
            if (this.b) {
                this.a.b.accept(PhotoUploadObserver.UploadStatus.ERROR);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public PhotoUploadObserverImpl(@NotNull UploadingProgressInteractor uploadingProgressInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(uploadingProgressInteractor, "uploadingProgressInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.c = uploadingProgressInteractor;
        this.d = schedulersFactory;
        PublishRelay<PhotoUploadObserver.UploadStatus> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.b = create;
    }

    public static final void access$handleData(PhotoUploadObserverImpl photoUploadObserverImpl, PhotoUploadObserver.PhotoParameterProvider photoParameterProvider, UploadingState.HasUploadData hasUploadData, boolean z) {
        int i;
        PhotoUploadObserver.UploadStatus uploadStatus;
        Objects.requireNonNull(photoUploadObserverImpl);
        PhotoParameter photoParameter = photoParameterProvider.getPhotoParameter();
        List<ImageUpload> list = null;
        PhotoParameter.ImageUploadListWrapper imageUploadListWrapper = photoParameter != null ? (PhotoParameter.ImageUploadListWrapper) photoParameter.getValue() : null;
        List<ImageUpload> data = hasUploadData.getData();
        if (photoParameter == null) {
            i = 0;
        } else {
            Integer recommendedAmount = photoParameter.getRecommendedAmount();
            i = recommendedAmount != null ? recommendedAmount.intValue() : photoParameter.getMaxCount();
        }
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) CollectionsKt___CollectionsKt.take(data, i));
        if (photoParameter != null) {
            PhotoParameter.ImageUploadListWrapper imageUploadListWrapper2 = new PhotoParameter.ImageUploadListWrapper(mutableList);
            if (!Intrinsics.areEqual(photoParameter.getValue(), imageUploadListWrapper2)) {
                photoParameter.setValue(imageUploadListWrapper2);
                photoParameter.setError(null);
            }
        }
        if (imageUploadListWrapper != null) {
            list = imageUploadListWrapper.getList();
        }
        if (!Intrinsics.areEqual(list, mutableList)) {
            if (hasUploadData instanceof UploadingState.Loaded) {
                uploadStatus = PhotoUploadObserver.UploadStatus.UPLOADED;
            } else {
                uploadStatus = PhotoUploadObserver.UploadStatus.PENDING;
            }
            photoUploadObserverImpl.b.accept(uploadStatus);
        } else if (z && (hasUploadData instanceof UploadingState.Loaded)) {
            photoUploadObserverImpl.b.accept(PhotoUploadObserver.UploadStatus.SYNCED);
        }
    }

    @Override // com.avito.android.publish.PhotoUploadObserver
    @NotNull
    public Observable<PhotoUploadObserver.UploadStatus> startObserve(@NotNull PhotoUploadObserver.PhotoParameterProvider photoParameterProvider, boolean z) {
        Intrinsics.checkNotNullParameter(photoParameterProvider, "parameterProvider");
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = SubscribersKt.subscribeBy$default(a2.b.a.a.a.T1(this.d, this.c.getUploadProgressObservable().subscribeOn(this.d.io()), "uploadingProgressInterac…(schedulers.mainThread())"), new b(this, z), (Function0) null, new a(this, photoParameterProvider, z), 2, (Object) null);
        return this.b;
    }

    @Override // com.avito.android.publish.PhotoUploadObserver
    public void stopObserve() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
