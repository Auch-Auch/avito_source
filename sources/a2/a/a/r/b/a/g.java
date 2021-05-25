package a2.a.a.r.b.a;

import com.avito.android.basket_legacy.utils.VasService;
import com.avito.android.basket_legacy.viewmodels.checkout.CheckoutViewModelImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<List<? extends VasService>, List<? extends Item>> {
    public final /* synthetic */ CheckoutViewModelImpl a;

    public g(CheckoutViewModelImpl checkoutViewModelImpl) {
        this.a = checkoutViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.basket_legacy.utils.VasToBasketItemConverter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public List<? extends Item> apply(List<? extends VasService> list) {
        List<? extends VasService> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "it");
        return this.a.x.convert(list2);
    }
}
