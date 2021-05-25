package a2.a.a.n2;

import com.avito.android.remote.model.SearchParams;
import com.avito.android.serp.SerpInteractorImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class i<T> implements Consumer<SearchParams> {
    public final /* synthetic */ SerpInteractorImpl a;

    public i(SerpInteractorImpl serpInteractorImpl) {
        this.a = serpInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SearchParams searchParams) {
        this.a.a = searchParams;
        this.a.c = null;
    }
}
