package com.avito.android.remote.model.category_parameters.slot.anonymous_number;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.BooleanParameter;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "component1", "()Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "", "", "component2", "()Ljava/util/List;", AnalyticFieldsName.field, "relatedFields", "copy", "(Lcom/avito/android/remote/model/category_parameters/BooleanParameter;Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlotConfig;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "getField", "Ljava/util/List;", "getRelatedFields", "<init>", "(Lcom/avito/android/remote/model/category_parameters/BooleanParameter;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AnonymousNumberSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<AnonymousNumberSlotConfig> CREATOR = new Creator();
    @SerializedName(AnalyticFieldsName.field)
    @NotNull
    private final BooleanParameter field;
    @SerializedName("relatedFields")
    @Nullable
    private final List<String> relatedFields;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AnonymousNumberSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AnonymousNumberSlotConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AnonymousNumberSlotConfig(BooleanParameter.CREATOR.createFromParcel(parcel), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AnonymousNumberSlotConfig[] newArray(int i) {
            return new AnonymousNumberSlotConfig[i];
        }
    }

    public AnonymousNumberSlotConfig(@NotNull BooleanParameter booleanParameter, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(booleanParameter, AnalyticFieldsName.field);
        this.field = booleanParameter;
        this.relatedFields = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.category_parameters.slot.anonymous_number.AnonymousNumberSlotConfig */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnonymousNumberSlotConfig copy$default(AnonymousNumberSlotConfig anonymousNumberSlotConfig, BooleanParameter booleanParameter, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            booleanParameter = anonymousNumberSlotConfig.field;
        }
        if ((i & 2) != 0) {
            list = anonymousNumberSlotConfig.relatedFields;
        }
        return anonymousNumberSlotConfig.copy(booleanParameter, list);
    }

    @NotNull
    public final BooleanParameter component1() {
        return this.field;
    }

    @Nullable
    public final List<String> component2() {
        return this.relatedFields;
    }

    @NotNull
    public final AnonymousNumberSlotConfig copy(@NotNull BooleanParameter booleanParameter, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(booleanParameter, AnalyticFieldsName.field);
        return new AnonymousNumberSlotConfig(booleanParameter, list);
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
        if (!(obj instanceof AnonymousNumberSlotConfig)) {
            return false;
        }
        AnonymousNumberSlotConfig anonymousNumberSlotConfig = (AnonymousNumberSlotConfig) obj;
        return Intrinsics.areEqual(this.field, anonymousNumberSlotConfig.field) && Intrinsics.areEqual(this.relatedFields, anonymousNumberSlotConfig.relatedFields);
    }

    @NotNull
    public final BooleanParameter getField() {
        return this.field;
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
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AnonymousNumberSlotConfig(field=");
        L.append(this.field);
        L.append(", relatedFields=");
        return a.w(L, this.relatedFields, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.field.writeToParcel(parcel, 0);
        parcel.writeStringList(this.relatedFields);
    }
}
