package a2.a.a.z.a.g.q;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.calls.voximplant.rx.core.CallClientException;
import com.avito.android.calls.voximplant.rx.core.VoxSessionManager;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
public final class d<T, R> implements Function<Option<? extends String>, CompletableSource> {
    public final /* synthetic */ VoxSessionManager a;
    public final /* synthetic */ String b;

    public d(VoxSessionManager voxSessionManager, String str) {
        this.a = voxSessionManager;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(Option<? extends String> option) {
        Option<? extends String> option2 = option;
        if (option2 instanceof None) {
            return Completable.error(new CallClientException.InvalidOneTimeKeyException());
        }
        if (option2 instanceof Some) {
            return Completable.fromCallable(new c((String) ((Some) option2).getT(), this));
        }
        throw new NoWhenBranchMatchedException();
    }
}
