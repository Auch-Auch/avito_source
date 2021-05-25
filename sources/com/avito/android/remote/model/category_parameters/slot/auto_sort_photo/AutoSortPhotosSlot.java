package com.avito.android.remote.model.category_parameters.slot.auto_sort_photo;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.BooleanParameter;
import com.avito.android.remote.model.category_parameters.ObservableSlot;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.slot.SlotState;
import com.avito.android.remote.model.category_parameters.slot.SlotWidget;
import com.avito.android.remote.model.category_parameters.slot.SlotWithState;
import com.avito.android.remote.model.category_parameters.slot.SlotWithValue;
import com.avito.android.util.Parcels;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0001\"B/\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b \u0010!J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlot;", "Lcom/avito/android/remote/model/category_parameters/ObservableSlot;", "Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWithValue;", "Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlotValue;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWithState;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotState;", "getState", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotState;", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValueChangesListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/os/Parcel;", "dest", "", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "value", "Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlotValue;", "getValue", "()Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlotValue;", "setValue", "(Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlotValue;)V", "", "id", "label", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;", "widget", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlotValue;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AutoSortPhotosSlot extends ObservableSlot<AutoSortPhotosSlotConfig> implements SlotWithValue<AutoSortPhotosSlotValue>, SlotWithState {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AutoSortPhotosSlot> CREATOR = Parcels.creator(AutoSortPhotosSlot$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("value")
    @Nullable
    private AutoSortPhotosSlotValue value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlot$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/slot/auto_sort_photo/AutoSortPhotosSlot;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoSortPhotosSlot(@NotNull String str, @NotNull String str2, @NotNull SlotWidget<AutoSortPhotosSlotConfig> slotWidget, @Nullable AutoSortPhotosSlotValue autoSortPhotosSlotValue) {
        super(str, str2, slotWidget);
        a.Y0(str, "id", str2, "label", slotWidget, "widget");
        this.value = autoSortPhotosSlotValue;
    }

    @Override // com.avito.android.remote.model.category_parameters.slot.SlotWithState
    @NotNull
    public SlotState getState() {
        if (getValue() != null) {
            BooleanParameter field = ((AutoSortPhotosSlotConfig) getWidget().getConfig()).getField();
            AutoSortPhotosSlotValue value2 = getValue();
            field.setValue(value2 != null ? value2.getAutoSortImages() : null);
        }
        return new SlotState(getId(), d.listOf(((AutoSortPhotosSlotConfig) getWidget().getConfig()).getField()));
    }

    @Override // com.avito.android.remote.model.category_parameters.ObservableSlot, com.avito.android.remote.model.category_parameters.base.ObservableParameter
    public void setValueChangesListener(@NotNull Function1<? super EditableParameter<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ((AutoSortPhotosSlotConfig) getWidget().getConfig()).getField().setValueChangesListener(function1);
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
    public AutoSortPhotosSlotValue getValue() {
        return this.value;
    }

    public void setValue(@Nullable AutoSortPhotosSlotValue autoSortPhotosSlotValue) {
        this.value = autoSortPhotosSlotValue;
    }
}
