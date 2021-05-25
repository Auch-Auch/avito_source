package a2.a.a.k2.c;

import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.search.subscriptions.SubscribeSearchInteractorImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<SearchSubscription> {
    public final /* synthetic */ SubscribeSearchInteractorImpl a;

    public c(SubscribeSearchInteractorImpl subscribeSearchInteractorImpl) {
        this.a = subscribeSearchInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SearchSubscription searchSubscription) {
        this.a.b.saveSearchSubscription(searchSubscription);
    }
}
