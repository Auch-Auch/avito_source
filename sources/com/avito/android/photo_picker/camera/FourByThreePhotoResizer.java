package com.avito.android.photo_picker.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.avito.android.di.PerFragment;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Dimension;
import io.reactivex.Observable;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/photo_picker/camera/FourByThreePhotoResizer;", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "", "photoData", "Lcom/avito/android/util/Dimension;", "desiredSize", "", "rotation", "Lio/reactivex/Observable;", "Landroid/graphics/Bitmap;", "resize", "([BLcom/avito/android/util/Dimension;F)Lio/reactivex/Observable;", "", "capturedShortSide", AuthSource.SEND_ABUSE, "(I)I", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class FourByThreePhotoResizer implements PhotoResizer {

    public static final class a<V> implements Callable<Bitmap> {
        public final /* synthetic */ FourByThreePhotoResizer a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ float c;

        public a(FourByThreePhotoResizer fourByThreePhotoResizer, byte[] bArr, float f) {
            this.a = fourByThreePhotoResizer;
            this.b = bArr;
            this.c = f;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Bitmap call() {
            Bitmap bitmap;
            byte[] bArr = this.b;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Intrinsics.checkNotNullExpressionValue(decodeByteArray, "capturedImage");
            if (decodeByteArray.getWidth() < decodeByteArray.getHeight()) {
                bitmap = FourByThreePhotoResizer.access$cropImage(this.a, decodeByteArray);
            } else {
                bitmap = FourByThreePhotoResizer.access$cropImageWithRotate(this.a, decodeByteArray, this.c);
            }
            decodeByteArray.recycle();
            return bitmap;
        }
    }

    public static final Bitmap access$cropImage(FourByThreePhotoResizer fourByThreePhotoResizer, Bitmap bitmap) {
        Objects.requireNonNull(fourByThreePhotoResizer);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - fourByThreePhotoResizer.a(bitmap.getWidth())) / 2, bitmap.getWidth(), fourByThreePhotoResizer.a(bitmap.getWidth()), (Matrix) null, false);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(\n   …          false\n        )");
        return createBitmap;
    }

    public static final Bitmap access$cropImageWithRotate(FourByThreePhotoResizer fourByThreePhotoResizer, Bitmap bitmap, float f) {
        Objects.requireNonNull(fourByThreePhotoResizer);
        int width = (bitmap.getWidth() - fourByThreePhotoResizer.a(bitmap.getHeight())) / 2;
        int a3 = fourByThreePhotoResizer.a(bitmap.getHeight());
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, width, 0, a3, height, matrix, false);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(\n   …          false\n        )");
        return createBitmap;
    }

    public final int a(int i) {
        return (int) ((((float) i) * 3.0f) / 4.0f);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoResizer
    @NotNull
    public Observable<Bitmap> resize(@NotNull byte[] bArr, @NotNull Dimension dimension, float f) {
        Intrinsics.checkNotNullParameter(bArr, "photoData");
        Intrinsics.checkNotNullParameter(dimension, "desiredSize");
        Observable<Bitmap> fromCallable = Observable.fromCallable(new a(this, bArr, f));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …   croppedImage\n        }");
        return fromCallable;
    }
}
