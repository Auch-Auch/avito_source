package a2.a.a.g1;

import com.avito.android.inline_filters.InlineFiltersPresenterImpl;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ InlineFiltersPresenterImpl a;

    public b(InlineFiltersPresenterImpl inlineFiltersPresenterImpl) {
        this.a = inlineFiltersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        this.a.t.trackShortcutsLoadError();
        Logs.error(th2);
        this.a.j.accept(th2);
    }
}
