package a2.a.a.t0;

import com.avito.android.favorites.FavoritesListPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class u0 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ FavoritesListPresenterImpl.q a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u0(FavoritesListPresenterImpl.q qVar) {
        super(1);
        this.a = qVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        this.a.a.i();
        return Unit.INSTANCE;
    }
}
