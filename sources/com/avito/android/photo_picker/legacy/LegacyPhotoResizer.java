package com.avito.android.photo_picker.legacy;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ByteArraysKt;
import com.avito.android.util.Dimension;
import com.avito.android.util.DimensionsKt;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/photo_picker/legacy/LegacyPhotoResizer;", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "", "photoData", "Lcom/avito/android/util/Dimension;", "desiredSize", "", "rotation", "Lio/reactivex/Observable;", "Landroid/graphics/Bitmap;", "resize", "([BLcom/avito/android/util/Dimension;F)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "", "jpegQuality", "<init>", "(Lcom/avito/android/util/SchedulersFactory;I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPhotoResizer implements PhotoResizer {
    public final SchedulersFactory a;

    public static final class a<V> implements Callable<Bitmap> {
        public final /* synthetic */ LegacyPhotoResizer a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ Dimension c;

        public a(LegacyPhotoResizer legacyPhotoResizer, byte[] bArr, Dimension dimension) {
            this.a = legacyPhotoResizer;
            this.b = bArr;
            this.c = dimension;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Bitmap call() {
            return LegacyPhotoResizer.access$resizePhoto(this.a, this.b, this.c);
        }
    }

    public LegacyPhotoResizer(@NotNull SchedulersFactory schedulersFactory, int i) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = schedulersFactory;
    }

    public static final Bitmap access$resizePhoto(LegacyPhotoResizer legacyPhotoResizer, byte[] bArr, Dimension dimension) {
        Objects.requireNonNull(legacyPhotoResizer);
        Dimension calculatePhotoSize = ByteArraysKt.calculatePhotoSize(bArr);
        if ((DimensionsKt.getAspectRatio(dimension) < 1.0f) != (DimensionsKt.getAspectRatio(calculatePhotoSize) < 1.0f)) {
            dimension = new Dimension(dimension.getHeight(), dimension.getWidth());
        }
        float extractPhotoRotateDegree = ByteArraysKt.extractPhotoRotateDegree(bArr);
        float min = Math.min(((float) calculatePhotoSize.getHeight()) / ((float) dimension.getHeight()), ((float) calculatePhotoSize.getWidth()) / ((float) dimension.getWidth()));
        Dimension dimension2 = new Dimension((int) (((float) calculatePhotoSize.getWidth()) / min), (int) (((float) calculatePhotoSize.getHeight()) / min));
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(ByteArraysKt.decode$default(bArr, 0, 1, null), dimension2.getWidth(), dimension2.getHeight(), true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "photo");
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(extractPhotoRotateDegree);
        Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, (createScaledBitmap.getWidth() - dimension.getWidth()) / 2, (createScaledBitmap.getHeight() - dimension.getHeight()) / 2, width, height, matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(\n   …           true\n        )");
        return createBitmap;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoResizer
    @NotNull
    public Observable<Bitmap> resize(@NotNull byte[] bArr, @NotNull Dimension dimension, float f) {
        Intrinsics.checkNotNullParameter(bArr, "photoData");
        Intrinsics.checkNotNullParameter(dimension, "desiredSize");
        return a2.b.a.a.a.T1(this.a, Observable.fromCallable(new a(this, bArr, dimension)).subscribeOn(this.a.io()), "Observable.fromCallable …(schedulers.mainThread())");
    }
}
