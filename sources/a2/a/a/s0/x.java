package a2.a.a.s0;

import android.net.Uri;
import com.avito.android.favorite_sellers.FavoriteSellersPresenterImpl;
import com.avito.android.favorite_sellers.adapter.error.ErrorItem;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class x extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ FavoriteSellersPresenterImpl a;
    public final /* synthetic */ Uri b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(FavoriteSellersPresenterImpl favoriteSellersPresenterImpl, Uri uri) {
        super(1);
        this.a = favoriteSellersPresenterImpl;
        this.b = uri;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "it");
        if (this.a.I.isConnectionAvailable()) {
            str2 = this.a.w.loadingErrorText();
        }
        CompositeSnackbarPresenter.DefaultImpls.showSnackbar$default(this.a.K, str2, 0, null, 0, null, 0, null, null, 254, null);
        FavoriteSellersPresenterImpl favoriteSellersPresenterImpl = this.a;
        List list = favoriteSellersPresenterImpl.i;
        List access$withoutErrors = list != null ? FavoriteSellersPresenterImpl.access$withoutErrors(this.a, list) : null;
        if (access$withoutErrors == null) {
            access$withoutErrors = CollectionsKt__CollectionsKt.emptyList();
        }
        favoriteSellersPresenterImpl.i = CollectionsKt___CollectionsKt.plus((Collection<? extends ErrorItem>) access$withoutErrors, new ErrorItem(str2, this.b));
        return Unit.INSTANCE;
    }
}
