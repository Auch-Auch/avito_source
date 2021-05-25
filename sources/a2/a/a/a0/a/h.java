package a2.a.a.a0.a;

import io.reactivex.rxjava3.functions.Predicate;
public final class h<T> implements Predicate<Boolean> {
    public static final h a = new h();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(Boolean bool) {
        return !bool.booleanValue();
    }
}
