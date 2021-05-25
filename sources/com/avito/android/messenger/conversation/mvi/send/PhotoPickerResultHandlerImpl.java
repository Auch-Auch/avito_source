package com.avito.android.messenger.conversation.mvi.send;

import android.net.Uri;
import arrow.core.Option;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.messenger.conversation.mvi.send.PhotoPickerResultHandler;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.util.CloseableDatasourcesKt;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx.arrow.OptionKt;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandlerImpl;", "Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler;", "", "operationId", "Lio/reactivex/Single;", "", "Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler$Photo;", "handlePhotoPickerResult", "(Ljava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "c", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "photoStorage", "<init>", "(Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerResultHandlerImpl implements PhotoPickerResultHandler {
    public final PhotoInteractor a;
    public final MessengerPhotoStorage b;
    public final SharedPhotosStorage c;
    public final SchedulersFactory d;
    public final Analytics e;

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

    public static final class b<T> implements Consumer<List<? extends PhotoUpload>> {
        public final /* synthetic */ PhotoPickerResultHandlerImpl a;

        public b(PhotoPickerResultHandlerImpl photoPickerResultHandlerImpl) {
            this.a = photoPickerResultHandlerImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends PhotoUpload> list) {
            List<? extends PhotoUpload> list2 = list;
            PhotoPickerResultHandlerImpl photoPickerResultHandlerImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "photoUploads");
            PhotoPickerResultHandlerImpl.access$trackSourceToAnalytics(photoPickerResultHandlerImpl, list2);
        }
    }

    public static final class c<T, R> implements Function<List<? extends PhotoUpload>, ObservableSource<? extends PhotoUpload>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends PhotoUpload> apply(List<? extends PhotoUpload> list) {
            List<? extends PhotoUpload> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "photos");
            return Observable.fromIterable(list2);
        }
    }

    public static final class d<T, R> implements Function<PhotoUpload, SingleSource<? extends Option<? extends PhotoPickerResultHandler.Photo>>> {
        public final /* synthetic */ PhotoPickerResultHandlerImpl a;
        public final /* synthetic */ String b;

        public d(PhotoPickerResultHandlerImpl photoPickerResultHandlerImpl, String str) {
            this.a = photoPickerResultHandlerImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Option<? extends PhotoPickerResultHandler.Photo>> apply(PhotoUpload photoUpload) {
            PhotoUpload photoUpload2 = photoUpload;
            Intrinsics.checkNotNullParameter(photoUpload2, "photoUpload");
            return PhotoPickerResultHandlerImpl.access$saveToPrivateFolder(this.a, this.b, photoUpload2).subscribeOn(this.a.d.io());
        }
    }

    @Inject
    public PhotoPickerResultHandlerImpl(@NotNull PhotoInteractor photoInteractor, @NotNull MessengerPhotoStorage messengerPhotoStorage, @NotNull SharedPhotosStorage sharedPhotosStorage, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(messengerPhotoStorage, "photoStorage");
        Intrinsics.checkNotNullParameter(sharedPhotosStorage, "sharedPhotosStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = photoInteractor;
        this.b = messengerPhotoStorage;
        this.c = sharedPhotosStorage;
        this.d = schedulersFactory;
        this.e = analytics;
    }

    public static final Single access$saveToPrivateFolder(PhotoPickerResultHandlerImpl photoPickerResultHandlerImpl, String str, PhotoUpload photoUpload) {
        Objects.requireNonNull(photoPickerResultHandlerImpl);
        Single fromCallable = Single.fromCallable(new a2.a.a.o1.d.a0.m.a(photoPickerResultHandlerImpl, photoUpload, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …)\n            }\n        }");
        return fromCallable;
    }

    public static final void access$trackSourceToAnalytics(PhotoPickerResultHandlerImpl photoPickerResultHandlerImpl, List list) {
        Objects.requireNonNull(photoPickerResultHandlerImpl);
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Uri sourceUri = ((PhotoUpload) it.next()).getSourceUri();
            if (sourceUri != null) {
                if (photoPickerResultHandlerImpl.c.checkPhotoIsFromCamera(sourceUri)) {
                    i++;
                } else {
                    i2++;
                }
            }
        }
        if (i > 0) {
            photoPickerResultHandlerImpl.e.track(new StatsdEvent.CountEvent("messenger.photo.camera", (long) i));
        }
        if (i2 > 0) {
            photoPickerResultHandlerImpl.e.track(new StatsdEvent.CountEvent("messenger.photo.gallery", (long) i2));
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.PhotoPickerResultHandler
    @NotNull
    public Single<List<PhotoPickerResultHandler.Photo>> handlePhotoPickerResult(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        Observable<R> observeOn = this.a.select(str).subscribeOn(this.d.io()).observeOn(this.d.computation()).map(a.a).first((R) CollectionsKt__CollectionsKt.emptyList()).doOnSuccess(new b(this)).flatMapObservable(c.a).flatMapSingle(new d(this, str)).observeOn(this.d.computation());
        Intrinsics.checkNotNullExpressionValue(observeOn, "photoInteractor.select(o…schedulers.computation())");
        Single<List<PhotoPickerResultHandler.Photo>> list = OptionKt.filterDefined(observeOn).toList();
        Intrinsics.checkNotNullExpressionValue(list, "photoInteractor.select(o…d()\n            .toList()");
        return list;
    }
}
