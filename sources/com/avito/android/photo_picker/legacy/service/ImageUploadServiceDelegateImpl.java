package com.avito.android.photo_picker.legacy.service;

import a2.a.a.x1.q.n.f;
import a2.a.a.x1.q.n.g;
import android.net.Uri;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import com.avito.android.photo_picker.legacy.api.UploadConverterProvider;
import com.avito.android.photo_picker.legacy.api.UploadInteractorProvider;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegate;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.remote.model.ErrorType;
import com.avito.android.util.CloseableDatasourcesKt;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Throwables;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegateImpl;", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate;", "", "operationId", "photoId", "", "uploadAfterNonRestorableError", "Lio/reactivex/Observable;", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate$UploadingEvent;", Tracker.Events.CREATIVE_START, "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoProviderInteractor", "Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProvider;", "uploadInteractorProvider", "Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;", "c", "Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;", "uploadConverterProvider", "<init>", "(Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProvider;Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;Lcom/avito/android/util/SchedulersFactory;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ImageUploadServiceDelegateImpl implements ImageUploadServiceDelegate {
    public final PhotoInteractor a;
    public final UploadInteractorProvider b;
    public final UploadConverterProvider c;
    public final SchedulersFactory d;

    public static final class a<T, R> implements Function<CloseableDataSource<? extends PhotoUpload>, List<? extends PhotoUpload>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends PhotoUpload> apply(CloseableDataSource<? extends PhotoUpload> closeableDataSource) {
            CloseableDataSource<? extends PhotoUpload> closeableDataSource2 = closeableDataSource;
            Intrinsics.checkNotNullParameter(closeableDataSource2, "it");
            return CloseableDatasourcesKt.readAllAndClose(closeableDataSource2);
        }
    }

    public static final class b<T, R> implements Function<List<? extends PhotoUpload>, ObservableSource<? extends PhotoUpload>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends PhotoUpload> apply(List<? extends PhotoUpload> list) {
            List<? extends PhotoUpload> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return Observable.fromIterable(list2);
        }
    }

    public static final class c<T> implements Predicate<PhotoUpload> {
        public final /* synthetic */ boolean a;

        public c(boolean z) {
            this.a = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(PhotoUpload photoUpload) {
            PhotoUpload photoUpload2 = photoUpload;
            Intrinsics.checkNotNullParameter(photoUpload2, "photo");
            return ImageUploadServiceDelegateKt.access$needUpload(photoUpload2, this.a);
        }
    }

    public static final class d<T, R> implements Function<PhotoUpload, ObservableSource<? extends ImageUploadServiceDelegate.UploadingEvent>> {
        public final /* synthetic */ ImageUploadServiceDelegateImpl a;
        public final /* synthetic */ String b;

        public d(ImageUploadServiceDelegateImpl imageUploadServiceDelegateImpl, String str) {
            this.a = imageUploadServiceDelegateImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ImageUploadServiceDelegate.UploadingEvent> apply(PhotoUpload photoUpload) {
            PhotoUpload photoUpload2 = photoUpload;
            Intrinsics.checkNotNullParameter(photoUpload2, "photo");
            ImageUploadServiceDelegateImpl.access$resetError(this.a, this.b, photoUpload2);
            return ImageUploadServiceDelegateImpl.access$uploadObservable(this.a, this.b, photoUpload2);
        }
    }

    public static final class e<T, R> implements Function<List<ImageUploadServiceDelegate.UploadingEvent>, ImageUploadServiceDelegate.UploadingEvent> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ImageUploadServiceDelegate.UploadingEvent apply(List<ImageUploadServiceDelegate.UploadingEvent> list) {
            List<ImageUploadServiceDelegate.UploadingEvent> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "eventList");
            return ImageUploadServiceDelegateKt.access$foldToSingleEvent(list2);
        }
    }

    public ImageUploadServiceDelegateImpl(@NotNull PhotoInteractor photoInteractor, @NotNull UploadInteractorProvider uploadInteractorProvider, @NotNull UploadConverterProvider uploadConverterProvider, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(photoInteractor, "photoProviderInteractor");
        Intrinsics.checkNotNullParameter(uploadInteractorProvider, "uploadInteractorProvider");
        Intrinsics.checkNotNullParameter(uploadConverterProvider, "uploadConverterProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = photoInteractor;
        this.b = uploadInteractorProvider;
        this.c = uploadConverterProvider;
        this.d = schedulersFactory;
    }

    public static final void access$processUploadError(ImageUploadServiceDelegateImpl imageUploadServiceDelegateImpl, String str, PhotoUpload photoUpload, Throwable th) {
        ErrorType errorType;
        Objects.requireNonNull(imageUploadServiceDelegateImpl);
        if (Throwables.isNetworkProblem(th)) {
            errorType = ErrorType.RestorableError.INSTANCE;
        } else {
            errorType = ErrorType.NonRestorableError.INSTANCE;
        }
        imageUploadServiceDelegateImpl.a.update(str, photoUpload.newBuilder().error(errorType).build());
    }

    public static final void access$resetError(ImageUploadServiceDelegateImpl imageUploadServiceDelegateImpl, String str, PhotoUpload photoUpload) {
        imageUploadServiceDelegateImpl.a.update(str, photoUpload.newBuilder().error(ErrorType.NoError.INSTANCE).build());
    }

    public static final void access$saveUploadResult(ImageUploadServiceDelegateImpl imageUploadServiceDelegateImpl, String str, PhotoUpload photoUpload, String str2) {
        imageUploadServiceDelegateImpl.a.update(str, photoUpload.newBuilder().uploadId(str2).error(ErrorType.NoError.INSTANCE).build());
    }

    public static final Observable access$uploadObservable(ImageUploadServiceDelegateImpl imageUploadServiceDelegateImpl, String str, PhotoUpload photoUpload) {
        UploadConverter uploadConverter = imageUploadServiceDelegateImpl.c.getUploadConverter(photoUpload.getType());
        Uri contentUri = photoUpload.getContentUri();
        Intrinsics.checkNotNull(contentUri);
        return a2.b.a.a.a.S1(imageUploadServiceDelegateImpl.d, uploadConverter.convertUriToFile(contentUri).flatMap(new a2.a.a.x1.q.n.c(imageUploadServiceDelegateImpl, photoUpload)).doOnError(new a2.a.a.x1.q.n.d(imageUploadServiceDelegateImpl, photoUpload, str)).doOnNext(new a2.a.a.x1.q.n.e(imageUploadServiceDelegateImpl, str, photoUpload)).map(f.a).cast(ImageUploadServiceDelegate.UploadingEvent.class).onErrorReturn(g.a), "uploadConverterProvider.…n(schedulersFactory.io())");
    }

    @Override // com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegate
    @NotNull
    public Observable<ImageUploadServiceDelegate.UploadingEvent> start(@NotNull String str, @Nullable String str2, boolean z) {
        Observable<CloseableDataSource<? extends PhotoUpload>> observable;
        Intrinsics.checkNotNullParameter(str, "operationId");
        Long l = null;
        if (str2 != null) {
            try {
                l = Long.valueOf(Long.parseLong(str2));
            } catch (NumberFormatException unused) {
            }
        }
        if (l != null) {
            observable = this.a.select(str, l.longValue());
        } else {
            observable = this.a.select(str);
        }
        Observable<ImageUploadServiceDelegate.UploadingEvent> observable2 = observable.firstOrError().map(a.a).flatMapObservable(b.a).filter(new c(z)).flatMap(new d(this, str)).toList().map(e.a).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable2, "selectObservable\n       …          .toObservable()");
        return observable2;
    }
}
