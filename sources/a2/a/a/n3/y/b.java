package a2.a.a.n3.y;

import com.avito.android.util.rx.ErrorAndDuration;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<Long, ErrorAndDuration> {
    public final /* synthetic */ ErrorAndDuration a;

    public b(ErrorAndDuration errorAndDuration) {
        this.a = errorAndDuration;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ErrorAndDuration apply(Long l) {
        Intrinsics.checkNotNullParameter(l, "it");
        return this.a;
    }
}
