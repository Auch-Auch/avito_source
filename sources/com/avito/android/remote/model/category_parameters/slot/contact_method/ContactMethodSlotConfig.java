package com.avito.android.remote.model.category_parameters.slot.contact_method;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/contact_method/ContactMethodSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", "component1", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", AnalyticFieldsName.field, "copy", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;)Lcom/avito/android/remote/model/category_parameters/slot/contact_method/ContactMethodSlotConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", "getField", "<init>", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ContactMethodSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<ContactMethodSlotConfig> CREATOR = new Creator();
    @SerializedName(AnalyticFieldsName.field)
    @NotNull
    private final SelectParameter.Flat field;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ContactMethodSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactMethodSlotConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ContactMethodSlotConfig(SelectParameter.Flat.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactMethodSlotConfig[] newArray(int i) {
            return new ContactMethodSlotConfig[i];
        }
    }

    public ContactMethodSlotConfig(@NotNull SelectParameter.Flat flat) {
        Intrinsics.checkNotNullParameter(flat, AnalyticFieldsName.field);
        this.field = flat;
    }

    public static /* synthetic */ ContactMethodSlotConfig copy$default(ContactMethodSlotConfig contactMethodSlotConfig, SelectParameter.Flat flat, int i, Object obj) {
        if ((i & 1) != 0) {
            flat = contactMethodSlotConfig.field;
        }
        return contactMethodSlotConfig.copy(flat);
    }

    @NotNull
    public final SelectParameter.Flat component1() {
        return this.field;
    }

    @NotNull
    public final ContactMethodSlotConfig copy(@NotNull SelectParameter.Flat flat) {
        Intrinsics.checkNotNullParameter(flat, AnalyticFieldsName.field);
        return new ContactMethodSlotConfig(flat);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ContactMethodSlotConfig) && Intrinsics.areEqual(this.field, ((ContactMethodSlotConfig) obj).field);
        }
        return true;
    }

    @NotNull
    public final SelectParameter.Flat getField() {
        return this.field;
    }

    @Override // java.lang.Object
    public int hashCode() {
        SelectParameter.Flat flat = this.field;
        if (flat != null) {
            return flat.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContactMethodSlotConfig(field=");
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
