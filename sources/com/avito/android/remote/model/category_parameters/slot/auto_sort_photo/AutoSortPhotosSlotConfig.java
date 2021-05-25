package com.avito.android.remote.model.category_parameters.slot.auto_sort_photo;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.BooleanParameter;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0011J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "component1", "()Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "", "component2", "()Ljava/lang/Boolean;", AnalyticFieldsName.field, "defaultValue", "copy", "(Lcom/avito/android/remote/model/category_parameters/BooleanParameter;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlotConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "getField", "Ljava/lang/Boolean;", "getDefaultValue", "<init>", "(Lcom/avito/android/remote/model/category_parameters/BooleanParameter;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AutoSortPhotosSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<AutoSortPhotosSlotConfig> CREATOR = new Creator();
    @SerializedName("defaultValue")
    @Nullable
    private final Boolean defaultValue;
    @SerializedName(AnalyticFieldsName.field)
    @NotNull
    private final BooleanParameter field;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutoSortPhotosSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutoSortPhotosSlotConfig createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            BooleanParameter createFromParcel = BooleanParameter.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new AutoSortPhotosSlotConfig(createFromParcel, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutoSortPhotosSlotConfig[] newArray(int i) {
            return new AutoSortPhotosSlotConfig[i];
        }
    }

    public AutoSortPhotosSlotConfig(@NotNull BooleanParameter booleanParameter, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(booleanParameter, AnalyticFieldsName.field);
        this.field = booleanParameter;
        this.defaultValue = bool;
    }

    public static /* synthetic */ AutoSortPhotosSlotConfig copy$default(AutoSortPhotosSlotConfig autoSortPhotosSlotConfig, BooleanParameter booleanParameter, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            booleanParameter = autoSortPhotosSlotConfig.field;
        }
        if ((i & 2) != 0) {
            bool = autoSortPhotosSlotConfig.defaultValue;
        }
        return autoSortPhotosSlotConfig.copy(booleanParameter, bool);
    }

    @NotNull
    public final BooleanParameter component1() {
        return this.field;
    }

    @Nullable
    public final Boolean component2() {
        return this.defaultValue;
    }

    @NotNull
    public final AutoSortPhotosSlotConfig copy(@NotNull BooleanParameter booleanParameter, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(booleanParameter, AnalyticFieldsName.field);
        return new AutoSortPhotosSlotConfig(booleanParameter, bool);
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
        if (!(obj instanceof AutoSortPhotosSlotConfig)) {
            return false;
        }
        AutoSortPhotosSlotConfig autoSortPhotosSlotConfig = (AutoSortPhotosSlotConfig) obj;
        return Intrinsics.areEqual(this.field, autoSortPhotosSlotConfig.field) && Intrinsics.areEqual(this.defaultValue, autoSortPhotosSlotConfig.defaultValue);
    }

    @Nullable
    public final Boolean getDefaultValue() {
        return this.defaultValue;
    }

    @NotNull
    public final BooleanParameter getField() {
        return this.field;
    }

    @Override // java.lang.Object
    public int hashCode() {
        BooleanParameter booleanParameter = this.field;
        int i = 0;
        int hashCode = (booleanParameter != null ? booleanParameter.hashCode() : 0) * 31;
        Boolean bool = this.defaultValue;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AutoSortPhotosSlotConfig(field=");
        L.append(this.field);
        L.append(", defaultValue=");
        return a.o(L, this.defaultValue, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.field.writeToParcel(parcel, 0);
        Boolean bool = this.defaultValue;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoSortPhotosSlotConfig(BooleanParameter booleanParameter, Boolean bool, int i, j jVar) {
        this(booleanParameter, (i & 2) != 0 ? null : bool);
    }
}
