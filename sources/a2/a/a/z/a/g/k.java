package a2.a.a.z.a.g;

import com.avito.android.calls.voximplant.rx.core.CallClientException;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
public final class k<T, R> implements Function<Throwable, SingleSource<? extends String>> {
    public static final k a = new k();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends String> apply(Throwable th) {
        Logs.error$default(LogTagsKt.TAG_IAC, "Failed to get username", null, 4, null);
        return Single.error(new CallClientException.CantGetUsernameException());
    }
}
