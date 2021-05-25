package a2.a.a.o1.d.a0.f;

import com.avito.android.util.Logs;
import com.avito.android.util.rx3.Singles;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
public final class b<T, R> implements Function<Throwable, SingleSource<? extends Boolean>> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Boolean> apply(Throwable th) {
        Logs.error("FileUploadInitializerImpl", "Attachment cache clearing error!", th);
        return Singles.toSingle(Boolean.FALSE);
    }
}
