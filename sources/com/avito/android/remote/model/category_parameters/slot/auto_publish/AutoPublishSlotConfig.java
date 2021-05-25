package com.avito.android.remote.model.category_parameters.slot.auto_publish;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.BooleanParameter;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0015J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\bR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010\u0004R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010\u000b¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "component1", "()Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "", "", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/Boolean;", AnalyticFieldsName.field, "relatedFields", "readyToDisplay", "copy", "(Lcom/avito/android/remote/model/category_parameters/BooleanParameter;Ljava/util/List;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlotConfig;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getRelatedFields", "Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "getField", "Ljava/lang/Boolean;", "getReadyToDisplay", "<init>", "(Lcom/avito/android/remote/model/category_parameters/BooleanParameter;Ljava/util/List;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AutoPublishSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<AutoPublishSlotConfig> CREATOR = new Creator();
    @SerializedName(AnalyticFieldsName.field)
    @NotNull
    private final BooleanParameter field;
    @SerializedName("readyToDisplay")
    @Nullable
    private final Boolean readyToDisplay;
    @SerializedName("relatedFields")
    @Nullable
    private final List<String> relatedFields;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutoPublishSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutoPublishSlotConfig createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            BooleanParameter createFromParcel = BooleanParameter.CREATOR.createFromParcel(parcel);
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new AutoPublishSlotConfig(createFromParcel, createStringArrayList, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutoPublishSlotConfig[] newArray(int i) {
            return new AutoPublishSlotConfig[i];
        }
    }

    public AutoPublishSlotConfig(@NotNull BooleanParameter booleanParameter, @Nullable List<String> list, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(booleanParameter, AnalyticFieldsName.field);
        this.field = booleanParameter;
        this.relatedFields = list;
        this.readyToDisplay = bool;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.category_parameters.slot.auto_publish.AutoPublishSlotConfig */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutoPublishSlotConfig copy$default(AutoPublishSlotConfig autoPublishSlotConfig, BooleanParameter booleanParameter, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            booleanParameter = autoPublishSlotConfig.field;
        }
        if ((i & 2) != 0) {
            list = autoPublishSlotConfig.relatedFields;
        }
        if ((i & 4) != 0) {
            bool = autoPublishSlotConfig.readyToDisplay;
        }
        return autoPublishSlotConfig.copy(booleanParameter, list, bool);
    }

    @NotNull
    public final BooleanParameter component1() {
        return this.field;
    }

    @Nullable
    public final List<String> component2() {
        return this.relatedFields;
    }

    @Nullable
    public final Boolean component3() {
        return this.readyToDisplay;
    }

    @NotNull
    public final AutoPublishSlotConfig copy(@NotNull BooleanParameter booleanParameter, @Nullable List<String> list, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(booleanParameter, AnalyticFieldsName.field);
        return new AutoPublishSlotConfig(booleanParameter, list, bool);
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
        if (!(obj instanceof AutoPublishSlotConfig)) {
            return false;
        }
        AutoPublishSlotConfig autoPublishSlotConfig = (AutoPublishSlotConfig) obj;
        return Intrinsics.areEqual(this.field, autoPublishSlotConfig.field) && Intrinsics.areEqual(this.relatedFields, autoPublishSlotConfig.relatedFields) && Intrinsics.areEqual(this.readyToDisplay, autoPublishSlotConfig.readyToDisplay);
    }

    @NotNull
    public final BooleanParameter getField() {
        return this.field;
    }

    @Nullable
    public final Boolean getReadyToDisplay() {
        return this.readyToDisplay;
    }

    @Nullable
    public final List<String> getRelatedFields() {
        return this.relatedFields;
    }

    @Override // java.lang.Object
    public int hashCode() {
        BooleanParameter booleanParameter = this.field;
        int i = 0;
        int hashCode = (booleanParameter != null ? booleanParameter.hashCode() : 0) * 31;
        List<String> list = this.relatedFields;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.readyToDisplay;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AutoPublishSlotConfig(field=");
        L.append(this.field);
        L.append(", relatedFields=");
        L.append(this.relatedFields);
        L.append(", readyToDisplay=");
        return a.o(L, this.readyToDisplay, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.field.writeToParcel(parcel, 0);
        parcel.writeStringList(this.relatedFields);
        Boolean bool = this.readyToDisplay;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
    }
}
