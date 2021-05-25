package com.avito.android.util;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"item-temporary_release"}, k = 2, mv = {1, 4, 2})
public final class ParametersListChangePayloadCreatorKt {
    public static final boolean access$isRadioGroupSelect(Item item) {
        return item != null && (item instanceof ParameterElement.Select.Flat) && ((ParameterElement.Select.Flat) item).isRadioGroup();
    }
}
