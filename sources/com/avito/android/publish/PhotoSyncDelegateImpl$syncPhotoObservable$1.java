package com.avito.android.publish;

import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.publish.PhotoSyncDelegateImpl;
import com.avito.android.publish.PhotoUploadObserver;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.util.Logs;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class PhotoSyncDelegateImpl$syncPhotoObservable$1 implements CompletableOnSubscribe {
    public final /* synthetic */ PhotoSyncDelegateImpl a;
    public final /* synthetic */ Function1 b;

    public static final class a implements Cancellable {
        public final /* synthetic */ PhotoSyncDelegateImpl$syncPhotoObservable$1 a;
        public final /* synthetic */ Disposable b;

        public a(PhotoSyncDelegateImpl$syncPhotoObservable$1 photoSyncDelegateImpl$syncPhotoObservable$1, Disposable disposable) {
            this.a = photoSyncDelegateImpl$syncPhotoObservable$1;
            this.b = disposable;
        }

        @Override // io.reactivex.functions.Cancellable
        public final void cancel() {
            this.a.a.b.stopObserve();
            this.b.dispose();
        }
    }

    public static final class b<T, R> implements Function<PhotoUploadObserver.UploadStatus, SingleSource<? extends PhotoUploadObserver.UploadStatus>> {
        public final /* synthetic */ PhotoSyncDelegateImpl$syncPhotoObservable$1 a;
        public final /* synthetic */ PhotoParameter b;

        public b(PhotoSyncDelegateImpl$syncPhotoObservable$1 photoSyncDelegateImpl$syncPhotoObservable$1, PhotoParameter photoParameter) {
            this.a = photoSyncDelegateImpl$syncPhotoObservable$1;
            this.b = photoParameter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends PhotoUploadObserver.UploadStatus> apply(PhotoUploadObserver.UploadStatus uploadStatus) {
            Completable completable;
            PhotoUploadObserver.UploadStatus uploadStatus2 = uploadStatus;
            Intrinsics.checkNotNullParameter(uploadStatus2, "status");
            int ordinal = uploadStatus2.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                completable = (Completable) this.a.b.invoke(PhotoParameter.copy$default(this.b, null, null, null, 0, null, null, null, false, false, null, null, 2047, null));
            } else {
                completable = Completable.complete();
                Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
            }
            return completable.andThen(Single.just(uploadStatus2));
        }
    }

    public static final class c<T> implements Consumer<PhotoUploadObserver.UploadStatus> {
        public final /* synthetic */ PhotoSyncDelegateImpl$syncPhotoObservable$1 a;
        public final /* synthetic */ CompletableEmitter b;

        public c(PhotoSyncDelegateImpl$syncPhotoObservable$1 photoSyncDelegateImpl$syncPhotoObservable$1, CompletableEmitter completableEmitter) {
            this.a = photoSyncDelegateImpl$syncPhotoObservable$1;
            this.b = completableEmitter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PhotoUploadObserver.UploadStatus uploadStatus) {
            PhotoUploadObserver.UploadStatus uploadStatus2 = uploadStatus;
            if (uploadStatus2 != null) {
                int ordinal = uploadStatus2.ordinal();
                if (ordinal == 0 || ordinal == 2) {
                    this.b.onComplete();
                } else if (ordinal == 3) {
                    UploadingInteractor.DefaultImpls.startUpload$default(this.a.a.a, null, 1, null);
                } else if (ordinal == 4) {
                    this.b.onError(new PhotoSyncDelegateImpl.PhotoSyncException());
                }
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ CompletableEmitter a;

        public d(CompletableEmitter completableEmitter) {
            this.a = completableEmitter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed updating photo", th);
            this.a.onError(new PhotoSyncDelegateImpl.PhotoSyncException());
        }
    }

    public PhotoSyncDelegateImpl$syncPhotoObservable$1(PhotoSyncDelegateImpl photoSyncDelegateImpl, Function1 function1) {
        this.a = photoSyncDelegateImpl;
        this.b = function1;
    }

    @Override // io.reactivex.CompletableOnSubscribe
    public final void subscribe(@NotNull CompletableEmitter completableEmitter) {
        Intrinsics.checkNotNullParameter(completableEmitter, "emitter");
        PhotoParameter access$getPhotoParam = PhotoSyncDelegateImpl.access$getPhotoParam(this.a);
        completableEmitter.setCancellable(new a(this, this.a.b.startObserve(new PhotoUploadObserver.PhotoParameterProvider(access$getPhotoParam) { // from class: com.avito.android.publish.PhotoSyncDelegateImpl$syncPhotoObservable$1$photoDisposable$1
            public final /* synthetic */ PhotoParameter a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.publish.PhotoUploadObserver.PhotoParameterProvider
            @Nullable
            public PhotoParameter getPhotoParameter() {
                return this.a;
            }
        }, true).observeOn(this.a.c.mainThread()).flatMapSingle(new b(this, access$getPhotoParam)).subscribe(new c(this, completableEmitter), new d(completableEmitter))));
    }
}
