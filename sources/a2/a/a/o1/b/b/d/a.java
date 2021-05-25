package a2.a.a.o1.b.b.d;

import arrow.core.Option;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Predicate<Option<? extends Long>> {
    public static final a a = new a();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Option<? extends Long> option) {
        Option<? extends Long> option2 = option;
        Intrinsics.checkNotNullParameter(option2, "timestampOption");
        return option2.isDefined();
    }
}
