package com.avito.android.remote.model.category_parameters.slot;

import com.avito.android.remote.model.category_parameters.slot.SlotValue;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003R\u001e\u0010\b\u001a\u0004\u0018\u00018\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/SlotWithValue;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotValue;", "T", "", "getValue", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotValue;", "setValue", "(Lcom/avito/android/remote/model/category_parameters/slot/SlotValue;)V", "value", "models_release"}, k = 1, mv = {1, 4, 2})
public interface SlotWithValue<T extends SlotValue> {
    @Nullable
    T getValue();

    void setValue(@Nullable T t);
}
