package a2.a.a.a1;

import com.avito.android.home.HomePresenter;
import com.avito.android.home.HomePresenterImpl;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Pair;
public final class v<T> implements Consumer<Pair<? extends SnippetItem, ? extends Integer>> {
    public final /* synthetic */ HomePresenterImpl a;

    public v(HomePresenterImpl homePresenterImpl) {
        this.a = homePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Pair<? extends SnippetItem, ? extends Integer> pair) {
        SnippetItem snippetItem = (SnippetItem) pair.getFirst();
        HomePresenter.Router router = this.a.c;
        if (router != null) {
            router.followDeepLink(snippetItem.getAction().getDeepLink());
        }
    }
}
