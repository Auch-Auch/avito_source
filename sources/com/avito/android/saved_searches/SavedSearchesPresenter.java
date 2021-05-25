package com.avito.android.saved_searches;

import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.util.Kundle;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH&¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH&¢\u0006\u0004\b\u0016\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "subscriptionParams", "", "fromSource", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "", "openSubscriptionDialog", "(Lcom/avito/android/deep_linking/links/SearchPushSubscription;Ljava/lang/String;Lcom/avito/android/remote/model/search/map/Area;)V", "", "isPushEnabled", "setPushEnabled", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Pair;", "Lcom/avito/android/saved_searches/SearchSubscribeReason;", "Lcom/avito/android/deep_linking/links/SaveSearchLink;", "subscribeAction", "()Lio/reactivex/rxjava3/core/Observable;", "requestAuthAction", "showSettingsAction", "Lcom/avito/android/saved_searches/SavedSearchView;", "view", "attachView", "(Lcom/avito/android/saved_searches/SavedSearchView;Z)V", "detachView", "()V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "saved-searches_release"}, k = 1, mv = {1, 4, 2})
public interface SavedSearchesPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void openSubscriptionDialog$default(SavedSearchesPresenter savedSearchesPresenter, SearchPushSubscription searchPushSubscription, String str, Area area, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    area = null;
                }
                savedSearchesPresenter.openSubscriptionDialog(searchPushSubscription, str, area);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSubscriptionDialog");
        }
    }

    void attachView(@NotNull SavedSearchView savedSearchView, boolean z);

    void detachView();

    @NotNull
    Kundle onSaveState();

    void openSubscriptionDialog(@NotNull SearchPushSubscription searchPushSubscription, @Nullable String str, @Nullable Area area);

    @NotNull
    Observable<Unit> requestAuthAction();

    void setPushEnabled(boolean z);

    @NotNull
    Observable<Unit> showSettingsAction();

    @NotNull
    Observable<Pair<SearchSubscribeReason, SaveSearchLink>> subscribeAction();
}
