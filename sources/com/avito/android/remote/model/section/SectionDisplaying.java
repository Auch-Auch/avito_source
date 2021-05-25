package com.avito.android.remote.model.section;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/section/SectionDisplaying;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/section/SectionViewType;", "component1", "()Lcom/avito/android/remote/model/section/SectionViewType;", "listViewType", "copy", "(Lcom/avito/android/remote/model/section/SectionViewType;)Lcom/avito/android/remote/model/section/SectionDisplaying;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/section/SectionViewType;", "getListViewType", "<init>", "(Lcom/avito/android/remote/model/section/SectionViewType;)V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class SectionDisplaying implements Parcelable {
    public static final Parcelable.Creator<SectionDisplaying> CREATOR = new Creator();
    @SerializedName("listViewType")
    @Nullable
    private final SectionViewType listViewType;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SectionDisplaying> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SectionDisplaying createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SectionDisplaying(parcel.readInt() != 0 ? (SectionViewType) Enum.valueOf(SectionViewType.class, parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SectionDisplaying[] newArray(int i) {
            return new SectionDisplaying[i];
        }
    }

    public SectionDisplaying(@Nullable SectionViewType sectionViewType) {
        this.listViewType = sectionViewType;
    }

    public static /* synthetic */ SectionDisplaying copy$default(SectionDisplaying sectionDisplaying, SectionViewType sectionViewType, int i, Object obj) {
        if ((i & 1) != 0) {
            sectionViewType = sectionDisplaying.listViewType;
        }
        return sectionDisplaying.copy(sectionViewType);
    }

    @Nullable
    public final SectionViewType component1() {
        return this.listViewType;
    }

    @NotNull
    public final SectionDisplaying copy(@Nullable SectionViewType sectionViewType) {
        return new SectionDisplaying(sectionViewType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SectionDisplaying) && Intrinsics.areEqual(this.listViewType, ((SectionDisplaying) obj).listViewType);
        }
        return true;
    }

    @Nullable
    public final SectionViewType getListViewType() {
        return this.listViewType;
    }

    @Override // java.lang.Object
    public int hashCode() {
        SectionViewType sectionViewType = this.listViewType;
        if (sectionViewType != null) {
            return sectionViewType.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SectionDisplaying(listViewType=");
        L.append(this.listViewType);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        SectionViewType sectionViewType = this.listViewType;
        if (sectionViewType != null) {
            parcel.writeInt(1);
            parcel.writeString(sectionViewType.name());
            return;
        }
        parcel.writeInt(0);
    }
}
