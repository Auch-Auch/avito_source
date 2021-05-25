package com.avito.android.photo_wizard;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import com.avito.android.util.ByteArraysKt;
import com.avito.android.util.Dimension;
import com.avito.android.util.DimensionsKt;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardImageResizerImpl;", "Lcom/avito/android/photo_wizard/PhotoWizardImageResizer;", "", "data", "Lcom/avito/android/util/Dimension;", "scaledSize", "croppedSize", "Landroid/graphics/Point;", "offset", "Lio/reactivex/rxjava3/core/Observable;", "Landroid/graphics/Bitmap;", "resize", "([BLcom/avito/android/util/Dimension;Lcom/avito/android/util/Dimension;Landroid/graphics/Point;)Lio/reactivex/rxjava3/core/Observable;", "<init>", "()V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoWizardImageResizerImpl implements PhotoWizardImageResizer {

    public static final class a<V> implements Callable<Bitmap> {
        public final /* synthetic */ PhotoWizardImageResizerImpl a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ Dimension c;
        public final /* synthetic */ Dimension d;
        public final /* synthetic */ Point e;

        public a(PhotoWizardImageResizerImpl photoWizardImageResizerImpl, byte[] bArr, Dimension dimension, Dimension dimension2, Point point) {
            this.a = photoWizardImageResizerImpl;
            this.b = bArr;
            this.c = dimension;
            this.d = dimension2;
            this.e = point;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Bitmap call() {
            return PhotoWizardImageResizerImpl.access$savePhoto(this.a, this.b, this.c, this.d, this.e);
        }
    }

    public static final Bitmap access$savePhoto(PhotoWizardImageResizerImpl photoWizardImageResizerImpl, byte[] bArr, Dimension dimension, Dimension dimension2, Point point) {
        Dimension dimension3;
        Point point2;
        Objects.requireNonNull(photoWizardImageResizerImpl);
        Dimension calculatePhotoSize = ByteArraysKt.calculatePhotoSize(bArr);
        boolean z = true;
        if ((DimensionsKt.getAspectRatio(dimension) < 1.0f) == (DimensionsKt.getAspectRatio(calculatePhotoSize) < 1.0f)) {
            dimension3 = dimension;
        } else {
            dimension3 = new Dimension(dimension.getHeight(), dimension.getWidth());
        }
        float max = Math.max(((float) calculatePhotoSize.getHeight()) / ((float) dimension3.getHeight()), ((float) calculatePhotoSize.getWidth()) / ((float) dimension3.getWidth()));
        Dimension dimension4 = new Dimension((int) (((float) calculatePhotoSize.getWidth()) / max), (int) (((float) calculatePhotoSize.getHeight()) / max));
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(ByteArraysKt.decode$default(bArr, 0, 1, null), dimension4.getWidth(), dimension4.getHeight(), true);
        float extractPhotoRotateDegree = ByteArraysKt.extractPhotoRotateDegree(bArr);
        if (extractPhotoRotateDegree != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.postRotate(extractPhotoRotateDegree);
            createScaledBitmap = Bitmap.createBitmap(createScaledBitmap, 0, 0, dimension4.getWidth(), dimension4.getHeight(), matrix, true);
            Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "Bitmap.createBitmap(\n   …       true\n            )");
        } else {
            Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "scaledPhoto");
        }
        if (dimension2 == null) {
            return createScaledBitmap;
        }
        if (dimension.getWidth() == dimension2.getWidth() && dimension.getHeight() == dimension2.getHeight()) {
            z = false;
        }
        if (!z) {
            return createScaledBitmap;
        }
        if (point != null) {
            point2 = point;
        } else {
            point2 = new Point(0, 0);
        }
        int i = point2.x;
        Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, i, point2.y, Math.min(dimension2.getWidth() + i, createScaledBitmap.getWidth() - point2.x), Math.min(dimension2.getHeight() + point2.y, createScaledBitmap.getHeight() - point2.y));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(\n   …ght - offset.y)\n        )");
        return createBitmap;
    }

    @Override // com.avito.android.photo_wizard.PhotoWizardImageResizer
    @NotNull
    public Observable<Bitmap> resize(@NotNull byte[] bArr, @NotNull Dimension dimension, @Nullable Dimension dimension2, @Nullable Point point) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Intrinsics.checkNotNullParameter(dimension, "scaledSize");
        Observable<Bitmap> fromCallable = Observable.fromCallable(new a(this, bArr, dimension, dimension2, point));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …e, croppedSize, offset) }");
        return fromCallable;
    }
}
