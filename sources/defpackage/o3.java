package defpackage;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersView;
import com.avito.android.favorite_sellers.SubscribableItem;
import com.avito.android.favorite_sellers.adapter.seller.SellerItem;
import io.reactivex.rxjava3.functions.Action;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: o3  reason: default package */
public final class o3 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public o3(int i, Object obj, Object obj2, Object obj3, Object obj4) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.a;
        String str = null;
        if (i == 0) {
            ((SubscribableItem) this.c).setNotificationsLoading(false);
            SellerItem sellerItem = ((FavoriteSellersPresenterImpl) this.b).r;
            if (sellerItem != null) {
                str = sellerItem.getUserKey();
            }
            if (Intrinsics.areEqual(str, (String) this.d)) {
                ((FavoriteSellersView) this.e).setNotificationLoading(false);
            }
        } else if (i == 1) {
            ((SubscribableItem) this.c).setNotificationsLoading(false);
            SellerItem sellerItem2 = ((FavoriteSellersPresenterImpl) this.b).r;
            if (sellerItem2 != null) {
                str = sellerItem2.getUserKey();
            }
            if (Intrinsics.areEqual(str, (String) this.d)) {
                ((FavoriteSellersView) this.e).setNotificationLoading(false);
            }
        } else {
            throw null;
        }
    }
}
