package com.avito.android.remote.model.category_parameters.slot.limits_info;

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
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlotField;", "component1", "()Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlotField;", AnalyticFieldsName.field, "copy", "(Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlotField;)Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlotConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlotField;", "getField", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/limits_info/LimitsInfoSlotField;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LimitsInfoSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<LimitsInfoSlotConfig> CREATOR = new Creator();
    @SerializedName(AnalyticFieldsName.field)
    @NotNull
    private final LimitsInfoSlotField field;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LimitsInfoSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LimitsInfoSlotConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LimitsInfoSlotConfig(LimitsInfoSlotField.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LimitsInfoSlotConfig[] newArray(int i) {
            return new LimitsInfoSlotConfig[i];
        }
    }

    public LimitsInfoSlotConfig(@NotNull LimitsInfoSlotField limitsInfoSlotField) {
        Intrinsics.checkNotNullParameter(limitsInfoSlotField, AnalyticFieldsName.field);
        this.field = limitsInfoSlotField;
    }

    public static /* synthetic */ LimitsInfoSlotConfig copy$default(LimitsInfoSlotConfig limitsInfoSlotConfig, LimitsInfoSlotField limitsInfoSlotField, int i, Object obj) {
        if ((i & 1) != 0) {
            limitsInfoSlotField = limitsInfoSlotConfig.field;
        }
        return limitsInfoSlotConfig.copy(limitsInfoSlotField);
    }

    @NotNull
    public final LimitsInfoSlotField component1() {
        return this.field;
    }

    @NotNull
    public final LimitsInfoSlotConfig copy(@NotNull LimitsInfoSlotField limitsInfoSlotField) {
        Intrinsics.checkNotNullParameter(limitsInfoSlotField, AnalyticFieldsName.field);
        return new LimitsInfoSlotConfig(limitsInfoSlotField);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof LimitsInfoSlotConfig) && Intrinsics.areEqual(this.field, ((LimitsInfoSlotConfig) obj).field);
        }
        return true;
    }

    @NotNull
    public final LimitsInfoSlotField getField() {
        return this.field;
    }

    @Override // java.lang.Object
    public int hashCode() {
        LimitsInfoSlotField limitsInfoSlotField = this.field;
        if (limitsInfoSlotField != null) {
            return limitsInfoSlotField.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("LimitsInfoSlotConfig(field=");
        L.append(this.field);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.field.writeToParcel(parcel, 0);
    }
}
