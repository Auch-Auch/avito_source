package com.avito.android.remote.model.category_parameters.slot;

import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/BaseSlot;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "getSlotType", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "slotType", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseSlot implements ParameterSlot {
    @NotNull
    public abstract SlotType getSlotType();
}
