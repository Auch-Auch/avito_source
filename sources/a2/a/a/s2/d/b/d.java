package a2.a.a.s2.d.b;

import com.avito.android.shop.list.presentation.ShopListPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ ShopListPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ShopListPresenterImpl shopListPresenterImpl) {
        super(1);
        this.a = shopListPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "it");
        ShopListPresenterImpl.access$onQuerySubmitted(this.a, str2);
        return Unit.INSTANCE;
    }
}
