package a2.a.a.a1;

import com.avito.android.home.HomePresenter;
import com.avito.android.home.HomePresenterImpl;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import com.avito.android.remote.model.search.suggest.SuggestDeeplink;
import io.reactivex.rxjava3.functions.Consumer;
public final class y<T> implements Consumer<SuggestAction> {
    public final /* synthetic */ HomePresenterImpl a;

    public y(HomePresenterImpl homePresenterImpl) {
        this.a = homePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SuggestAction suggestAction) {
        SuggestAction suggestAction2 = suggestAction;
        if (suggestAction2 instanceof SuggestDeeplink) {
            this.a.b();
            HomePresenter.Router router = this.a.c;
            if (router != null) {
                router.followDeepLink(((SuggestDeeplink) suggestAction2).getDeepLink(), this.a.q.getParent());
            }
        } else if (suggestAction2 instanceof SuggestAnalyticsEvent) {
            this.a.q.sendClickSearchSuggest((SuggestAnalyticsEvent) suggestAction2);
        }
    }
}
