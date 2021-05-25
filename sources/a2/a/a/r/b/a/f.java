package a2.a.a.r.b.a;

import com.avito.android.basket_legacy.utils.SingleFeeService;
import com.avito.android.basket_legacy.viewmodels.checkout.CheckoutViewModelImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<SingleFeeService, List<? extends Item>> {
    public final /* synthetic */ CheckoutViewModelImpl a;

    public f(CheckoutViewModelImpl checkoutViewModelImpl) {
        this.a = checkoutViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends Item> apply(SingleFeeService singleFeeService) {
        SingleFeeService singleFeeService2 = singleFeeService;
        Intrinsics.checkNotNullParameter(singleFeeService2, "it");
        return this.a.y.convert(singleFeeService2);
    }
}
