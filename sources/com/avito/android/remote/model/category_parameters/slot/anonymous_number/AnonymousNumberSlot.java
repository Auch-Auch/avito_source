package com.avito.android.remote.model.category_parameters.slot.anonymous_number;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.slot.Slot;
import com.avito.android.remote.model.category_parameters.slot.SlotState;
import com.avito.android.remote.model.category_parameters.slot.SlotWidget;
import com.avito.android.remote.model.category_parameters.slot.SlotWithState;
import com.avito.android.remote.model.category_parameters.slot.SlotWithValue;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\u001dB/\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlot;", "Lcom/avito/android/remote/model/category_parameters/slot/Slot;", "Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWithState;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWithValue;", "Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlotValue;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotState;", "getState", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "value", "Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlotValue;", "getValue", "()Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlotValue;", "setValue", "(Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlotValue;)V", "", "id", "label", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;", "widget", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlotValue;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AnonymousNumberSlot extends Slot<AnonymousNumberSlotConfig> implements SlotWithState, SlotWithValue<AnonymousNumberSlotValue> {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AnonymousNumberSlot> CREATOR = Parcels.creator(AnonymousNumberSlot$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private AnonymousNumberSlotValue value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlot$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/slot/anonymous_number/AnonymousNumberSlot;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnonymousNumberSlot(@NotNull String str, @NotNull String str2, @NotNull SlotWidget<AnonymousNumberSlotConfig> slotWidget, @Nullable AnonymousNumberSlotValue anonymousNumberSlotValue) {
        super(str, str2, slotWidget);
        a.Y0(str, "id", str2, "label", slotWidget, "widget");
        this.value = anonymousNumberSlotValue;
    }

    @Override // com.avito.android.remote.model.category_parameters.slot.SlotWithState
    @NotNull
    public SlotState getState() {
        return new SlotState(getId(), d.listOf(((AnonymousNumberSlotConfig) getWidget().getConfig()).getField()));
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
    public AnonymousNumberSlotValue getValue() {
        return this.value;
    }

    public void setValue(@Nullable AnonymousNumberSlotValue anonymousNumberSlotValue) {
        this.value = anonymousNumberSlotValue;
    }
}
