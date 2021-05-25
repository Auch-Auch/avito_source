package com.avito.android.beduin.component.image;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.remote.model.UniversalColor;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/beduin/component/image/BorderStyle;", "Landroid/os/Parcelable;", "", "component1", "()I", "Lcom/avito/android/remote/model/UniversalColor;", "component2", "()Lcom/avito/android/remote/model/UniversalColor;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "color", "copy", "(ILcom/avito/android/remote/model/UniversalColor;)Lcom/avito/android/beduin/component/image/BorderStyle;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UniversalColor;", "getColor", "I", "getWidth", "<init>", "(ILcom/avito/android/remote/model/UniversalColor;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BorderStyle implements Parcelable {
    public static final Parcelable.Creator<BorderStyle> CREATOR = new Creator();
    @NotNull
    private final UniversalColor color;
    private final int width;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BorderStyle> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BorderStyle createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BorderStyle(parcel.readInt(), (UniversalColor) parcel.readParcelable(BorderStyle.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BorderStyle[] newArray(int i) {
            return new BorderStyle[i];
        }
    }

    public BorderStyle(int i, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        this.width = i;
        this.color = universalColor;
    }

    public static /* synthetic */ BorderStyle copy$default(BorderStyle borderStyle, int i, UniversalColor universalColor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = borderStyle.width;
        }
        if ((i2 & 2) != 0) {
            universalColor = borderStyle.color;
        }
        return borderStyle.copy(i, universalColor);
    }

    public final int component1() {
        return this.width;
    }

    @NotNull
    public final UniversalColor component2() {
        return this.color;
    }

    @NotNull
    public final BorderStyle copy(int i, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        return new BorderStyle(i, universalColor);
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
        if (!(obj instanceof BorderStyle)) {
            return false;
        }
        BorderStyle borderStyle = (BorderStyle) obj;
        return this.width == borderStyle.width && Intrinsics.areEqual(this.color, borderStyle.color);
    }

    @NotNull
    public final UniversalColor getColor() {
        return this.color;
    }

    public final int getWidth() {
        return this.width;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.width * 31;
        UniversalColor universalColor = this.color;
        return i + (universalColor != null ? universalColor.hashCode() : 0);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BorderStyle(width=");
        L.append(this.width);
        L.append(", color=");
        L.append(this.color);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.width);
        parcel.writeParcelable(this.color, i);
    }
}
