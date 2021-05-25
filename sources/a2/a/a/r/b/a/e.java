package a2.a.a.r.b.a;

import com.avito.android.basket_legacy.utils.PackageService;
import com.avito.android.basket_legacy.viewmodels.checkout.CheckoutViewModelImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<PackageService, List<? extends Item>> {
    public final /* synthetic */ CheckoutViewModelImpl a;

    public e(CheckoutViewModelImpl checkoutViewModelImpl) {
        this.a = checkoutViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends Item> apply(PackageService packageService) {
        PackageService packageService2 = packageService;
        Intrinsics.checkNotNullParameter(packageService2, "it");
        return this.a.y.convert(packageService2);
    }
}
