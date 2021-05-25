package a2.a.a.k2.c;

import a2.b.a.a.a;
import com.avito.android.db.entity.SavedSearch;
import com.avito.android.remote.model.Location;
import com.avito.android.search.subscriptions.SearchSubscriptionSyncService;
import com.avito.android.util.AvitoResponseException;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ SavedSearch a;
    public final /* synthetic */ SearchSubscriptionSyncService b;

    public b(SavedSearch savedSearch, SearchSubscriptionSyncService searchSubscriptionSyncService, Location location) {
        this.a = savedSearch;
        this.b = searchSubscriptionSyncService;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        if (!(th2 instanceof AvitoResponseException)) {
            Logs.error("SavedSearchSyncService", "failed to save subscription to server, will upload next time", th2);
        } else if (((AvitoResponseException) th2).getError().code == 400) {
            StringBuilder L = a.L("Failed to upload saved search ");
            L.append(this.a.searchParams);
            Logs.error$default("SavedSearchSyncService", L.toString(), null, 4, null);
            this.b.getSavedSearchDao().remove(this.a);
        }
    }
}
