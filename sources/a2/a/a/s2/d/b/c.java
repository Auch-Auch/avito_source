package a2.a.a.s2.d.b;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.shop.list.presentation.ShopListPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ ShopListPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ShopListPresenterImpl shopListPresenterImpl) {
        super(1);
        this.a = shopListPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        ShopListPresenterImpl shopListPresenterImpl = this.a;
        if (deepLink2 == null) {
            deepLink2 = new NoMatchLink();
        }
        ShopListPresenterImpl.access$onShortcutClick(shopListPresenterImpl, deepLink2);
        return Unit.INSTANCE;
    }
}
