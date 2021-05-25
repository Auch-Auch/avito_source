package defpackage;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersView;
import com.avito.android.favorite_sellers.SubscribableItem;
import com.avito.android.favorite_sellers.adapter.seller.SellerItem;
import io.reactivex.rxjava3.functions.Action;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: p1  reason: default package */
public final class p1 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public p1(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        FavoriteSellersView favoriteSellersView;
        FavoriteSellersView favoriteSellersView2;
        int i = this.a;
        String str = null;
        if (i == 0) {
            ((SubscribableItem) this.c).setSubscribeLoading(false);
            SellerItem sellerItem = ((FavoriteSellersPresenterImpl) this.b).r;
            if (sellerItem != null) {
                str = sellerItem.getUserKey();
            }
            if (Intrinsics.areEqual(str, ((SubscribableItem) this.c).getUserKey()) && (favoriteSellersView = ((FavoriteSellersPresenterImpl) this.b).a) != null) {
                favoriteSellersView.setUnsubscribeLoading(false);
            }
        } else if (i == 1) {
            ((SubscribableItem) this.c).setSubscribeLoading(false);
            SellerItem sellerItem2 = ((FavoriteSellersPresenterImpl) this.b).r;
            if (sellerItem2 != null) {
                str = sellerItem2.getUserKey();
            }
            if (Intrinsics.areEqual(str, ((SubscribableItem) this.c).getUserKey()) && (favoriteSellersView2 = ((FavoriteSellersPresenterImpl) this.b).a) != null) {
                favoriteSellersView2.setUnsubscribeLoading(false);
            }
        } else if (i == 2) {
            FavoriteSellersPresenterImpl.n((FavoriteSellersPresenterImpl) this.b, ((SubscribableItem) this.c).getUserKey(), Boolean.FALSE, null, false, 12);
            FavoriteSellersView favoriteSellersView3 = ((FavoriteSellersPresenterImpl) this.b).a;
            if (favoriteSellersView3 != null) {
                favoriteSellersView3.closeSubscriptionSettings();
            }
        } else {
            throw null;
        }
    }
}
