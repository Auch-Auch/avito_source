package a2.a.a.j.b;

import io.reactivex.functions.Function;
public final class a<T, R> implements Function<Integer, Boolean> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Boolean apply(Integer num) {
        boolean z = false;
        if (a2.b.a.a.a.f0(num, "count", 0) > 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
