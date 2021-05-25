package defpackage;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.FavoriteSellersView;
import com.avito.android.favorite_sellers.SubscribableItem;
import io.reactivex.rxjava3.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: o0  reason: default package */
public final class o0 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public o0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            ((SubscribableItem) this.c).setSubscribeLoading(false);
            FavoriteSellersView favoriteSellersView = ((FavoriteSellersPresenterImpl) this.b).a;
            if (favoriteSellersView != null) {
                favoriteSellersView.hideUndoProgress();
            }
        } else if (i == 1) {
            ((SubscribableItem) this.c).setSubscribeLoading(false);
            FavoriteSellersView favoriteSellersView2 = ((FavoriteSellersPresenterImpl) this.b).a;
            if (favoriteSellersView2 != null) {
                favoriteSellersView2.hideUndoProgress();
            }
        } else {
            throw null;
        }
    }
}
