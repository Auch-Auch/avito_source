package a2.a.a.o1.c;

import com.avito.android.messenger.connection.AvitoMessengerKeepConnectionProvider;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.q;
public final class a<T, R> implements Function<Observable<Throwable>, ObservableSource<?>> {
    public final /* synthetic */ AvitoMessengerKeepConnectionProvider.a a;

    public a(AvitoMessengerKeepConnectionProvider.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<?> apply(Observable<Throwable> observable) {
        Observable<Throwable> observable2 = observable;
        Intrinsics.checkNotNullParameter(observable2, "errors");
        return this.a.a.g.handleErrors(observable2, "pendingMessageCount", q.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, ChannelContext.Item.USER_ID)));
    }
}
