package a2.a.a.f1.f;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.remote.CallInfo;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.TypedResultException;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
public final class b<T, R> implements Function<TypedResult<CallInfo>, SingleSource<? extends Option<? extends CallInfo>>> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Option<? extends CallInfo>> apply(TypedResult<CallInfo> typedResult) {
        TypedResult<CallInfo> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfError) {
            return Single.error(new TypedResultException(((TypedResult.OfError) typedResult2).getError()));
        }
        if (typedResult2 instanceof TypedResult.OfResult) {
            return Single.just(OptionKt.toOption(((TypedResult.OfResult) typedResult2).getResult()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
