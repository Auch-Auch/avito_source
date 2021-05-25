package a2.a.a.k2.c;

import com.avito.android.db.entity.SavedSearch;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.search.subscriptions.SearchSubscriptionSyncService;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<SearchSubscription> {
    public final /* synthetic */ SavedSearch a;
    public final /* synthetic */ SearchSubscriptionSyncService b;

    public a(SavedSearch savedSearch, SearchSubscriptionSyncService searchSubscriptionSyncService, Location location) {
        this.a = savedSearch;
        this.b = searchSubscriptionSyncService;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SearchSubscription searchSubscription) {
        this.b.getSavedSearchDao().remove(this.a);
    }
}
