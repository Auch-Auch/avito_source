package com.avito.android.photo;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.photo_picker.ExifUtilsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ContentResolverUtilsKt;
import com.avito.android.util.EntityTooLargeException;
import com.avito.android.util.PrivatePhotosStorage;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003 \t!B/\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001a¨\u0006\""}, d2 = {"Lcom/avito/android/photo/BitmapConverter;", "", "Lcom/avito/android/photo/BitmapConversionResult;", "convert", "()Lcom/avito/android/photo/BitmapConversionResult;", "", MessageMetaInfo.COLUMN_PATH, AuthSource.BOOKING_ORDER, "(Ljava/lang/String;)Lcom/avito/android/photo/BitmapConversionResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/PrivatePhotosStorage;", "e", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "Landroid/content/ContentResolver;", "Landroid/content/ContentResolver;", "contentResolver", "Lcom/avito/android/photo/ImageConvertOptions;", "c", "Lcom/avito/android/photo/ImageConvertOptions;", "convertOptions", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroid/net/Uri;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/net/Uri;Lcom/avito/android/photo/ImageConvertOptions;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/PrivatePhotosStorage;)V", "BitmapConversionException", "Params", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class BitmapConverter {
    public final ContentResolver a;
    public final Uri b;
    public final ImageConvertOptions c;
    public final Analytics d;
    public final PrivatePhotosStorage e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo/BitmapConverter$BitmapConversionException;", "Ljava/io/IOException;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class BitmapConversionException extends IOException {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/photo/BitmapConverter$Params;", "", "Landroid/graphics/Matrix;", "toMatrix", "()Landroid/graphics/Matrix;", "", AuthSource.BOOKING_ORDER, "F", "getScale", "()F", "scale", "", AuthSource.SEND_ABUSE, "I", "getDegree", "()I", "degree", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "Lcom/avito/android/photo/ImageConvertOptions;", "options", "<init>", "(IIILcom/avito/android/photo/ImageConvertOptions;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        public final int a;
        public final float b;

        public Params(int i, int i2, int i3, @NotNull ImageConvertOptions imageConvertOptions) {
            Intrinsics.checkNotNullParameter(imageConvertOptions, "options");
            this.a = i;
            boolean z = i == 0 || i == 180;
            int i4 = z ? i2 : i3;
            i2 = z ? i3 : i2;
            if (i4 > imageConvertOptions.getMaxHeight() || i2 > imageConvertOptions.getMaxWidth()) {
                this.b = Math.min(((float) imageConvertOptions.getMaxHeight()) / ((float) i4), ((float) imageConvertOptions.getMaxWidth()) / ((float) i2));
            } else {
                this.b = 0.0f;
            }
        }

        public final int getDegree() {
            return this.a;
        }

        public final float getScale() {
            return this.b;
        }

        @Nullable
        public final Matrix toMatrix() {
            if (this.a <= 0 && this.b <= 0.0f) {
                return null;
            }
            Matrix matrix = new Matrix();
            int i = this.a;
            if (i > 0) {
                matrix.postRotate((float) i);
            }
            float f = this.b;
            if (f > 0.0f) {
                matrix.postScale(f, f);
            }
            return matrix;
        }
    }

    public static final class a extends Exception {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull Exception exc) {
            super(exc);
            Intrinsics.checkNotNullParameter(exc, OkListener.KEY_EXCEPTION);
        }
    }

    public BitmapConverter(@NotNull Context context, @NotNull Uri uri, @NotNull ImageConvertOptions imageConvertOptions, @NotNull Analytics analytics, @NotNull PrivatePhotosStorage privatePhotosStorage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(imageConvertOptions, "convertOptions");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        this.b = uri;
        this.c = imageConvertOptions;
        this.d = analytics;
        this.e = privatePhotosStorage;
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        this.a = contentResolver;
    }

    /* JADX INFO: finally extract failed */
    public final BitmapConversionResult a(String str) {
        int i;
        Bitmap bitmap;
        ExifInterface exifInterface = new ExifInterface(str);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = 0;
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        int max = Math.max(this.c.getMaxHeight(), this.c.getMaxWidth());
        if (options.outHeight > this.c.getMaxHeight() || options.outWidth > this.c.getMaxWidth()) {
            float f = (float) max;
            i = Math.min(Math.round(((float) options.outHeight) / f), Math.round(((float) options.outWidth) / f));
        } else {
            i = 1;
        }
        options.inSampleSize = i;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            int attributeInt = new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                i2 = 180;
            } else if (attributeInt == 6) {
                i2 = 90;
            } else if (attributeInt == 8) {
                i2 = 270;
            }
            try {
                Matrix matrix = new Params(i2, decodeFile.getHeight(), decodeFile.getWidth(), this.c).toMatrix();
                if (matrix != null) {
                    bitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                    Intrinsics.checkNotNullExpressionValue(bitmap, "Bitmap.createBitmap(bitm…map.height, matrix, true)");
                } else {
                    bitmap = decodeFile;
                }
                try {
                    File createTempFile = this.e.createTempFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, this.c.getJpegQuality(), fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    bitmap.recycle();
                    decodeFile.recycle();
                    return new BitmapConversionResult(createTempFile, ExifUtilsKt.getAttributes(exifInterface));
                } catch (IOException e2) {
                    this.d.track(new NonFatalError("Cannot convert photo from file", new a(e2), null, 4, null));
                    bitmap.recycle();
                    decodeFile.recycle();
                    return null;
                } catch (Throwable th) {
                    bitmap.recycle();
                    throw th;
                }
            } catch (Throwable th2) {
                decodeFile.recycle();
                throw th2;
            }
        } else {
            throw new BitmapConversionException();
        }
    }

    public final BitmapConversionResult b(String str) throws IOException, EntityTooLargeException {
        long freeMemory = Runtime.getRuntime().freeMemory();
        try {
            return a(str);
        } catch (OutOfMemoryError e2) {
            long freeMemory2 = Runtime.getRuntime().freeMemory();
            StringBuilder O = a2.b.a.a.a.O("Bitmap conversion OutOfMemoryError Memory before ", freeMemory, "  Memory after OOM: ");
            O.append(freeMemory2);
            this.d.track(new NonFatalError("error", new RuntimeException(O.toString(), e2), null, 4, null));
            if (Build.VERSION.SDK_INT >= 29) {
                return null;
            }
            File file = new File(str);
            if (file.length() < ((long) this.c.getMaxFileSizeBytes())) {
                return new BitmapConversionResult(file, ExifUtilsKt.getAttributes(new ExifInterface(file)));
            }
            throw new EntityTooLargeException();
        }
    }

    @Nullable
    public final BitmapConversionResult convert() throws IOException {
        String scheme = this.b.getScheme();
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != 3143036) {
                if (hashCode == 951530617 && scheme.equals("content")) {
                    Uri uri = this.b;
                    try {
                        File createTempFile = this.e.createTempFile();
                        ContentResolverUtilsKt.writeUriContentToFile(this.a, uri, createTempFile);
                        String path = createTempFile.getPath();
                        Intrinsics.checkNotNullExpressionValue(path, "file.path");
                        return b(path);
                    } catch (Exception e2) {
                        this.d.track(new NonFatalError(a2.b.a.a.a.W2("Cannot convert photo from: ", uri), new a(e2), null, 4, null));
                        return null;
                    }
                }
            } else if (scheme.equals("file")) {
                String path2 = this.b.getPath();
                Intrinsics.checkNotNull(path2);
                Intrinsics.checkNotNullExpressionValue(path2, "uri.path!!");
                return b(path2);
            }
        }
        throw new BadPhotoSourceException(this.b.getScheme() + " in " + this.b);
    }
}
