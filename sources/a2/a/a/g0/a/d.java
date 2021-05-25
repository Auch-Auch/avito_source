package a2.a.a.g0.a;

import com.avito.android.connection_quality.connectivity.ConnectivityProviderKt;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<Connectivity> {
    public final /* synthetic */ BehaviorRelay a;

    public d(BehaviorRelay behaviorRelay) {
        this.a = behaviorRelay;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Connectivity connectivity) {
        Connectivity connectivity2 = connectivity;
        BehaviorRelay behaviorRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(connectivity2, "connectivity");
        behaviorRelay.accept(Boolean.valueOf(ConnectivityProviderKt.access$isConnected$p(connectivity2)));
    }
}
