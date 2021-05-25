package com.avito.android.photo_picker.legacy;

import android.net.Uri;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.PhotoUploadKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.util.CloseableDatasourcesKt;
import com.avito.android.util.Logs;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/photo_picker/legacy/DraftPhotosWiperImpl;", "Lcom/avito/android/photo_picker/legacy/DraftPhotosWiper;", "", "wipeAll", "()V", "Lcom/avito/android/util/PrivatePhotosStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "<init>", "(Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/util/PrivatePhotosStorage;Lcom/avito/android/util/SchedulersFactory;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class DraftPhotosWiperImpl implements DraftPhotosWiper {
    public final PhotoInteractor a;
    public final PrivatePhotosStorage b;
    public final SchedulersFactory c;

    public static final class a<T, R> implements Function<CloseableDataSource<? extends PhotoUpload>, List<? extends PhotoUpload>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends PhotoUpload> apply(CloseableDataSource<? extends PhotoUpload> closeableDataSource) {
            CloseableDataSource<? extends PhotoUpload> closeableDataSource2 = closeableDataSource;
            Intrinsics.checkNotNullParameter(closeableDataSource2, "dataSource");
            return CloseableDatasourcesKt.readAllAndClose(closeableDataSource2);
        }
    }

    public static final class b<T> implements Consumer<List<? extends PhotoUpload>> {
        public final /* synthetic */ DraftPhotosWiperImpl a;

        public b(DraftPhotosWiperImpl draftPhotosWiperImpl) {
            this.a = draftPhotosWiperImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends PhotoUpload> list) {
            List<? extends PhotoUpload> list2 = list;
            DraftPhotosWiperImpl draftPhotosWiperImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "photosList");
            DraftPhotosWiperImpl.access$wipePhotos(draftPhotosWiperImpl, list2);
        }
    }

    public static final class c<T> implements Consumer<List<? extends PhotoUpload>> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends PhotoUpload> list) {
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error$default("Failed to delete draft photos", null, 2, null);
        }
    }

    public DraftPhotosWiperImpl(@NotNull PhotoInteractor photoInteractor, @NotNull PrivatePhotosStorage privatePhotosStorage, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = photoInteractor;
        this.b = privatePhotosStorage;
        this.c = schedulersFactory;
    }

    public static final void access$wipePhotos(DraftPhotosWiperImpl draftPhotosWiperImpl, List list) {
        String path;
        Objects.requireNonNull(draftPhotosWiperImpl);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PhotoUpload photoUpload = (PhotoUpload) it.next();
            Uri contentUri = photoUpload.getContentUri();
            if (!(!(contentUri != null && draftPhotosWiperImpl.b.checkFileExists(contentUri)) || contentUri == null || (path = contentUri.getPath()) == null)) {
                draftPhotosWiperImpl.b.deleteFile(new File(path));
            }
            draftPhotosWiperImpl.a.delete(String.valueOf(photoUpload.getId()));
        }
    }

    @Override // com.avito.android.photo_picker.legacy.DraftPhotosWiper
    public void wipeAll() {
        this.a.selectUploadsOfType(PhotoUploadKt.UPLOAD_TYPE_PUBLISH).firstOrError().map(a.a).doOnSuccess(new b(this)).subscribeOn(this.c.io()).observeOn(this.c.io()).subscribe(c.a, d.a);
    }
}
