package a2.a.a.o1.b.b.a.d;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class j<T, R> implements Function<Object, S> {
    public final /* synthetic */ Object a;

    public j(Object obj) {
        this.a = obj;
    }

    @Override // io.reactivex.functions.Function
    public final S apply(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return (S) this.a;
    }
}
