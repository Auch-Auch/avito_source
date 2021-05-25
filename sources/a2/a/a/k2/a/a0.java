package a2.a.a.k2.a;

import com.avito.android.search.filter.FiltersPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a0 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ FiltersPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a0(FiltersPresenterImpl filtersPresenterImpl) {
        super(1);
        this.a = filtersPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        FiltersPresenterImpl.access$closeScreen(this.a);
        FiltersPresenterImpl.access$sendBackEvent(this.a, true);
        return Unit.INSTANCE;
    }
}
