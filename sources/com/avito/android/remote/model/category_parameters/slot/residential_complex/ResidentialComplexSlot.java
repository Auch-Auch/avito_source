package com.avito.android.remote.model.category_parameters.slot.residential_complex;

import a2.b.a.a.a;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.ObservableSlot;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotState;
import com.avito.android.remote.model.category_parameters.slot.SlotWidget;
import com.avito.android.remote.model.category_parameters.slot.SlotWithParameters;
import com.avito.android.remote.model.category_parameters.slot.SlotWithState;
import com.avito.android.util.Parcels;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0012B%\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSlot;", "Lcom/avito/android/remote/model/category_parameters/ObservableSlot;", "Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWithState;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWithParameters;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotState;", "getState", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotState;", "", "initParameters", "()V", "", "id", "label", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;", "widget", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexSlot extends ObservableSlot<ResidentialComplexSlotConfig> implements SlotWithState, SlotWithParameters {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ResidentialComplexSlot> CREATOR = Parcels.creator(ResidentialComplexSlot$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSlot$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSlot;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResidentialComplexSlot(@NotNull String str, @NotNull String str2, @NotNull SlotWidget<ResidentialComplexSlotConfig> slotWidget) {
        super(str, str2, slotWidget);
        a.Y0(str, "id", str2, "label", slotWidget, "widget");
    }

    @Override // com.avito.android.remote.model.category_parameters.slot.SlotWithState
    @NotNull
    public SlotState getState() {
        return new SlotState(getId(), getParameters());
    }

    @Override // com.avito.android.remote.model.category_parameters.slot.SlotWithParameters
    public void initParameters() {
        List<? extends ParameterSlot> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(((ResidentialComplexSlotConfig) getWidget().getConfig()).getDevelopment());
        CharParameter spec = ((ResidentialComplexSlotConfig) getWidget().getConfig()).getSpec();
        if (spec != null) {
            mutableListOf.add(spec);
        }
        SelectParameter.Flat building = ((ResidentialComplexSlotConfig) getWidget().getConfig()).getBuilding();
        if (building != null) {
            mutableListOf.add(building);
        }
        CharParameter buildingQueue = ((ResidentialComplexSlotConfig) getWidget().getConfig()).getBuildingQueue();
        if (buildingQueue != null) {
            mutableListOf.add(buildingQueue);
        }
        setParameters(mutableListOf);
    }
}
