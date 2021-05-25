package a2.a.a.s2.d.b;

import com.avito.android.shop.list.business.ShopLocation;
import com.avito.android.shop.list.presentation.ShopListPresenterImpl;
import com.avito.android.shop.list.presentation.ShopListPresenterKt;
import com.avito.android.shop.list.presentation.ShopListView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<ShopLocation, Unit> {
    public final /* synthetic */ ShopListPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ShopListPresenterImpl shopListPresenterImpl) {
        super(1);
        this.a = shopListPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ShopLocation shopLocation) {
        ShopLocation shopLocation2 = shopLocation;
        if (!Intrinsics.areEqual(shopLocation2.getId(), this.a.k.getLocationId())) {
            ShopListPresenterImpl.access$invalidateState(this.a);
            ShopListView shopListView = this.a.c;
            if (shopListView != null) {
                shopListView.scrollToTop(true);
            }
            ShopListPresenterImpl.access$saveLocationId(this.a, shopLocation2.getId());
            ShopListPresenterImpl shopListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(shopLocation2, "it");
            ShopListPresenterImpl.access$updateLocationName(shopListPresenterImpl, ShopListPresenterKt.access$getNameForHint(shopLocation2));
            this.a.c(false);
        }
        return Unit.INSTANCE;
    }
}
