package a2.a.a.z.a.g;

import com.avito.android.calls.voximplant.rx.VoxCallClientConnection;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
public final class e<T, R> implements Function<Throwable, CompletableSource> {
    public final /* synthetic */ VoxCallClientConnection a;

    public e(VoxCallClientConnection voxCallClientConnection) {
        this.a = voxCallClientConnection;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(Throwable th) {
        return this.a.a.firstOrError().flatMapCompletable(new d(th));
    }
}
