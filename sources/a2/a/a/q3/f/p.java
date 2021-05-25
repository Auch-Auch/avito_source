package a2.a.a.q3.f;

import a2.b.a.a.a;
import io.reactivex.functions.Predicate;
public final class p<T> implements Predicate<Integer> {
    public static final p a = new p();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Integer num) {
        if (a.f0(num, "it", 0) > 0) {
            return true;
        }
        return false;
    }
}
