package com.avito.android.photo_picker.legacy;

import android.net.Uri;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.util.CloseableDatasourcesKt;
import com.avito.android.util.PrivatePhotosStorage;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoStorageCleanerImpl;", "Lcom/avito/android/photo_picker/legacy/PhotoStorageCleaner;", "", "draftId", "Lio/reactivex/Single;", "", "removeUnnecessaryPhotos", "(Ljava/lang/String;)Lio/reactivex/Single;", "Lcom/avito/android/util/PrivatePhotosStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/PrivatePhotosStorage;", "photoStorage", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "<init>", "(Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/util/PrivatePhotosStorage;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoStorageCleanerImpl implements PhotoStorageCleaner {
    public final PhotoInteractor a;
    public final PrivatePhotosStorage b;

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

    public static final class b<T, R> implements Function<List<? extends PhotoUpload>, List<? extends Uri>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends Uri> apply(List<? extends PhotoUpload> list) {
            List<? extends PhotoUpload> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "list");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getContentUri());
            }
            return arrayList;
        }
    }

    public static final class c<T, R> implements Function<List<? extends Uri>, Unit> {
        public final /* synthetic */ PhotoStorageCleanerImpl a;

        public c(PhotoStorageCleanerImpl photoStorageCleanerImpl) {
            this.a = photoStorageCleanerImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(List<? extends Uri> list) {
            List<? extends Uri> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "neededUris");
            this.a.b.clearCache(CollectionsKt___CollectionsKt.filterNotNull(list2));
            return Unit.INSTANCE;
        }
    }

    @Inject
    public PhotoStorageCleanerImpl(@NotNull PhotoInteractor photoInteractor, @NotNull PrivatePhotosStorage privatePhotosStorage) {
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "photoStorage");
        this.a = photoInteractor;
        this.b = privatePhotosStorage;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoStorageCleaner
    @NotNull
    public Single<Unit> removeUnnecessaryPhotos(@Nullable String str) {
        Observable<CloseableDataSource<? extends PhotoUpload>> observable;
        if (str == null) {
            observable = this.a.selectUploadsOfType("messenger");
        } else {
            observable = this.a.select(str).mergeWith(this.a.selectUploadsOfType("messenger"));
        }
        Single<Unit> first = observable.map(a.a).map(b.a).map(new c(this)).first(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(first, "observableBase\n         …\n            .first(Unit)");
        return first;
    }
}
