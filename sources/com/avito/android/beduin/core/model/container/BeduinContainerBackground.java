package com.avito.android.beduin.core.model.container;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/UniversalColor;", "component1", "()Lcom/avito/android/remote/model/UniversalColor;", "", "component2", "()Ljava/lang/Integer;", "color", "cornerRadius", "copy", "(Lcom/avito/android/remote/model/UniversalColor;Ljava/lang/Integer;)Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UniversalColor;", "getColor", "Ljava/lang/Integer;", "getCornerRadius", "<init>", "(Lcom/avito/android/remote/model/UniversalColor;Ljava/lang/Integer;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinContainerBackground implements Parcelable {
    public static final Parcelable.Creator<BeduinContainerBackground> CREATOR = new Creator();
    @Nullable
    private final UniversalColor color;
    @Nullable
    private final Integer cornerRadius;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinContainerBackground> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinContainerBackground createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BeduinContainerBackground((UniversalColor) parcel.readParcelable(BeduinContainerBackground.class.getClassLoader()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinContainerBackground[] newArray(int i) {
            return new BeduinContainerBackground[i];
        }
    }

    public BeduinContainerBackground(@Nullable UniversalColor universalColor, @Nullable Integer num) {
        this.color = universalColor;
        this.cornerRadius = num;
    }

    public static /* synthetic */ BeduinContainerBackground copy$default(BeduinContainerBackground beduinContainerBackground, UniversalColor universalColor, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            universalColor = beduinContainerBackground.color;
        }
        if ((i & 2) != 0) {
            num = beduinContainerBackground.cornerRadius;
        }
        return beduinContainerBackground.copy(universalColor, num);
    }

    @Nullable
    public final UniversalColor component1() {
        return this.color;
    }

    @Nullable
    public final Integer component2() {
        return this.cornerRadius;
    }

    @NotNull
    public final BeduinContainerBackground copy(@Nullable UniversalColor universalColor, @Nullable Integer num) {
        return new BeduinContainerBackground(universalColor, num);
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
        if (!(obj instanceof BeduinContainerBackground)) {
            return false;
        }
        BeduinContainerBackground beduinContainerBackground = (BeduinContainerBackground) obj;
        return Intrinsics.areEqual(this.color, beduinContainerBackground.color) && Intrinsics.areEqual(this.cornerRadius, beduinContainerBackground.cornerRadius);
    }

    @Nullable
    public final UniversalColor getColor() {
        return this.color;
    }

    @Nullable
    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // java.lang.Object
    public int hashCode() {
        UniversalColor universalColor = this.color;
        int i = 0;
        int hashCode = (universalColor != null ? universalColor.hashCode() : 0) * 31;
        Integer num = this.cornerRadius;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinContainerBackground(color=");
        L.append(this.color);
        L.append(", cornerRadius=");
        return a.p(L, this.cornerRadius, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.color, i);
        Integer num = this.cornerRadius;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
