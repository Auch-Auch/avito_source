package a2.a.a.j2;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import com.avito.android.saved_searches.analytics.SavedSearchChangedEvent;
import io.reactivex.rxjava3.functions.Consumer;
public final class f<T> implements Consumer<Integer> {
    public final /* synthetic */ SavedSearchesPresenterImpl a;

    public f(SavedSearchesPresenterImpl savedSearchesPresenterImpl) {
        this.a = savedSearchesPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Integer num) {
        Integer num2 = num;
        Analytics analytics = this.a.n;
        SearchPushSubscription searchPushSubscription = this.a.h;
        analytics.track(new SavedSearchChangedEvent(searchPushSubscription != null ? searchPushSubscription.getTitle() : null, null, null, String.valueOf(num2.intValue()), 6, null));
        this.a.f = num2;
    }
}
