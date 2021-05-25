package a2.a.a.a1.c0;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import org.funktionale.option.Option;
public final class j<T, R> implements Function<Throwable, MaybeSource<? extends Option<? extends Boolean>>> {
    public static final j a = new j();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MaybeSource<? extends Option<? extends Boolean>> apply(Throwable th) {
        return Maybe.never();
    }
}
