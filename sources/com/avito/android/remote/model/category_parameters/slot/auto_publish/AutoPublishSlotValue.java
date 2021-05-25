package com.avito.android.remote.model.category_parameters.slot.auto_publish;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\rJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlotValue;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotValue;", "", "component1", "()Ljava/lang/Boolean;", "autoPublish", "copy", "(Ljava/lang/Boolean;)Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlotValue;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Boolean;", "getAutoPublish", "setAutoPublish", "(Ljava/lang/Boolean;)V", "<init>", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AutoPublishSlotValue implements SlotValue {
    public static final Parcelable.Creator<AutoPublishSlotValue> CREATOR = new Creator();
    @SerializedName("autoPublish")
    @Nullable
    private Boolean autoPublish;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutoPublishSlotValue> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutoPublishSlotValue createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new AutoPublishSlotValue(bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutoPublishSlotValue[] newArray(int i) {
            return new AutoPublishSlotValue[i];
        }
    }

    public AutoPublishSlotValue(@Nullable Boolean bool) {
        this.autoPublish = bool;
    }

    public static /* synthetic */ AutoPublishSlotValue copy$default(AutoPublishSlotValue autoPublishSlotValue, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = autoPublishSlotValue.autoPublish;
        }
        return autoPublishSlotValue.copy(bool);
    }

    @Nullable
    public final Boolean component1() {
        return this.autoPublish;
    }

    @NotNull
    public final AutoPublishSlotValue copy(@Nullable Boolean bool) {
        return new AutoPublishSlotValue(bool);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof AutoPublishSlotValue) && Intrinsics.areEqual(this.autoPublish, ((AutoPublishSlotValue) obj).autoPublish);
        }
        return true;
    }

    @Nullable
    public final Boolean getAutoPublish() {
        return this.autoPublish;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Boolean bool = this.autoPublish;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public final void setAutoPublish(@Nullable Boolean bool) {
        this.autoPublish = bool;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.o(a.L("AutoPublishSlotValue(autoPublish="), this.autoPublish, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Boolean bool = this.autoPublish;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        parcel.writeInt(i2);
    }
}
