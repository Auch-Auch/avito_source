package com.avito.android.photo_picker.legacy;

import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.UploadingState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.remote.model.ErrorType;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageUploadPending;
import com.avito.android.remote.model.ImageUploadResult;
import com.avito.android.util.CloseableDatasourcesKt;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractorImpl;", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/photo_picker/UploadingState;", "getUploadProgressObservable", "()Lio/reactivex/Observable;", "", "", "getUploadIds", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "draftId", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "<init>", "(Ljava/lang/String;Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class UploadingProgressInteractorImpl implements UploadingProgressInteractor {
    public final String a;
    public final PhotoInteractor b;
    public final SchedulersFactory c;

    public static final class a<T, R> implements Function<CloseableDataSource<? extends PhotoUpload>, List<? extends String>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends String> apply(CloseableDataSource<? extends PhotoUpload> closeableDataSource) {
            CloseableDataSource<? extends PhotoUpload> closeableDataSource2 = closeableDataSource;
            Intrinsics.checkNotNullParameter(closeableDataSource2, "it");
            return UploadingProgressInteractorKt.access$extractUploadIds(CloseableDatasourcesKt.readAllAndClose(closeableDataSource2));
        }
    }

    public static final class b<T, R> implements Function<CloseableDataSource<? extends PhotoUpload>, UploadingState> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public UploadingState apply(CloseableDataSource<? extends PhotoUpload> closeableDataSource) {
            Object obj;
            CloseableDataSource<? extends PhotoUpload> closeableDataSource2 = closeableDataSource;
            Intrinsics.checkNotNullParameter(closeableDataSource2, "images");
            List sortedWith = CollectionsKt___CollectionsKt.sortedWith(CloseableDatasourcesKt.readAllAndClose(closeableDataSource2), new UploadingProgressInteractorImpl$getUploadProgressObservable$1$$special$$inlined$sortedBy$1());
            boolean access$allAreFinished = UploadingProgressInteractorKt.access$allAreFinished(sortedWith);
            boolean access$hasErrors = UploadingProgressInteractorKt.access$hasErrors(sortedWith);
            int access$countFinished = UploadingProgressInteractorKt.access$countFinished(sortedWith);
            ArrayList arrayList = new ArrayList();
            for (T t : sortedWith) {
                if (Intrinsics.areEqual(t.getError(), ErrorType.NoError.INSTANCE)) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                PhotoUpload photoUpload = (PhotoUpload) it.next();
                if (photoUpload.getUploadId() == null) {
                    obj = new ImageUploadPending(photoUpload.getId());
                } else {
                    String uploadId = photoUpload.getUploadId();
                    Intrinsics.checkNotNull(uploadId);
                    obj = new ImageUploadResult(uploadId, new Image(r.emptyMap()));
                }
                arrayList2.add(obj);
            }
            if (!access$allAreFinished) {
                return new UploadingState.Loading(arrayList2, access$countFinished, sortedWith.size());
            }
            if (access$hasErrors) {
                return new UploadingState.Error(new ErrorWithMessage.Unknown("", new Exception()));
            }
            return new UploadingState.Loaded(arrayList2);
        }
    }

    @Inject
    public UploadingProgressInteractorImpl(@NotNull String str, @NotNull PhotoInteractor photoInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = str;
        this.b = photoInteractor;
        this.c = schedulersFactory;
    }

    @Override // com.avito.android.photo_picker.legacy.UploadingProgressInteractor
    @NotNull
    public Observable<List<String>> getUploadIds() {
        Observable<R> map = this.b.select(this.a).firstElement().toObservable().map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "photoInteractor.select(d…se().extractUploadIds() }");
        return map;
    }

    @Override // com.avito.android.photo_picker.legacy.UploadingProgressInteractor
    @NotNull
    public Observable<UploadingState> getUploadProgressObservable() {
        Observable<R> subscribeOn = this.b.select(this.a).map(b.a).subscribeOn(this.c.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "photoInteractor.select(d…schedulers.computation())");
        return subscribeOn;
    }
}
