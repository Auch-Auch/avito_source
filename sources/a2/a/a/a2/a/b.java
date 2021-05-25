package a2.a.a.a2.a;

import io.reactivex.rxjava3.functions.Predicate;
public final class b<T> implements Predicate<Float> {
    public static final b a = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(Float f) {
        return f.floatValue() >= 0.0f;
    }
}
