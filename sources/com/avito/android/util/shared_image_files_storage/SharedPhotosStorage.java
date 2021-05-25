package com.avito.android.util.shared_image_files_storage;

import a2.b.a.a.a;
import android.graphics.Bitmap;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u0000 \u00142\u00020\u0001:\u0003\u0015\u0016\u0014JW\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "", "Landroid/graphics/Bitmap;", "bitmap", "", "name", "relativePath", "", "Lcom/avito/android/photo_picker/ExifAttributesCollection;", "exifAttributes", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage$BitmapSaveProperties;", "bitmapSaveProperties", "Landroid/net/Uri;", "addImage", "(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage$BitmapSaveProperties;)Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "checkPhotoIsLocal", "(Landroid/net/Uri;)Z", "checkPhotoIsFromCamera", "Companion", "BitmapSaveProperties", "CantSaveToSharedVolumeException", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface SharedPhotosStorage {
    @NotNull
    public static final Companion Companion = Companion.a;
    @NotNull
    public static final String DEFAULT_PHOTOS_DIRECTORY = "Avito";
    @NotNull
    public static final String PHOTO_PREFIX = "avito-";
    @NotNull
    public static final String PHOTO_SUFFIX = "-shot.jpg";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage$BitmapSaveProperties;", "", "Landroid/graphics/Bitmap$CompressFormat;", "component1", "()Landroid/graphics/Bitmap$CompressFormat;", "", "component2", "()I", "format", "quality", "copy", "(Landroid/graphics/Bitmap$CompressFormat;I)Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage$BitmapSaveProperties;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/graphics/Bitmap$CompressFormat;", "getFormat", AuthSource.BOOKING_ORDER, "I", "getQuality", "<init>", "(Landroid/graphics/Bitmap$CompressFormat;I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class BitmapSaveProperties {
        @NotNull
        public final Bitmap.CompressFormat a;
        public final int b;

        public BitmapSaveProperties(@NotNull Bitmap.CompressFormat compressFormat, int i) {
            Intrinsics.checkNotNullParameter(compressFormat, "format");
            this.a = compressFormat;
            this.b = i;
        }

        public static /* synthetic */ BitmapSaveProperties copy$default(BitmapSaveProperties bitmapSaveProperties, Bitmap.CompressFormat compressFormat, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                compressFormat = bitmapSaveProperties.a;
            }
            if ((i2 & 2) != 0) {
                i = bitmapSaveProperties.b;
            }
            return bitmapSaveProperties.copy(compressFormat, i);
        }

        @NotNull
        public final Bitmap.CompressFormat component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final BitmapSaveProperties copy(@NotNull Bitmap.CompressFormat compressFormat, int i) {
            Intrinsics.checkNotNullParameter(compressFormat, "format");
            return new BitmapSaveProperties(compressFormat, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BitmapSaveProperties)) {
                return false;
            }
            BitmapSaveProperties bitmapSaveProperties = (BitmapSaveProperties) obj;
            return Intrinsics.areEqual(this.a, bitmapSaveProperties.a) && this.b == bitmapSaveProperties.b;
        }

        @NotNull
        public final Bitmap.CompressFormat getFormat() {
            return this.a;
        }

        public final int getQuality() {
            return this.b;
        }

        public int hashCode() {
            Bitmap.CompressFormat compressFormat = this.a;
            return ((compressFormat != null ? compressFormat.hashCode() : 0) * 31) + this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("BitmapSaveProperties(format=");
            L.append(this.a);
            L.append(", quality=");
            return a.j(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage$CantSaveToSharedVolumeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class CantSaveToSharedVolumeException extends RuntimeException {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage$Companion;", "", "", "createPhotoFileName", "()Ljava/lang/String;", "PHOTO_PREFIX", "Ljava/lang/String;", "PHOTO_SUFFIX", "DEFAULT_PHOTOS_DIRECTORY", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String DEFAULT_PHOTOS_DIRECTORY = "Avito";
        @NotNull
        public static final String PHOTO_PREFIX = "avito-";
        @NotNull
        public static final String PHOTO_SUFFIX = "-shot.jpg";
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final String createPhotoFileName() {
            StringBuilder L = a.L("avito-");
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
            Date time = instance.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "Calendar.getInstance().time");
            L.append(time.getTime());
            L.append("-shot.jpg");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.util.shared_image_files_storage.SharedPhotosStorage */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Uri addImage$default(SharedPhotosStorage sharedPhotosStorage, Bitmap bitmap, String str, String str2, Map map, BitmapSaveProperties bitmapSaveProperties, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = SharedPhotosStorage.Companion.createPhotoFileName();
                }
                if ((i & 4) != 0) {
                    StringBuilder L = a.L("Avito");
                    L.append(File.separator);
                    str2 = L.toString();
                }
                if ((i & 8) != 0) {
                    map = null;
                }
                if ((i & 16) != 0) {
                    bitmapSaveProperties = new BitmapSaveProperties(Bitmap.CompressFormat.JPEG, 90);
                }
                return sharedPhotosStorage.addImage(bitmap, str, str2, map, bitmapSaveProperties);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addImage");
        }
    }

    @NotNull
    Uri addImage(@NotNull Bitmap bitmap, @NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, @NotNull BitmapSaveProperties bitmapSaveProperties);

    boolean checkPhotoIsFromCamera(@NotNull Uri uri);

    boolean checkPhotoIsLocal(@NotNull Uri uri);
}
