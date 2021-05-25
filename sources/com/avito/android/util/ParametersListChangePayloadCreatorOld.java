package com.avito.android.util;

import com.avito.android.items.InputItem;
import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/util/ParametersListChangePayloadCreatorOld;", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "Lcom/avito/konveyor/blueprint/Item;", "oldItem", "newItem", "", "getChangePayload", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Ljava/lang/Object;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersListChangePayloadCreatorOld implements ChangePayloadCreator {
    @Override // com.avito.android.recycler.data_aware.ChangePayloadCreator
    @Nullable
    public Object getChangePayload(@Nullable Item item, @Nullable Item item2) {
        boolean z = true;
        if ((!Intrinsics.areEqual(item != null ? Long.valueOf(item.getId()) : null, item2 != null ? Long.valueOf(item2.getId()) : null)) || !(item instanceof InputItem) || !(item2 instanceof InputItem)) {
            return null;
        }
        ValidatingInputPayload validatingInputPayload = new ValidatingInputPayload();
        InputItem inputItem = (InputItem) item;
        InputItem inputItem2 = (InputItem) item2;
        if (!(!Intrinsics.areEqual(inputItem.getValue(), inputItem2.getValue())) && !(!Intrinsics.areEqual(inputItem.getError(), inputItem2.getError()))) {
            z = false;
        }
        if (z) {
            return validatingInputPayload;
        }
        return null;
    }
}
