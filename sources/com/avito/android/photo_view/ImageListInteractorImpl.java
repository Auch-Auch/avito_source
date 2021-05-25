package com.avito.android.photo_view;

import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.util.CloseableDatasourcesKt;
import com.avito.android.util.SchedulersFactory;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/photo_view/ImageListInteractorImpl;", "Lcom/avito/android/photo_view/ImageListInteractor;", "Lio/reactivex/Observable;", "", "Lcom/avito/android/photo_view/ImageData;", "select", "()Lio/reactivex/Observable;", "", "fromPosition", "toPosition", "", "move", "(II)V", "", "id", ProductAction.ACTION_REMOVE, "(Ljava/lang/String;)V", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "draftId", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "c", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "<init>", "(Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/legacy/PhotoInteractor;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class ImageListInteractorImpl implements ImageListInteractor {
    public final String a;
    public final SchedulersFactory b;
    public final PhotoInteractor c;

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

    public static final class b<T, R> implements Function<List<? extends PhotoUpload>, List<? extends ImageData>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends ImageData> apply(List<? extends PhotoUpload> list) {
            List<? extends PhotoUpload> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "photoList");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(ImageListInteractorKt.access$toImageData(it.next()));
            }
            return arrayList;
        }
    }

    public ImageListInteractorImpl(@NotNull String str, @NotNull SchedulersFactory schedulersFactory, @NotNull PhotoInteractor photoInteractor) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        this.a = str;
        this.b = schedulersFactory;
        this.c = photoInteractor;
    }

    @Override // com.avito.android.photo_view.ImageListInteractor
    public void move(int i, int i2) {
        this.c.move(i, i2);
    }

    @Override // com.avito.android.photo_view.ImageListInteractor
    public void remove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.c.delete(str);
    }

    @Override // com.avito.android.photo_view.ImageListInteractor
    @NotNull
    public Observable<List<ImageData>> select() {
        Observable<R> subscribeOn = this.c.select(this.a).map(a.a).map(b.a).subscribeOn(this.b.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "photoInteractor.select(d…ersFactory.computation())");
        return subscribeOn;
    }
}
