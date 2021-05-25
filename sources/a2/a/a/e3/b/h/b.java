package a2.a.a.e3.b.h;

import com.avito.android.tariff.count.item.bonus.BonusItem;
import com.avito.conveyor_item.Item;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<Item, Boolean> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(Item item) {
        Item item2 = item;
        Intrinsics.checkNotNullParameter(item2, "it");
        return Boolean.valueOf(!(item2 instanceof BonusItem));
    }
}
