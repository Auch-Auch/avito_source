package com.avito.android.remote.model.category_parameters.slot.header;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000fJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/header/SectionSeparatorSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "title", "showTopSeparator", "copy", "(Ljava/lang/String;Z)Lcom/avito/android/remote/model/category_parameters/slot/header/SectionSeparatorSlotConfig;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getShowTopSeparator", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Z)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SectionSeparatorSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<SectionSeparatorSlotConfig> CREATOR = new Creator();
    @SerializedName("showTopSeparator")
    private final boolean showTopSeparator;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SectionSeparatorSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SectionSeparatorSlotConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SectionSeparatorSlotConfig(parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SectionSeparatorSlotConfig[] newArray(int i) {
            return new SectionSeparatorSlotConfig[i];
        }
    }

    public SectionSeparatorSlotConfig(@Nullable String str, boolean z) {
        this.title = str;
        this.showTopSeparator = z;
    }

    public static /* synthetic */ SectionSeparatorSlotConfig copy$default(SectionSeparatorSlotConfig sectionSeparatorSlotConfig, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sectionSeparatorSlotConfig.title;
        }
        if ((i & 2) != 0) {
            z = sectionSeparatorSlotConfig.showTopSeparator;
        }
        return sectionSeparatorSlotConfig.copy(str, z);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    public final boolean component2() {
        return this.showTopSeparator;
    }

    @NotNull
    public final SectionSeparatorSlotConfig copy(@Nullable String str, boolean z) {
        return new SectionSeparatorSlotConfig(str, z);
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
        if (!(obj instanceof SectionSeparatorSlotConfig)) {
            return false;
        }
        SectionSeparatorSlotConfig sectionSeparatorSlotConfig = (SectionSeparatorSlotConfig) obj;
        return Intrinsics.areEqual(this.title, sectionSeparatorSlotConfig.title) && this.showTopSeparator == sectionSeparatorSlotConfig.showTopSeparator;
    }

    public final boolean getShowTopSeparator() {
        return this.showTopSeparator;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.showTopSeparator;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SectionSeparatorSlotConfig(title=");
        L.append(this.title);
        L.append(", showTopSeparator=");
        return a.B(L, this.showTopSeparator, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeInt(this.showTopSeparator ? 1 : 0);
    }
}
