package com.avito.android.remote.model.category_parameters.slot.auto_publish;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.slot.Slot;
import com.avito.android.remote.model.category_parameters.slot.SlotState;
import com.avito.android.remote.model.category_parameters.slot.SlotWidget;
import com.avito.android.remote.model.category_parameters.slot.SlotWithState;
import com.avito.android.remote.model.category_parameters.slot.SlotWithValue;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0001\u001dB/\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlot;", "Lcom/avito/android/remote/model/category_parameters/slot/Slot;", "Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWithValue;", "Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlotValue;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWithState;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotState;", "getState", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "value", "Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlotValue;", "getValue", "()Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlotValue;", "setValue", "(Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlotValue;)V", "", "id", "label", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;", "widget", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlotValue;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AutoPublishSlot extends Slot<AutoPublishSlotConfig> implements SlotWithValue<AutoPublishSlotValue>, SlotWithState {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AutoPublishSlot> CREATOR = Parcels.creator(AutoPublishSlot$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("value")
    @Nullable
    private AutoPublishSlotValue value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlot$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/slot/auto_publish/AutoPublishSlot;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoPublishSlot(@NotNull String str, @NotNull String str2, @NotNull SlotWidget<AutoPublishSlotConfig> slotWidget, @Nullable AutoPublishSlotValue autoPublishSlotValue) {
        super(str, str2, slotWidget);
        a.Y0(str, "id", str2, "label", slotWidget, "widget");
        this.value = autoPublishSlotValue;
    }

    @Override // com.avito.android.remote.model.category_parameters.slot.SlotWithState
    @NotNull
    public SlotState getState() {
        return new SlotState(getId(), getParameters());
    }

    @Override // com.avito.android.remote.model.category_parameters.slot.Slot, android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        if (parcel != null) {
            parcel.writeParcelable(getValue(), i);
        }
    }

    @Override // com.avito.android.remote.model.category_parameters.slot.SlotWithValue
    @Nullable
    public AutoPublishSlotValue getValue() {
        return this.value;
    }

    public void setValue(@Nullable AutoPublishSlotValue autoPublishSlotValue) {
        this.value = autoPublishSlotValue;
    }
}
