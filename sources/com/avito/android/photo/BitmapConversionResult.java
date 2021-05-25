package com.avito.android.photo;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ6\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R+\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/avito/android/photo/BitmapConversionResult;", "", "Ljava/io/File;", "component1", "()Ljava/io/File;", "", "", "Lcom/avito/android/photo_picker/ExifAttributesCollection;", "component2", "()Ljava/util/Map;", "file", "originalExifData", "copy", "(Ljava/io/File;Ljava/util/Map;)Lcom/avito/android/photo/BitmapConversionResult;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/io/File;", "getFile", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getOriginalExifData", "<init>", "(Ljava/io/File;Ljava/util/Map;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class BitmapConversionResult {
    @NotNull
    public final File a;
    @NotNull
    public final Map<String, String> b;

    public BitmapConversionResult(@NotNull File file, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(map, "originalExifData");
        this.a = file;
        this.b = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.photo.BitmapConversionResult */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BitmapConversionResult copy$default(BitmapConversionResult bitmapConversionResult, File file, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            file = bitmapConversionResult.a;
        }
        if ((i & 2) != 0) {
            map = bitmapConversionResult.b;
        }
        return bitmapConversionResult.copy(file, map);
    }

    @NotNull
    public final File component1() {
        return this.a;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.b;
    }

    @NotNull
    public final BitmapConversionResult copy(@NotNull File file, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(map, "originalExifData");
        return new BitmapConversionResult(file, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapConversionResult)) {
            return false;
        }
        BitmapConversionResult bitmapConversionResult = (BitmapConversionResult) obj;
        return Intrinsics.areEqual(this.a, bitmapConversionResult.a) && Intrinsics.areEqual(this.b, bitmapConversionResult.b);
    }

    @NotNull
    public final File getFile() {
        return this.a;
    }

    @NotNull
    public final Map<String, String> getOriginalExifData() {
        return this.b;
    }

    public int hashCode() {
        File file = this.a;
        int i = 0;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        Map<String, String> map = this.b;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("BitmapConversionResult(file=");
        L.append(this.a);
        L.append(", originalExifData=");
        return a.x(L, this.b, ")");
    }
}
