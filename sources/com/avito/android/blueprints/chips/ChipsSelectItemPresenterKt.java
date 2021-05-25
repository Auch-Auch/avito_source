package com.avito.android.blueprints.chips;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.SelectableItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import t6.n.d;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"item-temporary_release"}, k = 2, mv = {1, 4, 2})
public final class ChipsSelectItemPresenterKt {
    public static final List access$chipableValues(ParameterElement.Select.Flat flat) {
        List<SelectableItem> values = flat.getValues();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(values, 10));
        for (T t : values) {
            arrayList.add(new ChipableValue(t.getStringId(), t.getTitle()));
        }
        return arrayList;
    }

    public static final List access$selectedValues(ParameterElement.Select.Flat flat) {
        SelectableItem selectedValue = flat.getSelectedValue();
        if (selectedValue != null) {
            return d.listOf(new ChipableValue(selectedValue.getStringId(), selectedValue.getTitle()));
        }
        return null;
    }
}
