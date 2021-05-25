package a2.a.a.a0.a.q.a;

import com.avito.android.cart.summary.konveyor.product.ProductItemViewHolder;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ProductItemViewHolder a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ProductItemViewHolder productItemViewHolder) {
        super(0);
        this.a = productItemViewHolder;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ProductItemViewHolder productItemViewHolder = this.a;
        ProductItemViewHolder.access$adjustPickerData(productItemViewHolder, ProductItemViewHolder.access$getPickerBottomSheet$p(productItemViewHolder));
        ProductItemViewHolder.access$getPickerBottomSheet$p(this.a).show();
        this.a.D.invoke();
        return Unit.INSTANCE;
    }
}
