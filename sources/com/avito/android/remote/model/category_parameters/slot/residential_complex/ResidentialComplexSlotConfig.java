package com.avito.android.remote.model.category_parameters.slot.residential_complex;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ>\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\u0007R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010\nR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010\u0004R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b*\u0010\n¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSelect;", "component1", "()Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSelect;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", "component2", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", "Lcom/avito/android/remote/model/category_parameters/CharParameter;", "component3", "()Lcom/avito/android/remote/model/category_parameters/CharParameter;", "component4", "development", "building", "spec", "buildingQueue", "copy", "(Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSelect;Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;Lcom/avito/android/remote/model/category_parameters/CharParameter;Lcom/avito/android/remote/model/category_parameters/CharParameter;)Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSlotConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", "getBuilding", "Lcom/avito/android/remote/model/category_parameters/CharParameter;", "getBuildingQueue", "Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSelect;", "getDevelopment", "getSpec", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSelect;Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;Lcom/avito/android/remote/model/category_parameters/CharParameter;Lcom/avito/android/remote/model/category_parameters/CharParameter;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<ResidentialComplexSlotConfig> CREATOR = new Creator();
    @SerializedName("building")
    @Nullable
    private final SelectParameter.Flat building;
    @SerializedName("buildingQueue")
    @Nullable
    private final CharParameter buildingQueue;
    @SerializedName("development")
    @NotNull
    private final ResidentialComplexSelect development;
    @SerializedName("spec")
    @Nullable
    private final CharParameter spec;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ResidentialComplexSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ResidentialComplexSlotConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            ResidentialComplexSelect createFromParcel = ResidentialComplexSelect.CREATOR.createFromParcel(parcel);
            CharParameter charParameter = null;
            SelectParameter.Flat createFromParcel2 = parcel.readInt() != 0 ? SelectParameter.Flat.CREATOR.createFromParcel(parcel) : null;
            CharParameter createFromParcel3 = parcel.readInt() != 0 ? CharParameter.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                charParameter = CharParameter.CREATOR.createFromParcel(parcel);
            }
            return new ResidentialComplexSlotConfig(createFromParcel, createFromParcel2, createFromParcel3, charParameter);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ResidentialComplexSlotConfig[] newArray(int i) {
            return new ResidentialComplexSlotConfig[i];
        }
    }

    public ResidentialComplexSlotConfig(@NotNull ResidentialComplexSelect residentialComplexSelect, @Nullable SelectParameter.Flat flat, @Nullable CharParameter charParameter, @Nullable CharParameter charParameter2) {
        Intrinsics.checkNotNullParameter(residentialComplexSelect, "development");
        this.development = residentialComplexSelect;
        this.building = flat;
        this.spec = charParameter;
        this.buildingQueue = charParameter2;
    }

    public static /* synthetic */ ResidentialComplexSlotConfig copy$default(ResidentialComplexSlotConfig residentialComplexSlotConfig, ResidentialComplexSelect residentialComplexSelect, SelectParameter.Flat flat, CharParameter charParameter, CharParameter charParameter2, int i, Object obj) {
        if ((i & 1) != 0) {
            residentialComplexSelect = residentialComplexSlotConfig.development;
        }
        if ((i & 2) != 0) {
            flat = residentialComplexSlotConfig.building;
        }
        if ((i & 4) != 0) {
            charParameter = residentialComplexSlotConfig.spec;
        }
        if ((i & 8) != 0) {
            charParameter2 = residentialComplexSlotConfig.buildingQueue;
        }
        return residentialComplexSlotConfig.copy(residentialComplexSelect, flat, charParameter, charParameter2);
    }

    @NotNull
    public final ResidentialComplexSelect component1() {
        return this.development;
    }

    @Nullable
    public final SelectParameter.Flat component2() {
        return this.building;
    }

    @Nullable
    public final CharParameter component3() {
        return this.spec;
    }

    @Nullable
    public final CharParameter component4() {
        return this.buildingQueue;
    }

    @NotNull
    public final ResidentialComplexSlotConfig copy(@NotNull ResidentialComplexSelect residentialComplexSelect, @Nullable SelectParameter.Flat flat, @Nullable CharParameter charParameter, @Nullable CharParameter charParameter2) {
        Intrinsics.checkNotNullParameter(residentialComplexSelect, "development");
        return new ResidentialComplexSlotConfig(residentialComplexSelect, flat, charParameter, charParameter2);
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
        if (!(obj instanceof ResidentialComplexSlotConfig)) {
            return false;
        }
        ResidentialComplexSlotConfig residentialComplexSlotConfig = (ResidentialComplexSlotConfig) obj;
        return Intrinsics.areEqual(this.development, residentialComplexSlotConfig.development) && Intrinsics.areEqual(this.building, residentialComplexSlotConfig.building) && Intrinsics.areEqual(this.spec, residentialComplexSlotConfig.spec) && Intrinsics.areEqual(this.buildingQueue, residentialComplexSlotConfig.buildingQueue);
    }

    @Nullable
    public final SelectParameter.Flat getBuilding() {
        return this.building;
    }

    @Nullable
    public final CharParameter getBuildingQueue() {
        return this.buildingQueue;
    }

    @NotNull
    public final ResidentialComplexSelect getDevelopment() {
        return this.development;
    }

    @Nullable
    public final CharParameter getSpec() {
        return this.spec;
    }

    @Override // java.lang.Object
    public int hashCode() {
        ResidentialComplexSelect residentialComplexSelect = this.development;
        int i = 0;
        int hashCode = (residentialComplexSelect != null ? residentialComplexSelect.hashCode() : 0) * 31;
        SelectParameter.Flat flat = this.building;
        int hashCode2 = (hashCode + (flat != null ? flat.hashCode() : 0)) * 31;
        CharParameter charParameter = this.spec;
        int hashCode3 = (hashCode2 + (charParameter != null ? charParameter.hashCode() : 0)) * 31;
        CharParameter charParameter2 = this.buildingQueue;
        if (charParameter2 != null) {
            i = charParameter2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ResidentialComplexSlotConfig(development=");
        L.append(this.development);
        L.append(", building=");
        L.append(this.building);
        L.append(", spec=");
        L.append(this.spec);
        L.append(", buildingQueue=");
        L.append(this.buildingQueue);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.development.writeToParcel(parcel, 0);
        SelectParameter.Flat flat = this.building;
        if (flat != null) {
            parcel.writeInt(1);
            flat.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        CharParameter charParameter = this.spec;
        if (charParameter != null) {
            parcel.writeInt(1);
            charParameter.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        CharParameter charParameter2 = this.buildingQueue;
        if (charParameter2 != null) {
            parcel.writeInt(1);
            charParameter2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
