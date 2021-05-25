package a2.a.a.o1.f;

import com.avito.android.messenger.analytics.PerformSearchQueryEvent;
import com.avito.android.messenger.search.ChannelsSearchInteractorImpl;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class i<T> implements Consumer<Disposable> {
    public final /* synthetic */ ChannelsSearchInteractorImpl.e a;

    public i(ChannelsSearchInteractorImpl.e eVar) {
        this.a = eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.d.r.track(new PerformSearchQueryEvent(this.a.c.getText()));
    }
}
