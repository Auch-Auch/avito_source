package com.avito.android.short_term_rent.hotels.dialogs.location;

import com.avito.android.remote.model.hotels.HotelsLocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"short-term-rent_release"}, k = 2, mv = {1, 4, 2})
public final class HotelsLocationViewModelKt {
    public static final List access$toDialogItems(List list) {
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HotelsLocation hotelsLocation = (HotelsLocation) it.next();
            arrayList.add(new HotelsLocationDialogItem(String.valueOf(hotelsLocation.getId()), hotelsLocation));
        }
        return arrayList;
    }
}
