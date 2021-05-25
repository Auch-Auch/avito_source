package a2.a.a.k2.b.h;

import com.avito.android.search.map.view.SerpListView;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<Boolean> {
    public final /* synthetic */ SerpListView a;

    public d(SerpListView serpListView) {
        this.a = serpListView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        this.a.e.invalidate();
    }
}
