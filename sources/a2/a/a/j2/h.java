package a2.a.a.j2;

import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class h<T> implements Consumer<Unit> {
    public final /* synthetic */ SavedSearchesPresenterImpl a;

    public h(SavedSearchesPresenterImpl savedSearchesPresenterImpl) {
        this.a = savedSearchesPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        String filterId;
        SearchPushSubscription searchPushSubscription = this.a.h;
        if (searchPushSubscription != null && (filterId = searchPushSubscription.getFilterId()) != null) {
            this.a.k.unsubscribeFromSearch(filterId).observeOn(this.a.l.mainThread()).subscribe(new g(this));
        }
    }
}
