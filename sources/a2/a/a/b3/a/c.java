package a2.a.a.b3.a;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Consumer a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Consumer consumer) {
        super(0);
        this.a = consumer;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Consumer consumer = this.a;
        Unit unit = Unit.INSTANCE;
        consumer.accept(unit);
        return unit;
    }
}
