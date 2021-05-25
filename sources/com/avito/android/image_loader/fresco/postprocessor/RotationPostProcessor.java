package com.avito.android.image_loader.fresco.postprocessor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import androidx.annotation.VisibleForTesting;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Rotation;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/image_loader/fresco/postprocessor/RotationPostProcessor;", "Lcom/facebook/imagepipeline/request/BasePostprocessor;", "Landroid/graphics/Bitmap;", "sourceBitmap", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapFactory", "Lcom/facebook/common/references/CloseableReference;", "process", "(Landroid/graphics/Bitmap;Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;)Lcom/facebook/common/references/CloseableReference;", "Lcom/avito/android/util/Rotation;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/Rotation;", "getRotation", "()Lcom/avito/android/util/Rotation;", "rotation", "<init>", "(Lcom/avito/android/util/Rotation;)V", "image-loader-fresco_release"}, k = 1, mv = {1, 4, 2})
public final class RotationPostProcessor extends BasePostprocessor {
    @NotNull
    public final Rotation b;

    public RotationPostProcessor(@VisibleForTesting @NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        this.b = rotation;
    }

    @NotNull
    public final Rotation getRotation() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CloseableReference<Bitmap> process(@NotNull Bitmap bitmap, @NotNull PlatformBitmapFactory platformBitmapFactory) {
        Point point;
        Point point2;
        Intrinsics.checkNotNullParameter(bitmap, "sourceBitmap");
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "bitmapFactory");
        boolean z = Intrinsics.areEqual(this.b, new Rotation.Rotation_270()) || Intrinsics.areEqual(this.b, new Rotation.Rotation_90());
        int height = z ? bitmap.getHeight() : bitmap.getWidth();
        int width = z ? bitmap.getWidth() : bitmap.getHeight();
        try {
            CloseableReference<Bitmap> createBitmap = platformBitmapFactory.createBitmap(height, width);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmapFactory.createBitm…esultWidth, resultHeight)");
            try {
                Rotation rotation = this.b;
                if (rotation instanceof Rotation.Rotation_90) {
                    point = new Point(height / 2, height / 2);
                } else {
                    if (rotation instanceof Rotation.Rotation_270) {
                        point2 = new Point(width / 2, width / 2);
                    } else if (rotation instanceof Rotation.Rotation_180) {
                        point2 = new Point(height / 2, width / 2);
                    } else {
                        point = new Point(0, 0);
                    }
                    point = point2;
                }
                Matrix matrix = new Matrix();
                matrix.setRotate((float) this.b.getDegree(), (float) point.x, (float) point.y);
                new Canvas(createBitmap.get()).drawBitmap(bitmap, matrix, null);
                return CloseableReference.cloneOrNull(createBitmap);
            } finally {
                CloseableReference.closeSafely(createBitmap);
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
