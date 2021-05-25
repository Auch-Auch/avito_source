package com.avito.android.photo_picker.legacy;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.provider.MediaStore;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/photo_picker/legacy/GalleryInteractorImpl;", "Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", "Lio/reactivex/Observable;", "Lorg/funktionale/option/Option;", "Landroid/graphics/Bitmap;", "getLastTakenImagePreview", "()Lio/reactivex/Observable;", "Landroid/content/ContentResolver;", AuthSource.BOOKING_ORDER, "Landroid/content/ContentResolver;", "contentResolver", "Landroid/graphics/BitmapFactory$Options;", AuthSource.SEND_ABUSE, "Landroid/graphics/BitmapFactory$Options;", "thumbnailOptions", "<init>", "(Landroid/content/ContentResolver;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryInteractorImpl implements GalleryInteractor {
    public final BitmapFactory.Options a;
    public final ContentResolver b;

    public static final class a<V> implements Callable<Option<? extends Bitmap>> {
        public final /* synthetic */ GalleryInteractorImpl a;

        public a(GalleryInteractorImpl galleryInteractorImpl) {
            this.a = galleryInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Option<? extends Bitmap> call() {
            return OptionKt.toOption(GalleryInteractorImpl.access$getLastImageThumbnail(this.a));
        }
    }

    @Inject
    public GalleryInteractorImpl(@NotNull ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.b = contentResolver;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Unit unit = Unit.INSTANCE;
        this.a = options;
    }

    public static final Bitmap access$getLastImageThumbnail(GalleryInteractorImpl galleryInteractorImpl) {
        Bitmap thumbnail;
        Objects.requireNonNull(galleryInteractorImpl);
        Cursor query = galleryInteractorImpl.b.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "orientation"}, null, null, "datetaken DESC");
        Bitmap bitmap = null;
        if (query == null) {
            return null;
        }
        try {
            if (query.moveToFirst() && (thumbnail = MediaStore.Images.Thumbnails.getThumbnail(galleryInteractorImpl.b, query.getLong(query.getColumnIndex("_id")), 3, galleryInteractorImpl.a)) != null) {
                int i = query.getInt(query.getColumnIndex("orientation"));
                if (i > 0) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate((float) i);
                    bitmap = Bitmap.createBitmap(thumbnail, 0, 0, thumbnail.getWidth(), thumbnail.getHeight(), matrix, true);
                    thumbnail.recycle();
                } else {
                    query.close();
                    return thumbnail;
                }
            }
            query.close();
            return bitmap;
        } catch (Exception e) {
            try {
                query.close();
            } catch (Exception unused) {
            }
            throw e;
        } catch (Throwable th) {
            if (1 == 0) {
                query.close();
            }
            throw th;
        }
    }

    @Override // com.avito.android.photo_picker.legacy.GalleryInteractor
    @NotNull
    public Observable<Option<Bitmap>> getLastTakenImagePreview() {
        Observable<Option<Bitmap>> fromCallable = Observable.fromCallable(new a(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …mbnail().toOption()\n    }");
        return fromCallable;
    }
}
