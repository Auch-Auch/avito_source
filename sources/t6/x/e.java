package t6.x;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function1<T, T> {
    public static final e a = new e();

    public e() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(T t) {
        return t;
    }
}
