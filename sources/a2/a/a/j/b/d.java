package a2.a.a.j.b;

import androidx.work.ListenableWorker;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Throwable, ListenableWorker.Result> {
    public static final d a = new d();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ListenableWorker.Result apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return ListenableWorker.Result.retry();
    }
}
