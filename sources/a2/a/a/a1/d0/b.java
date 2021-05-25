package a2.a.a.a1.d0;

import com.avito.android.home.tabs_item.SectionTabsItemViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SectionTabsItemViewImpl.b a;
    public final /* synthetic */ int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(SectionTabsItemViewImpl.b bVar, int i) {
        super(0);
        this.a = bVar;
        this.b = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Function1<? super Integer, Unit> function1 = this.a.e;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.b));
        }
        return Unit.INSTANCE;
    }
}
