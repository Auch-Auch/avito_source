package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersView;
import com.avito.android.favorite_sellers.adapter.seller.SellerItem;
import io.reactivex.rxjava3.functions.Action;
import kotlin.jvm.internal.Intrinsics;
public final class d implements Action {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ FavoriteSellersView d;

    public d(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, boolean z, String str, FavoriteSellersView favoriteSellersView) {
        this.a = favoriteSellersPresenterImpl;
        this.b = z;
        this.c = str;
        this.d = favoriteSellersView;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        SellerItem sellerItem = this.a.r;
        if (sellerItem != null) {
            sellerItem.setNotificationsActivated(Boolean.valueOf(this.b));
        }
        FavoriteSellersPresenterImpl.n(this.a, this.c, null, Boolean.valueOf(this.b), false, 10);
        SellerItem sellerItem2 = this.a.r;
        if (Intrinsics.areEqual(sellerItem2 != null ? sellerItem2.getUserKey() : null, this.c)) {
            this.d.setNotificationActivated(this.b);
        }
    }
}
