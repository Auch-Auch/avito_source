package a2.a.a.b2.e1;

import com.avito.android.util.NotFoundException;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class t<T, R> implements Function<Throwable, Boolean> {
    public static final t a = new t();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Boolean apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        return Boolean.valueOf(!(th2 instanceof NotFoundException));
    }
}
