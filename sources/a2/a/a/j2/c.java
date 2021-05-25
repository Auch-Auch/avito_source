package a2.a.a.j2;

import com.avito.android.saved_searches.SavedSearchView;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ SavedSearchesPresenterImpl a;

    public c(SavedSearchesPresenterImpl savedSearchesPresenterImpl) {
        this.a = savedSearchesPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        SavedSearchView savedSearchView = this.a.a;
        if (savedSearchView != null) {
            savedSearchView.showErrorMessage();
        }
        Logs.error(th2);
    }
}
