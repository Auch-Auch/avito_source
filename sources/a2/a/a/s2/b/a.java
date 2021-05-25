package a2.a.a.s2.b;

import com.avito.android.shop.detailed.ShopDetailedFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<Exception, Unit> {
    public final /* synthetic */ ShopDetailedFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ShopDetailedFragment shopDetailedFragment) {
        super(1);
        this.a = shopDetailedFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        this.a.getPresenter().onCallFailed();
        return Unit.INSTANCE;
    }
}
