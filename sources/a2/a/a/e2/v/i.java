package a2.a.a.e2.v;

import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.Navigation;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<ItemBrief, Navigation> {
    public static final i a = new i();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Navigation apply(ItemBrief itemBrief) {
        ItemBrief itemBrief2 = itemBrief;
        Intrinsics.checkNotNullParameter(itemBrief2, "it");
        return itemBrief2.getNavigation();
    }
}
