package a2.a.a.s2.b.l;

import com.avito.android.shop.detailed.ShopHeaderListener;
import com.avito.android.shop.detailed.item.ShopGoldItemPresenterImpl;
import com.avito.android.shop.detailed.item.ShopGoldItemView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ShopGoldItemPresenterImpl a;
    public final /* synthetic */ ShopGoldItemView b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ShopGoldItemPresenterImpl shopGoldItemPresenterImpl, ShopGoldItemView shopGoldItemView) {
        super(0);
        this.a = shopGoldItemPresenterImpl;
        this.b = shopGoldItemView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ((ShopHeaderListener) this.a.g.get()).onContactsExpanded();
        this.a.a = true;
        ShopGoldItemPresenterImpl.access$expand(this.a, this.b);
        return Unit.INSTANCE;
    }
}
