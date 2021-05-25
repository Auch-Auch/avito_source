package com.avito.android.util.shared_image_files_storage;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@RequiresApi(29)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019JO\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/util/shared_image_files_storage/MediaStoreSharedPhotosStorage;", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "Landroid/graphics/Bitmap;", "bitmap", "", "name", "relativePath", "", "Lcom/avito/android/photo_picker/ExifAttributesCollection;", "exifAttributes", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage$BitmapSaveProperties;", "bitmapSaveProperties", "Landroid/net/Uri;", "addImage", "(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage$BitmapSaveProperties;)Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "checkPhotoIsLocal", "(Landroid/net/Uri;)Z", "checkPhotoIsFromCamera", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class MediaStoreSharedPhotosStorage implements SharedPhotosStorage {
    public final Context a;

    @Inject
    public MediaStoreSharedPhotosStorage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c2, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c3, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c6, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d5, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d6, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d9, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e2, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e3, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e6, code lost:
        throw r7;
     */
    @Override // com.avito.android.util.shared_image_files_storage.SharedPhotosStorage
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri addImage(@org.jetbrains.annotations.NotNull android.graphics.Bitmap r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.Nullable java.lang.String r8, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> r9, @org.jetbrains.annotations.NotNull com.avito.android.util.shared_image_files_storage.SharedPhotosStorage.BitmapSaveProperties r10) {
        /*
            r5 = this;
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "bitmapSaveProperties"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.content.Context r0 = r5.a
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.lang.String r1 = "external_primary"
            android.net.Uri r1 = android.provider.MediaStore.Images.Media.getContentUri(r1)
            android.content.ContentValues r2 = new android.content.ContentValues
            r2.<init>()
            java.lang.String r3 = "_display_name"
            r2.put(r3, r7)
            if (r8 == 0) goto L_0x0042
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r3 = android.os.Environment.DIRECTORY_PICTURES
            r7.append(r3)
            java.lang.String r3 = java.io.File.separator
            r7.append(r3)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "relative_path"
            r2.put(r8, r7)
        L_0x0042:
            java.lang.String r7 = "mime_type"
            java.lang.String r8 = "image/jpeg"
            r2.put(r7, r8)
            r7 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "is_pending"
            r2.put(r8, r7)
            android.net.Uri r7 = r0.insert(r1, r2)
            if (r7 == 0) goto L_0x00e7
            java.lang.String r1 = "resolver.insert(imagesCo…ToSharedVolumeException()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            java.lang.String r1 = "w"
            android.os.ParcelFileDescriptor r1 = r0.openFileDescriptor(r7, r1)
            if (r1 == 0) goto L_0x00da
            java.io.FileDescriptor r3 = r1.getFileDescriptor()     // Catch:{ all -> 0x00e0 }
            if (r3 == 0) goto L_0x00da
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x00e0 }
            r4.<init>(r3)     // Catch:{ all -> 0x00e0 }
            android.graphics.Bitmap$CompressFormat r3 = r10.getFormat()     // Catch:{ all -> 0x00d3 }
            int r10 = r10.getQuality()     // Catch:{ all -> 0x00d3 }
            r6.compress(r3, r10, r4)     // Catch:{ all -> 0x00d3 }
            r6 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r6)
            kotlin.io.CloseableKt.closeFinally(r1, r6)
            r2.clear()
            r10 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r2.put(r8, r10)
            r0.update(r7, r2, r6, r6)
            long r7 = android.content.ContentUris.parseId(r7)
            r1 = -1
            int r10 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r10 == 0) goto L_0x00cd
            android.net.Uri r10 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            android.net.Uri r7 = android.content.ContentUris.withAppendedId(r10, r7)
            java.lang.String r8 = "rw"
            android.os.ParcelFileDescriptor r8 = r0.openFileDescriptor(r7, r8)
            if (r8 == 0) goto L_0x00c7
            java.lang.String r10 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)     // Catch:{ all -> 0x00c0 }
            java.io.FileDescriptor r10 = r8.getFileDescriptor()     // Catch:{ all -> 0x00c0 }
            if (r9 == 0) goto L_0x00bc
            androidx.exifinterface.media.ExifInterface r0 = new androidx.exifinterface.media.ExifInterface     // Catch:{ all -> 0x00c0 }
            r0.<init>(r10)     // Catch:{ all -> 0x00c0 }
            com.avito.android.photo_picker.ExifUtilsKt.setAttributesAndSave(r0, r9)     // Catch:{ all -> 0x00c0 }
        L_0x00bc:
            kotlin.io.CloseableKt.closeFinally(r8, r6)
            goto L_0x00c7
        L_0x00c0:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r6)
            throw r7
        L_0x00c7:
            java.lang.String r6 = "ContentUris.withAppended…}\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            return r7
        L_0x00cd:
            com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException r6 = new com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException
            r6.<init>()
            throw r6
        L_0x00d3:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00d5 }
        L_0x00d5:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r6)
            throw r7
        L_0x00da:
            com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException r6 = new com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException
            r6.<init>()
            throw r6
        L_0x00e0:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00e2 }
        L_0x00e2:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r6)
            throw r7
        L_0x00e7:
            com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException r6 = new com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$CantSaveToSharedVolumeException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.shared_image_files_storage.MediaStoreSharedPhotosStorage.addImage(android.graphics.Bitmap, java.lang.String, java.lang.String, java.util.Map, com.avito.android.util.shared_image_files_storage.SharedPhotosStorage$BitmapSaveProperties):android.net.Uri");
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
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.shared_image_files_storage.MediaStoreSharedPhotosStorage.checkPhotoIsFromCamera(android.net.Uri):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.shared_image_files_storage.MediaStoreSharedPhotosStorage.checkPhotoIsLocal(android.net.Uri):boolean");
    }
}
