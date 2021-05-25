package a2.a.a.t1.e.a;

import com.jakewharton.rxrelay2.Relay;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Relay a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Relay relay) {
        super(0);
        this.a = relay;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Relay relay = this.a;
        Unit unit = Unit.INSTANCE;
        relay.accept(unit);
        return unit;
    }
}
