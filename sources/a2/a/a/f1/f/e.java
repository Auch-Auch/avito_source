package a2.a.a.f1.f;

import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.in_app_calls.service.CallInfoLoaderImpl;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class e<T> implements Consumer<Disposable> {
    public final /* synthetic */ CallInfoLoaderImpl.a a;

    public e(CallInfoLoaderImpl.a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.a.d.track(new StatsdEvent.CountEvent("calls.in.info.start", 0, 2, null));
    }
}
