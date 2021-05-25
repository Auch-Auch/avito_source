package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.ParcelableEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\"\u0010\u001a\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u0018\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001b\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SectionTitle;", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "component1", "()Ljava/lang/String;", "name", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/SectionTitle;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getName", "id", "getId", "getId$annotations", "()V", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SectionTitle implements ParcelableEntity<String> {
    public static final Parcelable.Creator<SectionTitle> CREATOR = new Creator();
    @NotNull
    private final String id = "";
    @NotNull
    private final String name;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SectionTitle> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SectionTitle createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SectionTitle(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SectionTitle[] newArray(int i) {
            return new SectionTitle[i];
        }
    }

    public SectionTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public static /* synthetic */ SectionTitle copy$default(SectionTitle sectionTitle, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sectionTitle.getName();
        }
        return sectionTitle.copy(str);
    }

    public static /* synthetic */ void getId$annotations() {
    }

    @NotNull
    public final String component1() {
        return getName();
    }

    @NotNull
    public final SectionTitle copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new SectionTitle(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SectionTitle) && Intrinsics.areEqual(getName(), ((SectionTitle) obj).getName());
        }
        return true;
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String name2 = getName();
        if (name2 != null) {
            return name2.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SectionTitle(name=");
        L.append(getName());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getId() {
        return this.id;
    }
}
