package a2.a.a.s2.d.b;

import com.avito.android.shop.list.presentation.ShopListPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ ShopListPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ShopListPresenterImpl shopListPresenterImpl) {
        super(1);
        this.a = shopListPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        ShopListPresenterImpl.access$onSearchStateChanged(this.a, bool.booleanValue());
        return Unit.INSTANCE;
    }
}
