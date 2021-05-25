package com.avito.android.beduin.component.image;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.remote.model.UniversalColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b0\u00101J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJL\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u001aJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\u000eR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010\u0007R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010-\u001a\u0004\b.\u0010\u000bR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010+\u001a\u0004\b/\u0010\u0007¨\u00062"}, d2 = {"Lcom/avito/android/beduin/component/image/ImageStyle;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/Integer;", "Lcom/avito/android/remote/model/UniversalColor;", "component2", "()Lcom/avito/android/remote/model/UniversalColor;", "component3", "Lcom/avito/android/beduin/component/image/OverlayStyle;", "component4", "()Lcom/avito/android/beduin/component/image/OverlayStyle;", "Lcom/avito/android/beduin/component/image/BorderStyle;", "component5", "()Lcom/avito/android/beduin/component/image/BorderStyle;", "cornerRadius", "loadingColor", "errorColor", "overlay", "border", "copy", "(Ljava/lang/Integer;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/beduin/component/image/OverlayStyle;Lcom/avito/android/beduin/component/image/BorderStyle;)Lcom/avito/android/beduin/component/image/ImageStyle;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/beduin/component/image/BorderStyle;", "getBorder", "Ljava/lang/Integer;", "getCornerRadius", "Lcom/avito/android/remote/model/UniversalColor;", "getErrorColor", "Lcom/avito/android/beduin/component/image/OverlayStyle;", "getOverlay", "getLoadingColor", "<init>", "(Ljava/lang/Integer;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/beduin/component/image/OverlayStyle;Lcom/avito/android/beduin/component/image/BorderStyle;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class ImageStyle implements Parcelable {
    public static final Parcelable.Creator<ImageStyle> CREATOR = new Creator();
    @Nullable
    private final BorderStyle border;
    @Nullable
    private final Integer cornerRadius;
    @Nullable
    private final UniversalColor errorColor;
    @Nullable
    private final UniversalColor loadingColor;
    @Nullable
    private final OverlayStyle overlay;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ImageStyle> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ImageStyle createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ImageStyle(parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, (UniversalColor) parcel.readParcelable(ImageStyle.class.getClassLoader()), (UniversalColor) parcel.readParcelable(ImageStyle.class.getClassLoader()), parcel.readInt() != 0 ? OverlayStyle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BorderStyle.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ImageStyle[] newArray(int i) {
            return new ImageStyle[i];
        }
    }

    public ImageStyle(@Nullable Integer num, @Nullable UniversalColor universalColor, @Nullable UniversalColor universalColor2, @Nullable OverlayStyle overlayStyle, @Nullable BorderStyle borderStyle) {
        this.cornerRadius = num;
        this.loadingColor = universalColor;
        this.errorColor = universalColor2;
        this.overlay = overlayStyle;
        this.border = borderStyle;
    }

    public static /* synthetic */ ImageStyle copy$default(ImageStyle imageStyle, Integer num, UniversalColor universalColor, UniversalColor universalColor2, OverlayStyle overlayStyle, BorderStyle borderStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            num = imageStyle.cornerRadius;
        }
        if ((i & 2) != 0) {
            universalColor = imageStyle.loadingColor;
        }
        if ((i & 4) != 0) {
            universalColor2 = imageStyle.errorColor;
        }
        if ((i & 8) != 0) {
            overlayStyle = imageStyle.overlay;
        }
        if ((i & 16) != 0) {
            borderStyle = imageStyle.border;
        }
        return imageStyle.copy(num, universalColor, universalColor2, overlayStyle, borderStyle);
    }

    @Nullable
    public final Integer component1() {
        return this.cornerRadius;
    }

    @Nullable
    public final UniversalColor component2() {
        return this.loadingColor;
    }

    @Nullable
    public final UniversalColor component3() {
        return this.errorColor;
    }

    @Nullable
    public final OverlayStyle component4() {
        return this.overlay;
    }

    @Nullable
    public final BorderStyle component5() {
        return this.border;
    }

    @NotNull
    public final ImageStyle copy(@Nullable Integer num, @Nullable UniversalColor universalColor, @Nullable UniversalColor universalColor2, @Nullable OverlayStyle overlayStyle, @Nullable BorderStyle borderStyle) {
        return new ImageStyle(num, universalColor, universalColor2, overlayStyle, borderStyle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageStyle)) {
            return false;
        }
        ImageStyle imageStyle = (ImageStyle) obj;
        return Intrinsics.areEqual(this.cornerRadius, imageStyle.cornerRadius) && Intrinsics.areEqual(this.loadingColor, imageStyle.loadingColor) && Intrinsics.areEqual(this.errorColor, imageStyle.errorColor) && Intrinsics.areEqual(this.overlay, imageStyle.overlay) && Intrinsics.areEqual(this.border, imageStyle.border);
    }

    @Nullable
    public final BorderStyle getBorder() {
        return this.border;
    }

    @Nullable
    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    @Nullable
    public final UniversalColor getErrorColor() {
        return this.errorColor;
    }

    @Nullable
    public final UniversalColor getLoadingColor() {
        return this.loadingColor;
    }

    @Nullable
    public final OverlayStyle getOverlay() {
        return this.overlay;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Integer num = this.cornerRadius;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        UniversalColor universalColor = this.loadingColor;
        int hashCode2 = (hashCode + (universalColor != null ? universalColor.hashCode() : 0)) * 31;
        UniversalColor universalColor2 = this.errorColor;
        int hashCode3 = (hashCode2 + (universalColor2 != null ? universalColor2.hashCode() : 0)) * 31;
        OverlayStyle overlayStyle = this.overlay;
        int hashCode4 = (hashCode3 + (overlayStyle != null ? overlayStyle.hashCode() : 0)) * 31;
        BorderStyle borderStyle = this.border;
        if (borderStyle != null) {
            i = borderStyle.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ImageStyle(cornerRadius=");
        L.append(this.cornerRadius);
        L.append(", loadingColor=");
        L.append(this.loadingColor);
        L.append(", errorColor=");
        L.append(this.errorColor);
        L.append(", overlay=");
        L.append(this.overlay);
        L.append(", border=");
        L.append(this.border);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Integer num = this.cornerRadius;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.loadingColor, i);
        parcel.writeParcelable(this.errorColor, i);
        OverlayStyle overlayStyle = this.overlay;
        if (overlayStyle != null) {
            parcel.writeInt(1);
            overlayStyle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        BorderStyle borderStyle = this.border;
        if (borderStyle != null) {
            parcel.writeInt(1);
            borderStyle.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
