package a2.a.a.e3.b.h;

import com.avito.android.tariff.count.item.CountItem;
import com.avito.conveyor_item.Item;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<Item, Item> {
    public final /* synthetic */ String a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(String str) {
        super(1);
        this.a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Item invoke(Item item) {
        Item item2 = item;
        Intrinsics.checkNotNullParameter(item2, "it");
        return item2 instanceof CountItem ? CountItem.copy$default((CountItem) item2, null, null, null, null, Intrinsics.areEqual(item2.getStringId(), this.a), false, 47, null) : item2;
    }
}
