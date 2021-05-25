package n6.a;

import arrow.core.Some;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<B, Some<? extends B>> {
    public static final d a = new d();

    public d() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return new Some(obj);
    }
}
