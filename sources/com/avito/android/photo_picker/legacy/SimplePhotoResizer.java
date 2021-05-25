package com.avito.android.photo_picker.legacy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.avito.android.util.Dimension;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/photo_picker/legacy/SimplePhotoResizer;", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "", "photoData", "Lcom/avito/android/util/Dimension;", "desiredSize", "", "rotation", "Lio/reactivex/Observable;", "Landroid/graphics/Bitmap;", "resize", "([BLcom/avito/android/util/Dimension;F)Lio/reactivex/Observable;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SimplePhotoResizer implements PhotoResizer {

    public static final class a<V> implements Callable<Bitmap> {
        public final /* synthetic */ SimplePhotoResizer a;
        public final /* synthetic */ byte[] b;

        public a(SimplePhotoResizer simplePhotoResizer, byte[] bArr) {
            this.a = simplePhotoResizer;
            this.b = bArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Bitmap call() {
            byte[] bArr = this.b;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, new BitmapFactory.Options());
            SimplePhotoResizer simplePhotoResizer = this.a;
            Intrinsics.checkNotNullExpressionValue(decodeByteArray, "bitmap");
            return SimplePhotoResizer.access$rotateByExifInfo(simplePhotoResizer, decodeByteArray, this.b);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        throw r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.Bitmap access$rotateByExifInfo(com.avito.android.photo_picker.legacy.SimplePhotoResizer r8, android.graphics.Bitmap r9, byte[] r10) {
        /*
            java.util.Objects.requireNonNull(r8)
            java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream
            r8.<init>(r10)
            androidx.exifinterface.media.ExifInterface r10 = new androidx.exifinterface.media.ExifInterface     // Catch:{ all -> 0x0050 }
            r10.<init>(r8)     // Catch:{ all -> 0x0050 }
            java.lang.String r0 = "Orientation"
            r1 = 1
            int r10 = r10.getAttributeInt(r0, r1)     // Catch:{ all -> 0x0050 }
            r0 = 0
            if (r10 != 0) goto L_0x001b
            kotlin.io.CloseableKt.closeFinally(r8, r0)
            goto L_0x004f
        L_0x001b:
            r1 = 3
            if (r10 == r1) goto L_0x002d
            r1 = 6
            if (r10 == r1) goto L_0x002a
            r1 = 8
            if (r10 == r1) goto L_0x0027
            r10 = 0
            goto L_0x002f
        L_0x0027:
            r10 = 1132920832(0x43870000, float:270.0)
            goto L_0x002f
        L_0x002a:
            r10 = 1119092736(0x42b40000, float:90.0)
            goto L_0x002f
        L_0x002d:
            r10 = 1127481344(0x43340000, float:180.0)
        L_0x002f:
            r2 = 0
            r3 = 0
            int r4 = r9.getWidth()
            int r5 = r9.getHeight()
            android.graphics.Matrix r6 = new android.graphics.Matrix
            r6.<init>()
            r6.postRotate(r10)
            r7 = 1
            r1 = r9
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)
            kotlin.io.CloseableKt.closeFinally(r8, r0)
            java.lang.String r8 = "ByteArrayInputStream(pho… \n            )\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r8)
        L_0x004f:
            return r9
        L_0x0050:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r10 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.photo_picker.legacy.SimplePhotoResizer.access$rotateByExifInfo(com.avito.android.photo_picker.legacy.SimplePhotoResizer, android.graphics.Bitmap, byte[]):android.graphics.Bitmap");
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoResizer
    @NotNull
    public Observable<Bitmap> resize(@NotNull byte[] bArr, @NotNull Dimension dimension, float f) {
        Intrinsics.checkNotNullParameter(bArr, "photoData");
        Intrinsics.checkNotNullParameter(dimension, "desiredSize");
        Observable<Bitmap> fromCallable = Observable.fromCallable(new a(this, bArr));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …map, photoData)\n        }");
        return fromCallable;
    }
}
