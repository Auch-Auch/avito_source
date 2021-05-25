package com.avito.android.photo_picker;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import com.avito.android.krop.util.Transformation;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.CloseablesKt;
import com.avito.android.util.PrivatePhotosStorage;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J/\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012¨\u0006!"}, d2 = {"Lcom/avito/android/photo_picker/BitmapTransformerImpl;", "Lcom/avito/android/photo_picker/BitmapTransformer;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/krop/util/Transformation;", "transformation", "", "quality", "Lio/reactivex/Observable;", "transformBitmap", "(Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;I)Lio/reactivex/Observable;", "Landroid/graphics/RectF;", "viewport", "bitmapWidth", "bitmapHeight", AuthSource.SEND_ABUSE, "(Landroid/graphics/RectF;Lcom/avito/android/krop/util/Transformation;II)Landroid/graphics/RectF;", "e", "I", "cropOffset", "d", "cropWidth", "Landroid/content/ContentResolver;", "Landroid/content/ContentResolver;", "contentResolver", "Lcom/avito/android/util/PrivatePhotosStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "c", "cropHeight", "<init>", "(Landroid/content/ContentResolver;Lcom/avito/android/util/PrivatePhotosStorage;III)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class BitmapTransformerImpl implements BitmapTransformer {
    public final ContentResolver a;
    public final PrivatePhotosStorage b;
    public final int c;
    public final int d;
    public final int e;

    public static final class a<T> implements ObservableOnSubscribe<Uri> {
        public final /* synthetic */ BitmapTransformerImpl a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ Transformation c;
        public final /* synthetic */ int d;

        public a(BitmapTransformerImpl bitmapTransformerImpl, Uri uri, Transformation transformation, int i) {
            this.a = bitmapTransformerImpl;
            this.b = uri;
            this.c = transformation;
            this.d = i;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Uri> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "subscriber");
            try {
                Uri access$transform = BitmapTransformerImpl.access$transform(this.a, this.b, this.c, this.d);
                if (access$transform == null) {
                    observableEmitter.onError(new IOException());
                    return;
                }
                observableEmitter.onNext(access$transform);
                observableEmitter.onComplete();
            } catch (Exception e) {
                observableEmitter.onError(e);
            }
        }
    }

    public BitmapTransformerImpl(@NotNull ContentResolver contentResolver, @NotNull PrivatePhotosStorage privatePhotosStorage, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        this.a = contentResolver;
        this.b = privatePhotosStorage;
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    /* JADX INFO: finally extract failed */
    public static final Uri access$transform(BitmapTransformerImpl bitmapTransformerImpl, Uri uri, Transformation transformation, int i) {
        int i2;
        Bitmap bitmap;
        float f;
        float f2;
        RectF rectF;
        float f3;
        Objects.requireNonNull(bitmapTransformerImpl);
        if (transformation == null) {
            return uri;
        }
        Uri fromFile = Uri.fromFile(bitmapTransformerImpl.b.createTempFile());
        Intrinsics.checkNotNullExpressionValue(fromFile, "resultUri");
        InputStream openInputStream = bitmapTransformerImpl.a.openInputStream(uri);
        Intrinsics.checkNotNull(openInputStream);
        Intrinsics.checkNotNullExpressionValue(openInputStream, "contentResolver.openInputStream(input)!!");
        OutputStream openOutputStream = bitmapTransformerImpl.a.openOutputStream(fromFile);
        Intrinsics.checkNotNull(openOutputStream);
        Intrinsics.checkNotNullExpressionValue(openOutputStream, "contentResolver.openOutputStream(output)!!");
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = openInputStream.read(bArr);
                i2 = 0;
                if (read < 0) {
                    break;
                }
                openOutputStream.write(bArr, 0, read);
            }
            openOutputStream.flush();
            CloseablesKt.closeQuiet(openInputStream);
            CloseablesKt.closeQuiet(openOutputStream);
            String path = fromFile.getPath();
            Intrinsics.checkNotNull(path);
            Intrinsics.checkNotNullExpressionValue(path, "resultUri.path!!");
            Bitmap bitmap2 = null;
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(path);
                boolean z = true;
                int attributeInt = new ExifInterface(path).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt == 3) {
                    i2 = 180;
                } else if (attributeInt == 6) {
                    i2 = 90;
                } else if (attributeInt == 8) {
                    i2 = 270;
                }
                RectF rectF2 = new RectF();
                float f4 = (float) bitmapTransformerImpl.d;
                float f5 = f4 * 0.5f;
                float f6 = (float) bitmapTransformerImpl.c;
                float f7 = 0.5f * f6;
                float f8 = ((float) bitmapTransformerImpl.e) * 2.0f;
                float f9 = f4 - f8;
                float f10 = f6 - f8;
                if (f9 < f10) {
                    float f11 = (float) 1;
                    f = (f9 * f11) / f11;
                    f2 = f9;
                } else {
                    if (f9 > f10) {
                        float f12 = (float) 1;
                        f3 = (f10 * f12) / f12;
                    } else {
                        f3 = f9;
                    }
                    f2 = f3;
                    f = f10;
                }
                float f13 = (f9 * f) / f2;
                if (f13 > f10) {
                    f9 = (f2 * f10) / f;
                } else {
                    f10 = f13;
                }
                float f14 = (float) 2;
                float f15 = f9 / f14;
                rectF2.left = f5 - f15;
                float f16 = f10 / f14;
                rectF2.top = f7 - f16;
                rectF2.right = f5 + f15;
                rectF2.bottom = f7 + f16;
                try {
                    Matrix matrix = new Matrix();
                    if (i2 != 0) {
                        matrix.preRotate((float) i2);
                    }
                    if (transformation.getFocusOffset().length() == 0.0f) {
                        Intrinsics.checkNotNullExpressionValue(decodeFile, "bitmap");
                        rectF = new RectF(0.0f, 0.0f, (float) decodeFile.getWidth(), (float) decodeFile.getHeight());
                    } else {
                        Intrinsics.checkNotNullExpressionValue(decodeFile, "bitmap");
                        rectF = bitmapTransformerImpl.a(rectF2, transformation, decodeFile.getWidth(), decodeFile.getHeight());
                    }
                    bitmap2 = Bitmap.createBitmap(decodeFile, (int) rectF.left, (int) rectF.top, (int) rectF.width(), (int) rectF.height(), matrix, true);
                } finally {
                    if (Intrinsics.areEqual(decodeFile, bitmap2) ^ z) {
                        decodeFile.recycle();
                    }
                }
            } catch (IOException unused) {
                bitmap = null;
            }
            if (bitmap == null) {
                return null;
            }
            try {
                bitmap2 = bitmapTransformerImpl.a.openOutputStream(fromFile);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, bitmap2);
            } finally {
                if (bitmap2 != null) {
                    bitmap2.close();
                }
            }
        } catch (Throwable th) {
            CloseablesKt.closeQuiet(openInputStream);
            CloseablesKt.closeQuiet(openOutputStream);
            throw th;
        }
    }

    public final RectF a(RectF rectF, Transformation transformation, int i, int i2) {
        float f = (float) i;
        float scale = (f / ((float) this.d)) / transformation.getScale();
        PointF focusOffset = transformation.getFocusOffset();
        PointF pointF = new PointF(focusOffset.x * scale, focusOffset.y * scale);
        PointF pointF2 = new PointF(f / 2.0f, ((float) i2) / 2.0f);
        PointF pointF3 = new PointF(pointF2.x - pointF.x, pointF2.y - pointF.y);
        float f2 = (float) 2;
        float width = (rectF.width() * scale) / f2;
        float height = (rectF.height() * scale) / f2;
        float f3 = pointF3.x;
        float f4 = pointF3.y;
        return new RectF(f3 - width, f4 - height, f3 + width, f4 + height);
    }

    @Override // com.avito.android.photo_picker.BitmapTransformer
    @NotNull
    public Observable<Uri> transformBitmap(@NotNull Uri uri, @Nullable Transformation transformation, int i) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Observable<Uri> create = Observable.create(new a(this, uri, transformation, i));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { subs…)\n            }\n        }");
        return create;
    }
}
