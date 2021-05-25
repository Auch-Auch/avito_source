package com.avito.android.image_loader.fresco.postprocessor;

import a2.g.r.g;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import com.avito.android.image_loader.BackgroundColorReceiver;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b \u0010\u000f¨\u0006&"}, d2 = {"Lcom/avito/android/image_loader/fresco/postprocessor/DominantColorBackgroundPostProcessor;", "Lcom/facebook/imagepipeline/request/BasePostprocessor;", "Landroid/graphics/Bitmap;", "bitmap", "", "process", "(Landroid/graphics/Bitmap;)V", "Lcom/facebook/cache/common/CacheKey;", "getPostprocessorCacheKey", "()Lcom/facebook/cache/common/CacheKey;", "", "pixel", AuthSource.SEND_ABUSE, "(I)V", AuthSource.BOOKING_ORDER, "Landroid/graphics/Bitmap;", "f", "I", "pixelSum", "", "e", "[I", "pixArray", "", "Lcom/avito/android/image_loader/fresco/postprocessor/DominantColorBackgroundPostProcessor$Bucket;", "c", "Ljava/util/List;", "buckets", "Lcom/avito/android/image_loader/BackgroundColorReceiver;", g.a, "Lcom/avito/android/image_loader/BackgroundColorReceiver;", "backgroundColorReceiver", "d", "scaledBitmap", "<init>", "(Lcom/avito/android/image_loader/BackgroundColorReceiver;)V", "Bucket", "ColorVector", "image-loader-fresco_release"}, k = 1, mv = {1, 4, 2})
public final class DominantColorBackgroundPostProcessor extends BasePostprocessor {
    public Bitmap b;
    public final List<Bucket> c = new ArrayList();
    public Bitmap d;
    public int[] e;
    public int f;
    public final BackgroundColorReceiver g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/avito/android/image_loader/fresco/postprocessor/DominantColorBackgroundPostProcessor$Bucket;", "", "Lcom/avito/android/image_loader/fresco/postprocessor/DominantColorBackgroundPostProcessor$ColorVector;", VKApiConst.VERSION, "", "append", "(Lcom/avito/android/image_loader/fresco/postprocessor/DominantColorBackgroundPostProcessor$ColorVector;)V", "calculateCenter", "()V", "", AuthSource.SEND_ABUSE, "I", "getCount", "()I", "setCount", "(I)V", "count", AuthSource.BOOKING_ORDER, "sumR", "d", "sumB", "c", "sumG", "e", "Lcom/avito/android/image_loader/fresco/postprocessor/DominantColorBackgroundPostProcessor$ColorVector;", "getMainVector", "()Lcom/avito/android/image_loader/fresco/postprocessor/DominantColorBackgroundPostProcessor$ColorVector;", "setMainVector", "mainVector", "<init>", "image-loader-fresco_release"}, k = 1, mv = {1, 4, 2})
    public static final class Bucket {
        public int a;
        public int b;
        public int c;
        public int d;
        @NotNull
        public ColorVector e;

        public Bucket(@NotNull ColorVector colorVector) {
            Intrinsics.checkNotNullParameter(colorVector, "mainVector");
            this.e = colorVector;
        }

        public final void append(@NotNull ColorVector colorVector) {
            Intrinsics.checkNotNullParameter(colorVector, VKApiConst.VERSION);
            this.a++;
            this.b = colorVector.getR() + this.b;
            this.c = colorVector.getG() + this.c;
            this.d = colorVector.getB() + this.d;
        }

        public final void calculateCenter() {
            int i = this.b;
            int i2 = this.a;
            this.e = new ColorVector(i / i2, this.c / i2, this.d / i2);
        }

        public final int getCount() {
            return this.a;
        }

        @NotNull
        public final ColorVector getMainVector() {
            return this.e;
        }

        public final void setCount(int i) {
            this.a = i;
        }

        public final void setMainVector(@NotNull ColorVector colorVector) {
            Intrinsics.checkNotNullParameter(colorVector, "<set-?>");
            this.e = colorVector;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/avito/android/image_loader/fresco/postprocessor/DominantColorBackgroundPostProcessor$ColorVector;", "", "target", "", Sort.DISTANCE, "(Lcom/avito/android/image_loader/fresco/postprocessor/DominantColorBackgroundPostProcessor$ColorVector;)F", "", AuthSource.BOOKING_ORDER, "I", "getG", "()I", g.a, AuthSource.SEND_ABUSE, "getR", "r", "c", "getB", "<init>", "(III)V", "image-loader-fresco_release"}, k = 1, mv = {1, 4, 2})
    public static final class ColorVector {
        public final int a;
        public final int b;
        public final int c;

        public ColorVector(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final float distance(@NotNull ColorVector colorVector) {
            Intrinsics.checkNotNullParameter(colorVector, "target");
            float f = (float) (colorVector.a - this.a);
            float f2 = (float) (colorVector.b - this.b);
            float f3 = (float) (colorVector.c - this.c);
            return (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2) + (f * f)));
        }

        public final int getB() {
            return this.c;
        }

        public final int getG() {
            return this.b;
        }

        public final int getR() {
            return this.a;
        }
    }

    public DominantColorBackgroundPostProcessor(@NotNull BackgroundColorReceiver backgroundColorReceiver) {
        Intrinsics.checkNotNullParameter(backgroundColorReceiver, "backgroundColorReceiver");
        this.g = backgroundColorReceiver;
    }

    public final void a(int i) {
        ColorVector access$toColorVector = DominantColorBackgroundPostProcessorKt.access$toColorVector(i);
        int size = this.c.size();
        float f2 = Float.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            float distance = this.c.get(i3).getMainVector().distance(access$toColorVector);
            if (f2 > distance) {
                i2 = i3;
                f2 = distance;
            }
        }
        if (i2 != -1) {
            this.c.get(i2).append(access$toColorVector);
            return;
        }
        throw new IllegalStateException("pixel was not been placed into buckets");
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @NotNull
    public CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey("DominantColorPostprocessor");
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(@NotNull Bitmap bitmap) {
        Bitmap bitmap2;
        ColorVector mainVector;
        int i;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        super.process(bitmap);
        this.b = bitmap;
        if (bitmap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bitmap");
        }
        int width = bitmap.getWidth();
        Bitmap bitmap3 = this.b;
        if (bitmap3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bitmap");
        }
        int height = bitmap3.getHeight();
        int i2 = 100;
        if (width > 100 || height > 100) {
            if (width > height) {
                i = height / (width / 100);
            } else {
                i2 = width / (height / 100);
                i = 100;
            }
            Bitmap bitmap4 = this.b;
            if (bitmap4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bitmap");
            }
            bitmap2 = Bitmap.createScaledBitmap(bitmap4, i2, i, true);
            Intrinsics.checkNotNullExpressionValue(bitmap2, "Bitmap.createScaledBitma…esWidth, resHeight, true)");
        } else {
            Bitmap bitmap5 = this.b;
            if (bitmap5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bitmap");
            }
            Bitmap bitmap6 = this.b;
            if (bitmap6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bitmap");
            }
            bitmap2 = bitmap5.copy(bitmap6.getConfig(), false);
            Intrinsics.checkNotNullExpressionValue(bitmap2, "bitmap.copy(bitmap.config, false)");
        }
        this.d = bitmap2;
        if (bitmap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
        }
        int width2 = bitmap2.getWidth();
        Bitmap bitmap7 = this.d;
        if (bitmap7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
        }
        int height2 = bitmap7.getHeight() * width2;
        this.f = height2;
        this.e = new int[height2];
        Bitmap bitmap8 = this.d;
        if (bitmap8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
        }
        int[] iArr = this.e;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixArray");
        }
        Bitmap bitmap9 = this.d;
        if (bitmap9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
        }
        int width3 = bitmap9.getWidth();
        Bitmap bitmap10 = this.d;
        if (bitmap10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
        }
        int width4 = bitmap10.getWidth();
        Bitmap bitmap11 = this.d;
        if (bitmap11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
        }
        bitmap8.getPixels(iArr, 0, width3, 0, 0, width4, bitmap11.getHeight());
        IntProgression step = e.step(e.until(0, this.f), (int) ((float) Math.ceil((double) (((float) this.f) / ((float) 12)))));
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? first >= last : first <= last) {
            while (true) {
                List<Bucket> list = this.c;
                int[] iArr2 = this.e;
                if (iArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pixArray");
                }
                list.add(new Bucket(DominantColorBackgroundPostProcessorKt.access$toColorVector(iArr2[first])));
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        int i3 = 0;
        while (true) {
            if (i3 < 8) {
                Bitmap bitmap12 = this.d;
                if (bitmap12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
                }
                int coerceAtLeast = e.coerceAtLeast((int) Math.floor(((double) bitmap12.getWidth()) * 0.2d), 10);
                Bitmap bitmap13 = this.d;
                if (bitmap13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
                }
                int height3 = bitmap13.getHeight();
                for (int i4 = 0; i4 < height3; i4++) {
                    int i5 = 0;
                    while (i5 < coerceAtLeast) {
                        int[] iArr3 = this.e;
                        if (iArr3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pixArray");
                        }
                        Bitmap bitmap14 = this.d;
                        if (bitmap14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
                        }
                        a(iArr3[(bitmap14.getWidth() * i4) + i5]);
                        int[] iArr4 = this.e;
                        if (iArr4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pixArray");
                        }
                        int i6 = i4 + 1;
                        Bitmap bitmap15 = this.d;
                        if (bitmap15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
                        }
                        i5++;
                        a(iArr4[(bitmap15.getWidth() * i6) - i5]);
                    }
                }
                Bitmap bitmap16 = this.d;
                if (bitmap16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
                }
                int coerceAtLeast2 = e.coerceAtLeast((int) Math.floor(((double) bitmap16.getHeight()) * 0.2d), 10);
                for (int i7 = 0; i7 < coerceAtLeast2; i7++) {
                    Bitmap bitmap17 = this.d;
                    if (bitmap17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
                    }
                    int width5 = bitmap17.getWidth() - coerceAtLeast;
                    int i8 = coerceAtLeast;
                    while (i8 < width5) {
                        int[] iArr5 = this.e;
                        if (iArr5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pixArray");
                        }
                        Bitmap bitmap18 = this.d;
                        if (bitmap18 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
                        }
                        a(iArr5[(bitmap18.getWidth() * i7) + i8]);
                        int[] iArr6 = this.e;
                        if (iArr6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pixArray");
                        }
                        int i9 = i7 + 1;
                        Bitmap bitmap19 = this.d;
                        if (bitmap19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
                        }
                        i8++;
                        a(iArr6[(bitmap19.getWidth() * i9) - i8]);
                    }
                }
                ArrayList arrayList = new ArrayList();
                int size = this.c.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Bucket bucket = this.c.get(i10);
                    if (bucket.getCount() == 0) {
                        arrayList.add(bucket);
                    } else {
                        bucket.calculateCenter();
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.c.remove((Bucket) it.next());
                }
                if (this.c.size() == 1) {
                    mainVector = this.c.get(0).getMainVector();
                    break;
                }
                i3++;
            } else {
                int size2 = this.c.size();
                int i11 = -1;
                int i12 = 0;
                for (int i13 = 0; i13 < size2; i13++) {
                    if (this.c.get(i13).getCount() > i12) {
                        i12 = this.c.get(i13).getCount();
                        i11 = i13;
                    }
                }
                mainVector = this.c.get(i11).getMainVector();
            }
        }
        Bitmap bitmap20 = this.d;
        if (bitmap20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scaledBitmap");
        }
        bitmap20.recycle();
        this.g.onColorReceived(new ColorDrawable(Color.argb(255, mainVector.getR(), mainVector.getG(), mainVector.getB())));
    }
}
