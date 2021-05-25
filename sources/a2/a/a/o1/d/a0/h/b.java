package a2.a.a.o1.d.a0.h;

import com.jakewharton.rxrelay2.Relay;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ d a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(d dVar) {
        super(0);
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Relay<Unit> dismissStream = this.a.a.getDismissStream();
        Unit unit = Unit.INSTANCE;
        dismissStream.accept(unit);
        return unit;
    }
}
