package com.avito.android.photo_picker.edit;

import android.content.Context;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.PrivatePhotosStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_picker/edit/ExifProviderImpl;", "Lcom/avito/android/photo_picker/edit/ExifProvider;", "Landroid/net/Uri;", "fromUri", "Lio/reactivex/rxjava3/core/Maybe;", "", "", "Lcom/avito/android/photo_picker/ExifAttributesCollection;", "getExifFeatures", "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Maybe;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "c", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "exifExtraDataSerializer", "Lcom/avito/android/util/PrivatePhotosStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/PrivatePhotosStorage;Lcom/avito/android/photo_picker/ExifExtraDataSerializer;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ExifProviderImpl implements ExifProvider {
    public final Context a;
    public final PrivatePhotosStorage b;
    public final ExifExtraDataSerializer c;

    public ExifProviderImpl(@NotNull Context context, @NotNull PrivatePhotosStorage privatePhotosStorage, @NotNull ExifExtraDataSerializer exifExtraDataSerializer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        Intrinsics.checkNotNullParameter(exifExtraDataSerializer, "exifExtraDataSerializer");
        this.a = context;
        this.b = privatePhotosStorage;
        this.c = exifExtraDataSerializer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r2.equals(com.facebook.common.util.UriUtil.HTTP_SCHEME) != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006b, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0071, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0072, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0075, code lost:
        throw r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c  */
    @Override // com.avito.android.photo_picker.edit.ExifProvider
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Maybe<java.util.Map<java.lang.String, java.lang.String>> getExifFeatures(@org.jetbrains.annotations.NotNull android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "fromUri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.avito.android.util.PrivatePhotosStorage r0 = r6.b
            java.io.File r0 = r0.createTempFile()
            r1 = 0
            java.lang.String r2 = r7.getScheme()     // Catch:{ all -> 0x0076 }
            if (r2 != 0) goto L_0x0013
            goto L_0x0041
        L_0x0013:
            int r3 = r2.hashCode()     // Catch:{ all -> 0x0076 }
            r4 = 3213448(0x310888, float:4.503E-39)
            if (r3 == r4) goto L_0x002b
            r4 = 99617003(0x5f008eb, float:2.2572767E-35)
            if (r3 == r4) goto L_0x0022
            goto L_0x0041
        L_0x0022:
            java.lang.String r3 = "https"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x0041
            goto L_0x0033
        L_0x002b:
            java.lang.String r3 = "http"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x0041
        L_0x0033:
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0076 }
            r2.<init>(r7)     // Catch:{ all -> 0x0076 }
            java.io.InputStream r7 = r2.openStream()     // Catch:{ all -> 0x0076 }
            goto L_0x004b
        L_0x0041:
            android.content.Context r2 = r6.a     // Catch:{ all -> 0x0076 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0076 }
            java.io.InputStream r7 = r2.openInputStream(r7)     // Catch:{ all -> 0x0076 }
        L_0x004b:
            if (r7 == 0) goto L_0x007e
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x006f }
            r2.<init>(r0)     // Catch:{ all -> 0x006f }
            r3 = 0
            r4 = 2
            kotlin.io.ByteStreamsKt.copyTo$default(r7, r2, r3, r4, r1)     // Catch:{ all -> 0x0068 }
            kotlin.io.CloseableKt.closeFinally(r2, r1)
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface
            r2.<init>(r0)
            kotlin.io.CloseableKt.closeFinally(r7, r1)
            com.avito.android.util.PrivatePhotosStorage r7 = r6.b
            r7.deleteFile(r0)
            goto L_0x0084
        L_0x0068:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x006a }
        L_0x006a:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r4
        L_0x006f:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r2)
            throw r3
        L_0x0076:
            r7 = move-exception
            java.lang.String r2 = "ExifProvider"
            java.lang.String r3 = "getExifForUri"
            com.avito.android.util.Logs.debug(r2, r3, r7)     // Catch:{ all -> 0x00c1 }
        L_0x007e:
            com.avito.android.util.PrivatePhotosStorage r7 = r6.b
            r7.deleteFile(r0)
            r2 = r1
        L_0x0084:
            if (r2 == 0) goto L_0x008a
            java.util.Map r1 = com.avito.android.photo_picker.ExifUtilsKt.getAttributes(r2)
        L_0x008a:
            if (r1 == 0) goto L_0x00b7
            com.avito.android.photo_picker.ExifExtraDataSerializer r7 = r6.c
            com.avito.android.photo_picker.ExifExtraData r0 = new com.avito.android.photo_picker.ExifExtraData
            java.lang.String r2 = "ImageWidth"
            java.lang.Object r3 = r1.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "ImageLength"
            java.lang.Object r5 = r1.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            r0.<init>(r3, r5)
            java.lang.String r7 = r7.serialize(r0)
            com.avito.android.photo_picker.ExifUtilsKt.setExtraData(r1, r7)
            r1.remove(r2)
            r1.remove(r4)
            io.reactivex.rxjava3.core.Maybe r7 = io.reactivex.rxjava3.core.Maybe.just(r1)
            if (r7 == 0) goto L_0x00b7
            goto L_0x00c0
        L_0x00b7:
            io.reactivex.rxjava3.core.Maybe r7 = io.reactivex.rxjava3.core.Maybe.empty()
            java.lang.String r0 = "Maybe.empty()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
        L_0x00c0:
            return r7
        L_0x00c1:
            r7 = move-exception
            com.avito.android.util.PrivatePhotosStorage r1 = r6.b
            r1.deleteFile(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.photo_picker.edit.ExifProviderImpl.getExifFeatures(android.net.Uri):io.reactivex.rxjava3.core.Maybe");
    }
}
