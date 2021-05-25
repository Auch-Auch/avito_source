package a2.a.a.p0;

import com.avito.android.express_cv.ExpressCvActivity;
import com.avito.android.express_cv.events.DialogParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class g extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ExpressCvActivity a;
    public final /* synthetic */ DialogParams b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(ExpressCvActivity expressCvActivity, DialogParams dialogParams) {
        super(0);
        this.a = expressCvActivity;
        this.b = dialogParams;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.getViewModel().onDialogDismiss(this.b.getAction());
        return Unit.INSTANCE;
    }
}
