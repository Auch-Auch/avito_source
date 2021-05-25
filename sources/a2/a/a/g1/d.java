package a2.a.a.g1;

import com.avito.android.inline_filters.InlineFiltersPresenterImpl;
import com.avito.android.inline_filters.analytics.BottomSheetCloseEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ InlineFiltersPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(InlineFiltersPresenterImpl inlineFiltersPresenterImpl) {
        super(0);
        this.a = inlineFiltersPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.s.track(new BottomSheetCloseEvent());
        this.a.k = null;
        return Unit.INSTANCE;
    }
}
