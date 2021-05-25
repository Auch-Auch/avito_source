package defpackage;

import com.avito.android.remote.model.LinkAction;
import com.avito.android.shop.list.presentation.ShopListPresenterImpl;
import com.avito.android.shop.list.presentation.ShopListRouter;
import com.avito.android.shop.list.presentation.ShopListView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: a4  reason: default package */
public final class a4 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a4(int i, Object obj) {
        super(1);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Unit unit) {
        ShopListRouter shopListRouter;
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(unit, "it");
            ShopListRouter shopListRouter2 = ((ShopListPresenterImpl) this.b).d;
            if (shopListRouter2 != null) {
                shopListRouter2.showClarifyScreen(((ShopListPresenterImpl) this.b).k);
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(unit, "it");
            ShopListRouter shopListRouter3 = ((ShopListPresenterImpl) this.b).d;
            if (shopListRouter3 != null) {
                shopListRouter3.close();
            }
            return Unit.INSTANCE;
        } else if (i == 2) {
            Intrinsics.checkNotNullParameter(unit, "it");
            ((ShopListPresenterImpl) this.b).n.clearError();
            ShopListView shopListView = ((ShopListPresenterImpl) this.b).c;
            if (shopListView != null) {
                shopListView.setPullRefreshEnabled(true);
            }
            ((ShopListPresenterImpl) this.b).onAppend();
            return Unit.INSTANCE;
        } else if (i == 3) {
            Intrinsics.checkNotNullParameter(unit, "it");
            LinkAction linkAction = ((ShopListPresenterImpl) this.b).g;
            if (!(linkAction == null || (shopListRouter = ((ShopListPresenterImpl) this.b).d) == null)) {
                shopListRouter.openLink(linkAction.getLink());
            }
            return Unit.INSTANCE;
        } else if (i == 4) {
            Intrinsics.checkNotNullParameter(unit, "it");
            ((ShopListPresenterImpl) this.b).n.invalidate();
            ((ShopListPresenterImpl) this.b).c(false);
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
