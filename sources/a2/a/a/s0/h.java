package a2.a.a.s0;

import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl) {
        super(1);
        this.a = favoriteSellersPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "it");
        CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(this.a.K, str2, 0, null, 0, null, 0, null, null, 254, null);
        return Unit.INSTANCE;
    }
}
