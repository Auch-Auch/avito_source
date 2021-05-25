package a2.a.a.q.a.i;

import com.avito.android.basket.checkout.viewmodel.CheckoutConverterImpl;
import com.avito.android.remote.model.CheckoutElement;
import com.avito.conveyor_item.ParcelableItem;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function2<Integer, CheckoutElement, List<? extends ParcelableItem>> {
    public final /* synthetic */ CheckoutConverterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(CheckoutConverterImpl checkoutConverterImpl) {
        super(2);
        this.a = checkoutConverterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public List<? extends ParcelableItem> invoke(Integer num, CheckoutElement checkoutElement) {
        int intValue = num.intValue();
        CheckoutElement checkoutElement2 = checkoutElement;
        Intrinsics.checkNotNullParameter(checkoutElement2, "element");
        return CheckoutConverterImpl.access$toItems(this.a, checkoutElement2, intValue);
    }
}
