package a2.a.a.t1.b;

import com.avito.android.remote.model.PretendResult;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Predicate<PretendResult> {
    public static final h a = new h();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(PretendResult pretendResult) {
        PretendResult pretendResult2 = pretendResult;
        Intrinsics.checkNotNullParameter(pretendResult2, "it");
        return pretendResult2.getSuccess();
    }
}
