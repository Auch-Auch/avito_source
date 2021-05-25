package a2.a.a.z.a.g;

import a2.b.a.a.a;
import com.avito.android.calls.voximplant.rx.VoxCallClientSession;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
public final class m<T, R> implements Function<String, CompletableSource> {
    public final /* synthetic */ VoxCallClientSession.b a;

    public m(VoxCallClientSession.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(String str) {
        String str2 = str;
        Logs.debug$default(LogTagsKt.TAG_IAC, a.d3("Got username = [", str2, ']'), null, 4, null);
        return Completable.fromCallable(new l(this, str2));
    }
}
