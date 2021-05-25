package a2.a.a.o1.b.b.a.d;

import com.avito.android.messenger.channels.mvi.common.v4.ReducibleKt;
import com.avito.android.util.Logs;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class k<T, R> implements Function<Throwable, S> {
    public final /* synthetic */ ReducibleKt.b a;
    public final /* synthetic */ Object b;

    public k(ReducibleKt.b bVar, Object obj) {
        this.a = bVar;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Object apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        Logs.error(this.a.a.getName(), this.a.a.getParams(), th2);
        return this.b;
    }
}
