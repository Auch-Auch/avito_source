package com.avito.android.publish.objects;

import com.avito.android.category_parameters.ItemsWithStateContainer;
import com.avito.android.items.ItemWithState;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"publish_release"}, k = 2, mv = {1, 4, 2})
public final class ObjectsEditPresenterKt {
    public static final boolean access$notInNormalState(Item item) {
        boolean z = (item instanceof ItemWithState) && !(((ItemWithState) item).getState() instanceof ItemWithState.State.Normal);
        boolean z2 = (item instanceof ItemsWithStateContainer) && ((ItemsWithStateContainer) item).hasNotNormalState();
        if (z || z2) {
            return true;
        }
        return false;
    }
}
