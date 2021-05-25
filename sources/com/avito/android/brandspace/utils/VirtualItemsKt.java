package com.avito.android.brandspace.utils;

import a2.b.a.a.a;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.VirtualItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "", "unpackVirtualItems", "(Ljava/util/List;)V", "brandspace_release"}, k = 2, mv = {1, 4, 2})
public final class VirtualItemsKt {
    public static final void unpackVirtualItems(@NotNull List<BrandspaceItem> list) {
        ArrayList i0 = a.i0(list, "$this$unpackVirtualItems");
        for (T t : list) {
            if (t instanceof VirtualItem) {
                i0.add(t);
            }
        }
        ArrayList<VirtualItem> arrayList = new ArrayList();
        for (Object obj : i0) {
            if (((VirtualItem) obj).isUnpackable()) {
                arrayList.add(obj);
            }
        }
        for (VirtualItem virtualItem : arrayList) {
            int indexOf = list.indexOf(virtualItem);
            if (virtualItem.isReplaceableItem()) {
                list.remove(indexOf);
            } else {
                indexOf++;
            }
            list.addAll(indexOf, virtualItem.getUnpackItems());
        }
    }
}
