package n6.a;

import arrow.core.None;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function1<A, None> {
    public static final e a = new e();

    public e() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public None invoke(Object obj) {
        return None.INSTANCE;
    }
}
