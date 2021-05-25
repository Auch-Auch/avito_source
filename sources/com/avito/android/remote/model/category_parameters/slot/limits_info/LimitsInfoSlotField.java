package com.avito.android.remote.model.category_parameters.slot.limits_info;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlotField;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "id", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlotField;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LimitsInfoSlotField implements Parcelable {
    public static final Parcelable.Creator<LimitsInfoSlotField> CREATOR = new Creator();
    @SerializedName("id")
    @NotNull
    private final String id;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LimitsInfoSlotField> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LimitsInfoSlotField createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LimitsInfoSlotField(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LimitsInfoSlotField[] newArray(int i) {
            return new LimitsInfoSlotField[i];
        }
    }

    public LimitsInfoSlotField(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
    }

    public static /* synthetic */ LimitsInfoSlotField copy$default(LimitsInfoSlotField limitsInfoSlotField, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = limitsInfoSlotField.id;
        }
        return limitsInfoSlotField.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final LimitsInfoSlotField copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new LimitsInfoSlotField(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof LimitsInfoSlotField) && Intrinsics.areEqual(this.id, ((LimitsInfoSlotField) obj).id);
        }
        return true;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.t(a.L("LimitsInfoSlotField(id="), this.id, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
    }
}
