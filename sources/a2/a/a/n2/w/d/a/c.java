package a2.a.a.n2.w.d.a;

import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenterImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterView;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ VerticalFilterPresenterImpl a;

    public c(VerticalFilterPresenterImpl verticalFilterPresenterImpl) {
        this.a = verticalFilterPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        VerticalFilterView verticalFilterView = this.a.d;
        if (verticalFilterView != null) {
            verticalFilterView.setSubmitState(true, false, null);
        }
        Logs.error("VerticalFilterPresenterImpl", "load search form filter error", th2);
        this.a.b.accept(th2);
    }
}
