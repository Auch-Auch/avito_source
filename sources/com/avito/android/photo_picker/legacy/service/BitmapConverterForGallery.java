package com.avito.android.photo_picker.legacy.service;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.photo.BadPhotoSourceException;
import com.avito.android.photo.ImageConvertOptions;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ContentResolverUtilsKt;
import com.avito.android.util.EntityTooLargeException;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.ok.android.sdk.OkListener;
import t6.q.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\"\u000f#B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b \u0010!J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001d\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001c¨\u0006$"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/BitmapConverterForGallery;", "Lcom/avito/android/photo_picker/legacy/api/UploadConverter;", "Landroid/net/Uri;", "contentUri", "Lio/reactivex/Observable;", "Ljava/io/File;", "convertUriToFile", "(Landroid/net/Uri;)Lio/reactivex/Observable;", ShareConstants.MEDIA_URI, "convert", "(Landroid/net/Uri;)Ljava/io/File;", "", MessageMetaInfo.COLUMN_PATH, AuthSource.BOOKING_ORDER, "(Ljava/lang/String;)Ljava/io/File;", AuthSource.SEND_ABUSE, "Ljava/io/File;", "cache", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo/ImageConvertOptions;", "c", "Lcom/avito/android/photo/ImageConvertOptions;", "convertOptions", "Landroid/content/ContentResolver;", "kotlin.jvm.PlatformType", "Landroid/content/ContentResolver;", "contentResolver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/photo/ImageConvertOptions;Lcom/avito/android/analytics/Analytics;)V", "BitmapConversionException", "Params", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class BitmapConverterForGallery implements UploadConverter {
    public final File a;
    public final ContentResolver b;
    public final ImageConvertOptions c;
    public final Analytics d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/BitmapConverterForGallery$BitmapConversionException;", "Ljava/io/IOException;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class BitmapConversionException extends IOException {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/BitmapConverterForGallery$Params;", "", "Landroid/graphics/Matrix;", "toMatrix", "()Landroid/graphics/Matrix;", "", AuthSource.SEND_ABUSE, "I", "getDegree", "()I", "degree", "", AuthSource.BOOKING_ORDER, "F", "getScale", "()F", "scale", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "Lcom/avito/android/photo/ImageConvertOptions;", "options", "<init>", "(IIILcom/avito/android/photo/ImageConvertOptions;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
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

    public static final class b<T> implements ObservableOnSubscribe<File> {
        public final /* synthetic */ BitmapConverterForGallery a;
        public final /* synthetic */ Uri b;

        public b(BitmapConverterForGallery bitmapConverterForGallery, Uri uri) {
            this.a = bitmapConverterForGallery;
            this.b = uri;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<File> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "subscriber");
            try {
                File convert = this.a.convert(this.b);
                if (convert == null) {
                    observableEmitter.onError(new IOException());
                    return;
                }
                observableEmitter.onNext(convert);
                observableEmitter.onComplete();
            } catch (Exception e) {
                observableEmitter.onError(e);
            }
        }
    }

    public BitmapConverterForGallery(@NotNull Context context, @NotNull ImageConvertOptions imageConvertOptions, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageConvertOptions, "convertOptions");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.c = imageConvertOptions;
        this.d = analytics;
        File cacheDir = context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
        this.a = cacheDir;
        this.b = context.getContentResolver();
    }

    public final File a(String str) {
        int i;
        File file;
        Bitmap bitmap;
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
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
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
                if (decodeFile == decodeFile) {
                    try {
                        file = new File(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    try {
                        file = e.createTempFile("image", ".jpg", this.a);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        decodeFile.compress(Bitmap.CompressFormat.JPEG, this.c.getJpegQuality(), fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        this.d.track(new NonFatalError("Cannot convert photo from file", new a(e), null, 4, null));
                        decodeFile.recycle();
                        decodeFile.recycle();
                        return null;
                    }
                }
                decodeFile.recycle();
                decodeFile.recycle();
                return file;
            } finally {
                decodeFile.recycle();
            }
        } else {
            throw new BitmapConversionException();
        }
    }

    public final File b(String str) throws IOException, EntityTooLargeException {
        long freeMemory = Runtime.getRuntime().freeMemory();
        try {
            return a(str);
        } catch (OutOfMemoryError e) {
            long freeMemory2 = Runtime.getRuntime().freeMemory();
            StringBuilder O = a2.b.a.a.a.O("Bitmap conversion OutOfMemoryError Memory before ", freeMemory, "  Memory after OOM: ");
            O.append(freeMemory2);
            this.d.track(new NonFatalError("error", new RuntimeException(O.toString(), e), null, 4, null));
            File file = new File(str);
            if (file.length() < ((long) this.c.getMaxFileSizeBytes())) {
                return file;
            }
            throw new EntityTooLargeException();
        }
    }

    @Nullable
    public final File convert(@NotNull Uri uri) throws IOException {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != 3143036) {
                if (hashCode == 951530617 && scheme.equals("content")) {
                    try {
                        File createTempFile = e.createTempFile("image", ".jpg", this.a);
                        ContentResolver contentResolver = this.b;
                        Intrinsics.checkNotNullExpressionValue(contentResolver, "contentResolver");
                        ContentResolverUtilsKt.writeUriContentToFile(contentResolver, uri, createTempFile);
                        String path = createTempFile.getPath();
                        Intrinsics.checkNotNullExpressionValue(path, "file.path");
                        return b(path);
                    } catch (Exception e) {
                        this.d.track(new NonFatalError(a2.b.a.a.a.W2("Cannot convert photo from: ", uri), new a(e), null, 4, null));
                        return null;
                    }
                }
            } else if (scheme.equals("file")) {
                return new File(uri.getPath());
            }
        }
        throw new BadPhotoSourceException(uri.getScheme() + " in " + uri);
    }

    @Override // com.avito.android.photo_picker.legacy.api.UploadConverter
    @NotNull
    public Observable<File> convertUriToFile(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Observable<File> create = Observable.create(new b(this, uri));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { subs…)\n            }\n        }");
        return create;
    }
}
