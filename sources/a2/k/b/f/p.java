package a2.k.b.f;

import android.widget.SearchView;
import io.reactivex.rxjava3.functions.Consumer;
public final class p<T> implements Consumer<CharSequence> {
    public final /* synthetic */ SearchView a;
    public final /* synthetic */ boolean b;

    public p(SearchView searchView, boolean z) {
        this.a = searchView;
        this.b = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(CharSequence charSequence) {
        this.a.setQuery(charSequence, this.b);
    }
}
