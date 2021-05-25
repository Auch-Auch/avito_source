package a2.a.a.p0;

import com.avito.android.express_cv.ExpressCvActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ExpressCvActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ExpressCvActivity expressCvActivity) {
        super(0);
        this.a = expressCvActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.getViewModel().onReload();
        return Unit.INSTANCE;
    }
}
