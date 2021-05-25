package com.avito.android.photo_picker;

import a2.b.a.a.a;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/photo_picker/ExifExtraData;", "", "", "component1", "()Ljava/lang/String;", "component2", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "length", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/photo_picker/ExifExtraData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getWidth", "getLength", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ExifExtraData {
    @SerializedName("PIXELHEIGHT")
    @Nullable
    private final String length;
    @SerializedName("PIXELWIDTH")
    @Nullable
    private final String width;

    public ExifExtraData(@Nullable String str, @Nullable String str2) {
        this.width = str;
        this.length = str2;
    }

    public static /* synthetic */ ExifExtraData copy$default(ExifExtraData exifExtraData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = exifExtraData.width;
        }
        if ((i & 2) != 0) {
            str2 = exifExtraData.length;
        }
        return exifExtraData.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.width;
    }

    @Nullable
    public final String component2() {
        return this.length;
    }

    @NotNull
    public final ExifExtraData copy(@Nullable String str, @Nullable String str2) {
        return new ExifExtraData(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExifExtraData)) {
            return false;
        }
        ExifExtraData exifExtraData = (ExifExtraData) obj;
        return Intrinsics.areEqual(this.width, exifExtraData.width) && Intrinsics.areEqual(this.length, exifExtraData.length);
    }

    @Nullable
    public final String getLength() {
        return this.length;
    }

    @Nullable
    public final String getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.width;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.length;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ExifExtraData(width=");
        L.append(this.width);
        L.append(", length=");
        return a.t(L, this.length, ")");
    }
}
