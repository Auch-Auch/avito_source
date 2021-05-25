package a2.a.a.o1.c;

import a2.b.a.a.a;
import io.reactivex.functions.Function;
public final class b<T, R> implements Function<Integer, Boolean> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Boolean apply(Integer num) {
        boolean z = false;
        if (a.f0(num, "messageCount", 0) > 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
