package a2.a.a.g1;

import com.avito.android.inline_filters.InlineFiltersPresenterImpl;
import com.avito.android.inline_filters.analytics.BottomSheetResetEvent;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<InlineFilterValue, Unit> {
    public final /* synthetic */ InlineFiltersPresenterImpl a;
    public final /* synthetic */ Filter b;
    public final /* synthetic */ SearchParams c;
    public final /* synthetic */ boolean d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(InlineFiltersPresenterImpl inlineFiltersPresenterImpl, Filter filter, SearchParams searchParams, boolean z) {
        super(1);
        this.a = inlineFiltersPresenterImpl;
        this.b = filter;
        this.c = searchParams;
        this.d = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(InlineFilterValue inlineFilterValue) {
        InlineFilterValue inlineFilterValue2 = inlineFilterValue;
        Intrinsics.checkNotNullParameter(inlineFilterValue2, "it");
        if (inlineFilterValue2.isEmpty()) {
            this.a.s.track(new BottomSheetResetEvent());
        }
        if (!Intrinsics.areEqual(this.b.getValue(), inlineFilterValue2)) {
            this.a.a(this.b, inlineFilterValue2, this.c, this.d);
        }
        this.a.k = null;
        return Unit.INSTANCE;
    }
}
