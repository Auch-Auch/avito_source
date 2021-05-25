package a2.a.a.a0.a.q.a;

import com.avito.android.cart.summary.konveyor.product.ProductItemViewHolder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ ProductItemViewHolder a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ProductItemViewHolder productItemViewHolder) {
        super(1);
        this.a = productItemViewHolder;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        this.a.C.invoke(Integer.valueOf(num.intValue()));
        return Unit.INSTANCE;
    }
}
