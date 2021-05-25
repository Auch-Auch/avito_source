package com.avito.android.photo;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/photo/ImageConvertOptions;", "", "", "component1", "()I", "component2", "component3", "component4", "maxHeight", "maxWidth", "jpegQuality", "maxFileSizeBytes", "copy", "(IIII)Lcom/avito/android/photo/ImageConvertOptions;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getMaxWidth", "d", "getMaxFileSizeBytes", AuthSource.SEND_ABUSE, "getMaxHeight", "c", "getJpegQuality", "<init>", "(IIII)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ImageConvertOptions {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public ImageConvertOptions(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static /* synthetic */ ImageConvertOptions copy$default(ImageConvertOptions imageConvertOptions, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = imageConvertOptions.a;
        }
        if ((i5 & 2) != 0) {
            i2 = imageConvertOptions.b;
        }
        if ((i5 & 4) != 0) {
            i3 = imageConvertOptions.c;
        }
        if ((i5 & 8) != 0) {
            i4 = imageConvertOptions.d;
        }
        return imageConvertOptions.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    @NotNull
    public final ImageConvertOptions copy(int i, int i2, int i3, int i4) {
        return new ImageConvertOptions(i, i2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageConvertOptions)) {
            return false;
        }
        ImageConvertOptions imageConvertOptions = (ImageConvertOptions) obj;
        return this.a == imageConvertOptions.a && this.b == imageConvertOptions.b && this.c == imageConvertOptions.c && this.d == imageConvertOptions.d;
    }

    public final int getJpegQuality() {
        return this.c;
    }

    public final int getMaxFileSizeBytes() {
        return this.d;
    }

    public final int getMaxHeight() {
        return this.a;
    }

    public final int getMaxWidth() {
        return this.b;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ImageConvertOptions(maxHeight=");
        L.append(this.a);
        L.append(", maxWidth=");
        L.append(this.b);
        L.append(", jpegQuality=");
        L.append(this.c);
        L.append(", maxFileSizeBytes=");
        return a.j(L, this.d, ")");
    }
}
