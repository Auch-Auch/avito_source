package a2.a.a.e2.v;

import com.avito.android.publish.infomodel_request.InfomodelRequestViewModelKt;
import com.avito.android.util.MultiStateLoading;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<Throwable, MultiStateLoading<? super a>> {
    public static final f a = new f();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MultiStateLoading<? super a> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        return new MultiStateLoading.InitError(InfomodelRequestViewModelKt.access$toErrorResult(th2));
    }
}
