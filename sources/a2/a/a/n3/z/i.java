package a2.a.a.n3.z;

import com.avito.android.util.rx3.ErrorAndDuration;
import io.reactivex.rxjava3.functions.Function;
public final class i<T, R> implements Function<Long, ErrorAndDuration> {
    public final /* synthetic */ ErrorAndDuration a;

    public i(ErrorAndDuration errorAndDuration) {
        this.a = errorAndDuration;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ErrorAndDuration apply(Long l) {
        return this.a;
    }
}
