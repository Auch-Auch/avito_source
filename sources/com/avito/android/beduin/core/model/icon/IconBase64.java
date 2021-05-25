package com.avito.android.beduin.core.model.icon;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/beduin/core/model/icon/IconBase64;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "iconBase64", "iconBase64Dark", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/beduin/core/model/icon/IconBase64;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getIconBase64", "getIconBase64Dark", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class IconBase64 implements Parcelable {
    public static final Parcelable.Creator<IconBase64> CREATOR = new Creator();
    @NotNull
    private final String iconBase64;
    @Nullable
    private final String iconBase64Dark;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<IconBase64> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final IconBase64 createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new IconBase64(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final IconBase64[] newArray(int i) {
            return new IconBase64[i];
        }
    }

    public IconBase64(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "iconBase64");
        this.iconBase64 = str;
        this.iconBase64Dark = str2;
    }

    public static /* synthetic */ IconBase64 copy$default(IconBase64 iconBase642, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iconBase642.iconBase64;
        }
        if ((i & 2) != 0) {
            str2 = iconBase642.iconBase64Dark;
        }
        return iconBase642.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.iconBase64;
    }

    @Nullable
    public final String component2() {
        return this.iconBase64Dark;
    }

    @NotNull
    public final IconBase64 copy(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "iconBase64");
        return new IconBase64(str, str2);
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
        if (!(obj instanceof IconBase64)) {
            return false;
        }
        IconBase64 iconBase642 = (IconBase64) obj;
        return Intrinsics.areEqual(this.iconBase64, iconBase642.iconBase64) && Intrinsics.areEqual(this.iconBase64Dark, iconBase642.iconBase64Dark);
    }

    @NotNull
    public final String getIconBase64() {
        return this.iconBase64;
    }

    @Nullable
    public final String getIconBase64Dark() {
        return this.iconBase64Dark;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.iconBase64;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.iconBase64Dark;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("IconBase64(iconBase64=");
        L.append(this.iconBase64);
        L.append(", iconBase64Dark=");
        return a.t(L, this.iconBase64Dark, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.iconBase64);
        parcel.writeString(this.iconBase64Dark);
    }
}
