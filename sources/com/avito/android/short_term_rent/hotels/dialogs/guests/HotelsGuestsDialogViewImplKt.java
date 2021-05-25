package com.avito.android.short_term_rent.hotels.dialogs.guests;

import com.avito.android.lib.design.picker.WheelData;
import com.avito.android.remote.model.hotels.Age;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"short-term-rent_release"}, k = 2, mv = {1, 4, 2})
public final class HotelsGuestsDialogViewImplKt {
    public static final List access$toWheelData(List list) {
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Age age = (Age) it.next();
            arrayList.add(new WheelData(Integer.valueOf(age.getValue()), age.getText()));
        }
        return arrayList;
    }
}
