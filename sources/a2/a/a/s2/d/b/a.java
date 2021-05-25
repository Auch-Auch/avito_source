package a2.a.a.s2.d.b;

import com.avito.android.shop.list.business.ShopLocation;
import com.avito.android.shop.list.presentation.ShopListPresenterImpl;
import com.avito.android.shop.list.presentation.ShopListPresenterKt;
import com.avito.android.util.LoadingState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<LoadingState<? super ShopLocation>, Unit> {
    public final /* synthetic */ ShopListPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ShopListPresenterImpl shopListPresenterImpl) {
        super(1);
        this.a = shopListPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(LoadingState<? super ShopLocation> loadingState) {
        LoadingState<? super ShopLocation> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            ShopListPresenterImpl.access$updateLocationName(this.a, ShopListPresenterKt.access$getNameForHint((ShopLocation) ((LoadingState.Loaded) loadingState2).getData()));
        }
        return Unit.INSTANCE;
    }
}
