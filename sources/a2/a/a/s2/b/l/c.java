package a2.a.a.s2.b.l;

import com.avito.android.shop.detailed.item.ShopRegularItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShopRegularItemView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ShopRegularItemPresenterImpl a;
    public final /* synthetic */ ShopRegularItemView b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ShopRegularItemPresenterImpl shopRegularItemPresenterImpl, ShopRegularItemView shopRegularItemView) {
        super(0);
        this.a = shopRegularItemPresenterImpl;
        this.b = shopRegularItemView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ShopRegularItemPresenterImpl.access$expand(this.a, this.b);
        return Unit.INSTANCE;
    }
}
