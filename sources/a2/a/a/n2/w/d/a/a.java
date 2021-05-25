package a2.a.a.n2.w.d.a;

import com.avito.android.serp.adapter.vertical_main.analytics.SearchWidgetAction;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ VerticalFilterPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(VerticalFilterPresenterImpl verticalFilterPresenterImpl) {
        super(0);
        this.a = verticalFilterPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.b(SearchWidgetAction.BY_CLICK);
        return Unit.INSTANCE;
    }
}
