package a2.a.a.f.x.b0;

import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionItem;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenterImpl;
import com.avito.android.deep_linking.links.ChainedDeepLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Action;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SellerSubscriptionPresenterImpl a;
    public final /* synthetic */ ErrorResult.ErrorDialog b;
    public final /* synthetic */ AdvertDetailsSellerSubscriptionItem c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(SellerSubscriptionPresenterImpl sellerSubscriptionPresenterImpl, ErrorResult.ErrorDialog errorDialog, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
        super(0);
        this.a = sellerSubscriptionPresenterImpl;
        this.b = errorDialog;
        this.c = advertDetailsSellerSubscriptionItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Action action;
        DeepLink deepLink;
        List<Action> actions = this.b.getUserDialog().getActions();
        if (!(actions == null || (action = actions.get(0)) == null || (deepLink = action.getDeepLink()) == null)) {
            if (deepLink instanceof ChainedDeepLink) {
                this.a.k = ((ChainedDeepLink) deepLink).getThen();
                this.a.l = this.c;
            }
            SellerSubscriptionPresenter.Router router = this.a.f;
            if (router != null) {
                router.followDeepLink(deepLink, 15);
            }
        }
        return Unit.INSTANCE;
    }
}
