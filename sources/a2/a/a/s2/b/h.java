package a2.a.a.s2.b;

import com.avito.android.analytics.source.ShopContactsSource;
import com.avito.android.remote.model.Action;
import com.avito.android.shop.detailed.ShopDetailedPresenterImpl;
import com.avito.android.shop.detailed.item.ShopDetailedRedesignView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Action a;
    public final /* synthetic */ ShopDetailedPresenterImpl b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Action action, ShopDetailedPresenterImpl shopDetailedPresenterImpl) {
        super(0);
        this.a = action;
        this.b = shopDetailedPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ShopDetailedRedesignView shopDetailedRedesignView = this.b.g;
        if (shopDetailedRedesignView != null) {
            shopDetailedRedesignView.closePhoneDialog();
        }
        this.b.onDeepLinkFollowed(this.a.getDeepLink(), ShopContactsSource.PHONE);
        return Unit.INSTANCE;
    }
}
