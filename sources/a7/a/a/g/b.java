package a7.a.a.g;

import com.avito.android.util.Views;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.avito.component.serp.SerpAdvertTileCardImpl;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SerpAdvertTileCardImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(SerpAdvertTileCardImpl serpAdvertTileCardImpl) {
        super(0);
        this.a = serpAdvertTileCardImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Views.conceal(this.a.b);
        return Unit.INSTANCE;
    }
}
