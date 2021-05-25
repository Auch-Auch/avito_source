package com.avito.android.remote.model.category_parameters.slot.anonymous_number;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.slot.SlotValue;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\rJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlotValue;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotValue;", "", "component1", "()Z", "required", "copy", "(Z)Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlotValue;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getRequired", "setRequired", "(Z)V", "<init>", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AnonymousNumberSlotValue implements SlotValue {
    public static final Parcelable.Creator<AnonymousNumberSlotValue> CREATOR = new Creator();
    @SerializedName("required")
    private boolean required;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AnonymousNumberSlotValue> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AnonymousNumberSlotValue createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AnonymousNumberSlotValue(parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AnonymousNumberSlotValue[] newArray(int i) {
            return new AnonymousNumberSlotValue[i];
        }
    }

    public AnonymousNumberSlotValue(boolean z) {
        this.required = z;
    }

    public static /* synthetic */ AnonymousNumberSlotValue copy$default(AnonymousNumberSlotValue anonymousNumberSlotValue, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = anonymousNumberSlotValue.required;
        }
        return anonymousNumberSlotValue.copy(z);
    }

    public final boolean component1() {
        return this.required;
    }

    @NotNull
    public final AnonymousNumberSlotValue copy(boolean z) {
        return new AnonymousNumberSlotValue(z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof AnonymousNumberSlotValue) && this.required == ((AnonymousNumberSlotValue) obj).required;
        }
        return true;
    }

    public final boolean getRequired() {
        return this.required;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean z = this.required;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final void setRequired(boolean z) {
        this.required = z;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.B(a.L("AnonymousNumberSlotValue(required="), this.required, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.required ? 1 : 0);
    }
}
