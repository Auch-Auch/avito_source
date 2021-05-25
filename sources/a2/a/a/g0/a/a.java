package a2.a.a.g0.a;

import com.avito.android.connection_quality.connectivity.ConnectivityProviderImpl;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Unit, ObservableSource<? extends Connectivity>> {
    public final /* synthetic */ ConnectivityProviderImpl.b a;

    public a(ConnectivityProviderImpl.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Connectivity> apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return ReactiveNetwork.observeNetworkConnectivity(this.a.a.a).observeOn(this.a.b.computation()).doOnNext(b.a).doOnError(c.a);
    }
}
