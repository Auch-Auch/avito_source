package a2.a.a.a1;

import com.avito.android.home.HomePresenterImpl;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class i<T> implements Consumer<Throwable> {
    public final /* synthetic */ HomePresenterImpl a;

    public i(HomePresenterImpl homePresenterImpl) {
        this.a = homePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.ErrorFormatter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        HomePresenterImpl.access$onFatalErrorPrepareAdverts(this.a, this.a.p.format(th2));
        Logs.error("HomePresenter", "Error loadHomePageAdverts", th2);
    }
}
