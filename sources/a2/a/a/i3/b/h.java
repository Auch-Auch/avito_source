package a2.a.a.i3.b;

import com.avito.android.user_adverts.items_search.SearchBarImpl;
import com.avito.android.user_adverts.items_search.SearchBarInteractor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Consumer<String> {
    public final /* synthetic */ SearchBarImpl a;

    public h(SearchBarImpl searchBarImpl) {
        this.a = searchBarImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        SearchBarInteractor searchBarInteractor = this.a.e;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        searchBarInteractor.loadSuggestions(str2);
    }
}
