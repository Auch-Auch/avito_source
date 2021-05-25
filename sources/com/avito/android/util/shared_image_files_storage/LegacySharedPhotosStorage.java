package com.avito.android.util.shared_image_files_storage;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019JO\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/util/shared_image_files_storage/LegacySharedPhotosStorage;", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "Landroid/graphics/Bitmap;", "bitmap", "", "name", "relativePath", "", "Lcom/avito/android/photo_picker/ExifAttributesCollection;", "exifAttributes", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage$BitmapSaveProperties;", "bitmapSaveProperties", "Landroid/net/Uri;", "addImage", "(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage$BitmapSaveProperties;)Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "checkPhotoIsLocal", "(Landroid/net/Uri;)Z", "checkPhotoIsFromCamera", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LegacySharedPhotosStorage implements SharedPhotosStorage {
    public final Context a;

    @Inject
    public LegacySharedPhotosStorage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ac, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ad, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b0, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b9, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ba, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bd, code lost:
        throw r8;
     */
    @Override // com.avito.android.util.shared_image_files_storage.SharedPhotosStorage
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri addImage(@org.jetbrains.annotations.NotNull android.graphics.Bitmap r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.Nullable java.lang.String r9, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> r10, @org.jetbrains.annotations.NotNull com.avito.android.util.shared_image_files_storage.SharedPhotosStorage.BitmapSaveProperties r11) {
        /*
            r6 = this;
            java.lang.String r9 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r9)
            java.lang.String r9 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r9)
            java.lang.String r9 = "bitmapSaveProperties"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r9)
            android.content.Context r9 = r6.a
            android.content.ContentResolver r9 = r9.getContentResolver()
            java.lang.String r0 = "external"
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.getContentUri(r0)
            r1 = 0
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ IOException -> 0x004e }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x004e }
            java.lang.String r3 = "Environment.getExternalS…ageDirectory().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ IOException -> 0x004e }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x004e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004e }
            r4.<init>()     // Catch:{ IOException -> 0x004e }
            r4.append(r2)     // Catch:{ IOException -> 0x004e }
            java.lang.String r2 = "/Avito"
            r4.append(r2)     // Catch:{ IOException -> 0x004e }
            java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x004e }
            r3.<init>(r2)     // Catch:{ IOException -> 0x004e }
            boolean r2 = r3.exists()     // Catch:{ IOException -> 0x004e }
            if (r2 != 0) goto L_0x0048
            r3.mkdirs()     // Catch:{ IOException -> 0x004e }
        L_0x0048:
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x004e }
            r2.<init>(r3, r8)     // Catch:{ IOException -> 0x004e }
            goto L_0x004f
        L_0x004e:
            r2 = r1
        L_0x004f:
            if (r2 == 0) goto L_0x00be
            android.net.Uri r3 = android.net.Uri.fromFile(r2)
            java.lang.String r4 = "w"
            android.os.ParcelFileDescriptor r3 = r9.openFileDescriptor(r3, r4)
            if (r3 == 0) goto L_0x00b1
            java.io.FileDescriptor r4 = r3.getFileDescriptor()     // Catch:{ all -> 0x00b7 }
            if (r4 == 0) goto L_0x00b1
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x00b7 }
            r5.<init>(r4)     // Catch:{ all -> 0x00b7 }
            android.graphics.Bitmap$CompressFormat r4 = r11.getFormat()     // Catch:{ all -> 0x00aa }
            int r11 = r11.getQuality()     // Catch:{ all -> 0x00aa }
            r7.compress(r4, r11, r5)     // Catch:{ all -> 0x00aa }
            kotlin.io.CloseableKt.closeFinally(r5, r1)
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            android.content.ContentValues r7 = new android.content.ContentValues
            r7.<init>()
            java.lang.String r11 = "_display_name"
            r7.put(r11, r8)
            java.lang.String r8 = r2.getAbsolutePath()
            java.lang.String r11 = "_data"
            r7.put(r11, r8)
            java.lang.String r8 = "mime_type"
            java.lang.String r11 = "image/jpeg"
            r7.put(r8, r11)
            android.net.Uri r7 = r9.insert(r0, r7)
            if (r10 == 0) goto L_0x00a1
            androidx.exifinterface.media.ExifInterface r8 = new androidx.exifinterface.media.ExifInterface
            r8.<init>(r2)
            com.avito.android.photo_picker.ExifUtilsKt.setAttributesAndSave(r8, r10)
        L_0x00a1:
            if (r7 == 0) goto L_0x00a4
            return r7
        L_0x00a4:
            com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException r7 = new com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException
            r7.<init>()
            throw r7
        L_0x00aa:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r8 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r7)
            throw r8
        L_0x00b1:
            com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException r7 = new com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException
            r7.<init>()
            throw r7
        L_0x00b7:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            r8 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r7)
            throw r8
        L_0x00be:
            com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException r7 = new com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.shared_image_files_storage.LegacySharedPhotosStorage.addImage(android.graphics.Bitmap, java.lang.String, java.lang.String, java.util.Map, com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$BitmapSaveProperties):android.net.Uri");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        throw r1;
     */
    @Override // com.avito.android.util.shared_image_files_storage.SharedPhotosStorage
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean checkPhotoIsFromCamera(@org.jetbrains.annotations.NotNull android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.content.Context r0 = r7.a
            android.content.ContentResolver r1 = r0.getContentResolver()
            java.lang.String r0 = "_display_name"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r8
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            r1 = 0
            if (r8 == 0) goto L_0x0045
            int r0 = r8.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x003e }
            boolean r2 = r8.moveToNext()     // Catch:{ all -> 0x003e }
            r3 = 0
            if (r2 == 0) goto L_0x003a
            java.lang.String r0 = r8.getString(r0)     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "it.getString(columnIndexDisplayName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "-shot.jpg"
            r4 = 2
            boolean r0 = t6.y.m.endsWith$default(r0, r2, r1, r4, r3)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003a
            r1 = 1
        L_0x003a:
            kotlin.io.CloseableKt.closeFinally(r8, r3)
            return r1
        L_0x003e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r0)
            throw r1
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.shared_image_files_storage.LegacySharedPhotosStorage.checkPhotoIsFromCamera(android.net.Uri):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        throw r1;
     */
    @Override // com.avito.android.util.shared_image_files_storage.SharedPhotosStorage
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean checkPhotoIsLocal(@org.jetbrains.annotations.NotNull android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.content.Context r0 = r7.a
            android.content.ContentResolver r1 = r0.getContentResolver()
            java.lang.String r0 = "_id"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r8
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 == 0) goto L_0x002b
            r0 = 0
            boolean r1 = r8.moveToNext()     // Catch:{ all -> 0x0024 }
            kotlin.io.CloseableKt.closeFinally(r8, r0)
            return r1
        L_0x0024:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r0)
            throw r1
        L_0x002b:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.shared_image_files_storage.LegacySharedPhotosStorage.checkPhotoIsLocal(android.net.Uri):boolean");
    }
}
