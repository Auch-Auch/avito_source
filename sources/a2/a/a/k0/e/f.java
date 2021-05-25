package a2.a.a.k0.e;

import com.avito.android.delivery.analytics.summary.ChangeType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ g a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(g gVar) {
        super(1);
        this.a = gVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        this.a.a.setValue(num.intValue());
        g gVar = this.a;
        gVar.b.b.onStepperClicked(gVar.a.getValue(), ChangeType.NUMBER);
        return Unit.INSTANCE;
    }
}
