package a2.a.a.g1.e.d;

import com.avito.android.inline_filters.dialog.select.SelectFilterView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class n extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ SelectFilterView a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(SelectFilterView selectFilterView) {
        super(1);
        this.a = selectFilterView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        SelectFilterView.access$onItemClicked(this.a, num.intValue());
        return Unit.INSTANCE;
    }
}
