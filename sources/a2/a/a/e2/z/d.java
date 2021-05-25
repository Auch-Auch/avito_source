package a2.a.a.e2.z;

import com.avito.android.publish.pretend.PretendViewModelKt;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.util.MultiStateLoading;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Throwable, MultiStateLoading<? super PretendResult>> {
    public static final d a = new d();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MultiStateLoading<? super PretendResult> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        return new MultiStateLoading.Error(PretendViewModelKt.access$toErrorResult(th2));
    }
}
