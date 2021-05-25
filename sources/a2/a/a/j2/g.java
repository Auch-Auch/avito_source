package a2.a.a.j2;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.remote.model.SubscriptionResult;
import com.avito.android.saved_searches.SavedSearchView;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import com.avito.android.saved_searches.SearchSubscribeReason;
import com.avito.android.saved_searches.analytics.SavedSearchDeleteEvent;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.TuplesKt;
import t6.y.l;
public final class g<T> implements Consumer<LoadingState<? super SubscriptionResult>> {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super SubscriptionResult> loadingState) {
        SearchPushSubscription subscription;
        String filterId;
        SearchPushSubscription subscription2;
        LoadingState<? super SubscriptionResult> loadingState2 = loadingState;
        SaveSearchLink saveSearchLink = null;
        if (((LoadingState.Loaded) (!(loadingState2 instanceof LoadingState.Loaded) ? null : loadingState2)) != null) {
            SavedSearchView savedSearchView = this.a.a.a;
            if (savedSearchView != null) {
                savedSearchView.showUnsubscriptionMessage();
            }
            Analytics analytics = this.a.a.n;
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
            SaveSearchLink uri = ((SubscriptionResult) loaded.getData()).uri();
            String xHash = (uri == null || (subscription2 = uri.getSubscription()) == null) ? null : subscription2.getXHash();
            SaveSearchLink uri2 = ((SubscriptionResult) loaded.getData()).uri();
            analytics.track(new SavedSearchDeleteEvent(xHash, (uri2 == null || (subscription = uri2.getSubscription()) == null || (filterId = subscription.getFilterId()) == null) ? null : l.toIntOrNull(filterId)));
            SavedSearchView savedSearchView2 = this.a.a.a;
            if (savedSearchView2 != null) {
                savedSearchView2.closeDialog();
            }
            SavedSearchesPresenterImpl.access$invalidateState(this.a.a);
            DeepLink searchSubscriptionAction = ((SubscriptionResult) loaded.getData()).getSearchSubscriptionAction();
            if (searchSubscriptionAction instanceof SaveSearchLink) {
                saveSearchLink = searchSubscriptionAction;
            }
            SaveSearchLink saveSearchLink2 = saveSearchLink;
            if (saveSearchLink2 != null) {
                this.a.a.c.accept(TuplesKt.to(SearchSubscribeReason.UNSUBSCRIBE, saveSearchLink2));
            }
        }
    }
}
