package com.avito.android.photo_picker.legacy;

import a2.a.a.x1.q.i;
import a2.a.a.x1.q.j;
import a2.a.a.x1.q.k;
import a2.a.a.x1.q.l;
import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.analytics.AddPhotoEvent;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.analytics.RemovePhotoEvent;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo.ImageConvertOptions;
import com.avito.android.photo.ThumbnailProvider;
import com.avito.android.photo_picker.ExifExtraData;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifUtilsKt;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.SelectedPhoto;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.util.CloseableDatasourcesKt;
import com.avito.android.util.Logs;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u00105\u001a\u00020\u0015\u0012\u0006\u0010J\u001a\u00020\u0015\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010N\u001a\u00020K\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u00109\u001a\u000206\u0012\b\u0010O\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\bP\u0010QJ)\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J)\u0010\"\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 !*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u001aR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u00104R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006R"}, d2 = {"Lcom/avito/android/photo_picker/legacy/SingleCachePhotoInteractor;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "", "Lcom/avito/android/photo_picker/SelectedPhoto;", "selectedPhotos", "Lio/reactivex/Single;", "Lcom/avito/android/photo_picker/legacy/PickerPhoto;", "createPhotos", "(Ljava/util/List;)Lio/reactivex/Single;", "photos", "getThumbnails", "", "position1", "position2", "", "swapPhotos", "(II)V", "", "Lio/reactivex/Observable;", "addPhotos", "(Ljava/lang/Iterable;)Lio/reactivex/Observable;", "", "id", "removePhoto", "(Ljava/lang/String;)V", "select", "()Lio/reactivex/Single;", "Lio/reactivex/Completable;", "commit", "()Lio/reactivex/Completable;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState;", "getState", "()Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "i", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "cvInteractor", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "c", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "Lcom/avito/android/photo/BitmapFileProvider;", "d", "Lcom/avito/android/photo/BitmapFileProvider;", "bitmapFileProvider", "f", "Ljava/lang/String;", "operationId", "Lcom/avito/android/Features;", "l", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "k", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "exifExtraDataSerializer", "", "Ljava/util/List;", "photosCache", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "h", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "eventTracker", "Lcom/avito/android/photo/ThumbnailProvider;", "e", "Lcom/avito/android/photo/ThumbnailProvider;", "thumbnailProvider", a2.g.r.g.a, "typeId", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "state", "<init>", "(Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;Lcom/avito/android/photo/BitmapFileProvider;Lcom/avito/android/photo/ThumbnailProvider;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/PhotoPickerEventTracker;Lcom/avito/android/computer_vision/ComputerVisionInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/ExifExtraDataSerializer;Lcom/avito/android/Features;Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractorState;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SingleCachePhotoInteractor implements PhotoPickerInteractor {
    public List<PickerPhoto> a;
    public final PhotoInteractor b;
    public final SharedPhotosStorage c;
    public final BitmapFileProvider d;
    public final ThumbnailProvider e;
    public final String f;
    public final String g;
    public final PhotoPickerEventTracker h;
    public final ComputerVisionInteractor i;
    public final SchedulersFactory j;
    public final ExifExtraDataSerializer k;
    public final Features l;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<PickerPhoto> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(PickerPhoto pickerPhoto) {
            int i = this.a;
            if (i == 0) {
                PickerPhoto pickerPhoto2 = pickerPhoto;
                Iterator it = ((SingleCachePhotoInteractor) this.b).a.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    } else if (Intrinsics.areEqual(((PickerPhoto) it.next()).getId(), pickerPhoto2.getId())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == -1) {
                    List list = ((SingleCachePhotoInteractor) this.b).a;
                    Intrinsics.checkNotNullExpressionValue(pickerPhoto2, "photo");
                    list.add(pickerPhoto2);
                } else {
                    List list2 = ((SingleCachePhotoInteractor) this.b).a;
                    Intrinsics.checkNotNullExpressionValue(pickerPhoto2, "photo");
                    list2.set(i2, pickerPhoto2);
                }
                ((SingleCachePhotoInteractor) this.b).h.track(new AddPhotoEvent(String.valueOf(pickerPhoto2.getFrom())));
            } else if (i == 1) {
                ((SingleCachePhotoInteractor) this.b).i.processPhoto(pickerPhoto.getSource());
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<PickerPhoto, SingleSource<? extends PickerPhoto>> {
        public final /* synthetic */ SingleCachePhotoInteractor a;

        public b(SingleCachePhotoInteractor singleCachePhotoInteractor) {
            this.a = singleCachePhotoInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends PickerPhoto> apply(PickerPhoto pickerPhoto) {
            PickerPhoto pickerPhoto2 = pickerPhoto;
            Intrinsics.checkNotNullParameter(pickerPhoto2, "photo");
            return SingleCachePhotoInteractor.access$cacheExternalPhoto(this.a, pickerPhoto2.getSource()).map(new i(pickerPhoto2));
        }
    }

    public static final class c<V> implements Callable<Object> {
        public final /* synthetic */ SingleCachePhotoInteractor a;

        public c(SingleCachePhotoInteractor singleCachePhotoInteractor) {
            this.a = singleCachePhotoInteractor;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            SingleCachePhotoInteractor.access$commitActions(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ SingleCachePhotoInteractor a;

        public e(SingleCachePhotoInteractor singleCachePhotoInteractor) {
            this.a = singleCachePhotoInteractor;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            SingleCachePhotoInteractor singleCachePhotoInteractor = this.a;
            Object blockingGet = singleCachePhotoInteractor.a().blockingGet();
            Intrinsics.checkNotNullExpressionValue(blockingGet, "selectFromDb().blockingGet()");
            singleCachePhotoInteractor.a = CollectionsKt___CollectionsKt.toMutableList((Collection) blockingGet);
            for (PickerPhoto pickerPhoto : this.a.a) {
                this.a.i.updateIds(pickerPhoto.getId(), pickerPhoto.getSource());
            }
        }
    }

    public static final class f<T, R> implements Function<PickerPhoto, SingleSource<? extends PickerPhoto>> {
        public final /* synthetic */ SingleCachePhotoInteractor a;

        public f(SingleCachePhotoInteractor singleCachePhotoInteractor) {
            this.a = singleCachePhotoInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends PickerPhoto> apply(PickerPhoto pickerPhoto) {
            PickerPhoto pickerPhoto2 = pickerPhoto;
            Intrinsics.checkNotNullParameter(pickerPhoto2, "photo");
            return this.a.e.getThumbnail(pickerPhoto2.getSource()).onErrorComplete().map(new l(pickerPhoto2)).toSingle(pickerPhoto2);
        }
    }

    public static final class g<T, R> implements Function<CloseableDataSource<? extends PhotoUpload>, List<? extends PhotoUpload>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends PhotoUpload> apply(CloseableDataSource<? extends PhotoUpload> closeableDataSource) {
            CloseableDataSource<? extends PhotoUpload> closeableDataSource2 = closeableDataSource;
            Intrinsics.checkNotNullParameter(closeableDataSource2, "it");
            return CloseableDatasourcesKt.readAllAndClose(closeableDataSource2);
        }
    }

    public static final class h<T, R> implements Function<List<? extends PhotoUpload>, List<? extends PickerPhoto>> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends PickerPhoto> apply(List<? extends PhotoUpload> list) {
            List<? extends PhotoUpload> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "data");
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list2, 10));
            for (T t : list2) {
                String valueOf = String.valueOf(t.getId());
                Uri sourceUri = t.getSourceUri();
                if (sourceUri == null) {
                    sourceUri = Uri.EMPTY;
                }
                Intrinsics.checkNotNullExpressionValue(sourceUri, "it.sourceUri ?: Uri.EMPTY");
                arrayList.add(new PickerPhoto(valueOf, sourceUri, t.getPosition(), 0, null, t.getContentUri(), t.getUploadId(), 16, null));
            }
            return arrayList;
        }
    }

    public SingleCachePhotoInteractor(@NotNull PhotoInteractor photoInteractor, @NotNull SharedPhotosStorage sharedPhotosStorage, @NotNull BitmapFileProvider bitmapFileProvider, @NotNull ThumbnailProvider thumbnailProvider, @NotNull String str, @NotNull String str2, @NotNull PhotoPickerEventTracker photoPickerEventTracker, @NotNull ComputerVisionInteractor computerVisionInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ExifExtraDataSerializer exifExtraDataSerializer, @NotNull Features features, @Nullable PhotoPickerInteractorState photoPickerInteractorState) {
        List<PickerPhoto> list;
        List<PickerPhoto> photosCache;
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(sharedPhotosStorage, "sharedPhotosStorage");
        Intrinsics.checkNotNullParameter(bitmapFileProvider, "bitmapFileProvider");
        Intrinsics.checkNotNullParameter(thumbnailProvider, "thumbnailProvider");
        Intrinsics.checkNotNullParameter(str, "operationId");
        Intrinsics.checkNotNullParameter(str2, "typeId");
        Intrinsics.checkNotNullParameter(photoPickerEventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(computerVisionInteractor, "cvInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(exifExtraDataSerializer, "exifExtraDataSerializer");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = photoInteractor;
        this.c = sharedPhotosStorage;
        this.d = bitmapFileProvider;
        this.e = thumbnailProvider;
        this.f = str;
        this.g = str2;
        this.h = photoPickerEventTracker;
        this.i = computerVisionInteractor;
        this.j = schedulersFactory;
        this.k = exifExtraDataSerializer;
        this.l = features;
        if (photoPickerInteractorState == null || (photosCache = photoPickerInteractorState.getPhotosCache()) == null || (list = CollectionsKt___CollectionsKt.toMutableList((Collection) photosCache)) == null) {
            List<PickerPhoto> blockingGet = a().blockingGet();
            Intrinsics.checkNotNullExpressionValue(blockingGet, "selectFromDb().blockingGet()");
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) blockingGet);
        }
        this.a = list == null ? new ArrayList<>() : list;
    }

    public static final Single access$cacheExternalPhoto(SingleCachePhotoInteractor singleCachePhotoInteractor, Uri uri) {
        ImageConvertOptions imageConvertOptions;
        if (!(!singleCachePhotoInteractor.c.checkPhotoIsLocal(uri))) {
            return Singles.toSingle(uri);
        }
        BitmapFileProvider bitmapFileProvider = singleCachePhotoInteractor.d;
        if (singleCachePhotoInteractor.l.getEnlargePhotosOnPublish().invoke().booleanValue()) {
            imageConvertOptions = new ImageConvertOptions(2400, 3200, 95, Integer.MAX_VALUE);
        } else {
            imageConvertOptions = new ImageConvertOptions(1200, 1600, 95, Integer.MAX_VALUE);
        }
        Single<R> map = bitmapFileProvider.getConvertedFileForUri(uri, imageConvertOptions).doOnNext(new j(singleCachePhotoInteractor)).firstOrError().map(k.a);
        Intrinsics.checkNotNullExpressionValue(map, "bitmapFileProvider\n     …{ Uri.fromFile(it.file) }");
        return map;
    }

    public static final void access$commitActions(SingleCachePhotoInteractor singleCachePhotoInteractor) {
        List<PickerPhoto> blockingGet = singleCachePhotoInteractor.a().blockingGet();
        Intrinsics.checkNotNullExpressionValue(blockingGet, "photosInDb");
        for (PickerPhoto pickerPhoto : CollectionsKt___CollectionsKt.minus((Iterable) blockingGet, (Iterable) singleCachePhotoInteractor.a)) {
            singleCachePhotoInteractor.b.delete(pickerPhoto.getId());
        }
        for (PickerPhoto pickerPhoto2 : CollectionsKt___CollectionsKt.minus((Iterable) singleCachePhotoInteractor.a, (Iterable) blockingGet)) {
            singleCachePhotoInteractor.b.add(singleCachePhotoInteractor.g, singleCachePhotoInteractor.f, null, pickerPhoto2.getPosition(), pickerPhoto2.getUri(), pickerPhoto2.getSource());
        }
        int i2 = 0;
        for (T t : singleCachePhotoInteractor.a) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            PhotoInteractor photoInteractor = singleCachePhotoInteractor.b;
            Uri uri = t.getUri();
            Intrinsics.checkNotNull(uri);
            photoInteractor.updatePosition(uri, i2);
            i2 = i3;
        }
    }

    public static final void access$copyExifData(SingleCachePhotoInteractor singleCachePhotoInteractor, Map map, File file) {
        ExifUtilsKt.setExtraData(map, singleCachePhotoInteractor.k.serialize(new ExifExtraData((String) map.get(ExifInterface.TAG_IMAGE_WIDTH), (String) map.get(ExifInterface.TAG_IMAGE_LENGTH))));
        ExifUtilsKt.setAttributesAndSave(new ExifInterface(file), map);
    }

    public final Single<List<PickerPhoto>> a() {
        Single<R> map = this.b.select(this.f).firstOrError().map(g.a).map(h.a);
        Intrinsics.checkNotNullExpressionValue(map, "photoInteractor.select(o…)\n            }\n        }");
        return map;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerInteractor
    @NotNull
    public Observable<PickerPhoto> addPhotos(@NotNull Iterable<PickerPhoto> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "photos");
        Observable<PickerPhoto> subscribeOn = Observables.toObservable(iterable).flatMapSingle(new b(this)).observeOn(this.j.mainThread()).doOnNext(new a(0, this)).observeOn(this.j.computation()).doOnNext(new a(1, this)).subscribeOn(this.j.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "photos.toObservable()\n  …ersFactory.computation())");
        return subscribeOn;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerInteractor
    @NotNull
    public Completable commit() {
        Completable subscribeOn = Completable.fromCallable(new c(this)).doOnError(d.a).onErrorComplete().observeOn(this.j.mainThread()).doOnComplete(new e(this)).observeOn(this.j.io()).subscribeOn(this.j.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Completable\n            …n(schedulersFactory.io())");
        return subscribeOn;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerInteractor
    @NotNull
    public Single<List<PickerPhoto>> createPhotos(@NotNull List<SelectedPhoto> list) {
        Intrinsics.checkNotNullParameter(list, "selectedPhotos");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            arrayList.add(new PickerPhoto(t2.getId(), t2.getUri(), this.a.size() + i2, PhotoSourceKt.toInt(t2.getSource()), null, null, null, 112, null));
            i2 = i3;
        }
        return Singles.toSingle(arrayList);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerInteractor
    @NotNull
    public PhotoPickerInteractorState getState() {
        return new PhotoPickerInteractorState(this.a);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerInteractor
    @NotNull
    public Single<List<PickerPhoto>> getThumbnails(@NotNull List<PickerPhoto> list) {
        Intrinsics.checkNotNullParameter(list, "photos");
        return a2.b.a.a.a.V1(this.j, Observables.toObservable(list).flatMapSingle(new f(this)).toList(), "photos.toObservable()\n  …n(schedulersFactory.io())");
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerInteractor
    @MainThread
    public void removePhoto(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.i.removePhoto(str);
        Iterator<PickerPhoto> it = this.a.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), str)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            this.a.remove(i2);
            this.h.track(RemovePhotoEvent.INSTANCE);
            return;
        }
        Logs.error$default(a2.b.a.a.a.d3("Cannot find item with id = '", str, '\''), null, 2, null);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerInteractor
    @NotNull
    public Single<List<PickerPhoto>> select() {
        Single<List<PickerPhoto>> just = Single.just(this.a);
        Intrinsics.checkNotNullExpressionValue(just, "Single.just(photosCache)");
        return just;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerInteractor
    @MainThread
    public void swapPhotos(int i2, int i3) {
        Collections.swap(this.a, i2, i3);
    }
}
